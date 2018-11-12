package com.example.lishan.timbo_min.ui.home;

import android.content.Intent;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.bumptech.glide.Glide;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.HealthPageListAdapter;
import com.example.lishan.timbo_min.adapter.HealthPage_DetailsAdpater;
import com.example.lishan.timbo_min.adapter.HealthPage_DetailsChlidAdpater;
import com.example.lishan.timbo_min.bean.HealthPageDetailsBean;
import com.example.lishan.timbo_min.bean.HealthPagerListBean;
import com.example.lishan.timbo_min.bean.ItemCommentsBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.common.ComantUtils;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.CustomFooterViewCallBack;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.header.material.CircleImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by lishan on 2017/12/22.
 */

public class Act_HealthPage_Details extends BaseAct implements HealthPage_DetailsAdpater.ItemClickCallBack, CustomFooterViewCallBack {
    private HttpReqest httpReqest = new HttpReqest();
    private ACache aCache;
    private String aid;
    private Gson gson = new Gson();
    private TextView title, tvContext, pageTitle, hits, comments, name;
    private ImageView myHaderImge;
    private de.hdodenhof.circleimageview.CircleImageView hader;
    private LinearLayout liner_comments, message_Send;
    private EditText Message;
    private SVProgressHUD mSVProgressHUD;
    private com.jcodecraeer.xrecyclerview.XRecyclerView mRecyclerView;
    private View viewHader;
    private android.os.Handler handler = new android.os.Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
//                itemComments();
        }
    };
    private View bottom;

    @Override
    public int initLayoutId() {
        return R.layout.act_healthpage_details;
    }

    @Override
    public void initView() {
        hideHeader();
        viewHader = LayoutInflater.from(context).inflate(R.layout.view_healthpage_details, null);
        setOnClickListener(viewHader, R.id.healthpage_details_huida);
        title = getView(viewHader, R.id.healthpage_Title);
        tvContext = getView(viewHader, R.id.healthpage_context);
        myHaderImge = getView(viewHader, R.id.healthpage_haderImg);
        setOnClickListener(viewHader, R.id.healthpage_back);
        pageTitle = getView(viewHader, R.id.healthpage_title);
        hits = getView(viewHader, R.id.healthpage_detailskan);
        comments = getView(viewHader, R.id.healthpage_comments);
        hader = getView(viewHader, R.id.profile_image);
        name = getView(viewHader, R.id.healthpage_name);
//        liner_comments = getView(R.id.liner_healthpage_comments);
        message_Send = getView(R.id.My_MessageSend);
        setOnClickListener(R.id.My_MessageSend_send_msg);
        Message = getView(R.id.My_MessageSend_reply);
        mRecyclerView = getView(R.id.healthpage_XRecyclerView);
        bottom = LayoutInflater.from(context).inflate(R.layout.view_bottomhealthpage, null);
        setOnClickListener(bottom, R.id.iv_more1);
    }

    @Override
    public void initData() {
        mSVProgressHUD = new SVProgressHUD(context);
        aCache = ACache.get(this);
        aid = getIntent().getStringExtra("aid");
        pageTitle.setText(getIntent().getStringExtra("title"));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView
                .getDefaultRefreshHeaderView()
                .setRefreshTimeVisible(true);
        mRecyclerView.addHeaderView(viewHader);
        mRecyclerView.setFootView(bottom, this);
        mRecyclerView.setPullRefreshEnabled(false);
        postLin();
    }

    @Override
    public void requestData() {

    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.healthpage_details_huida://我的回答
                Intent intent = new Intent();
                intent.putExtra("data", (Serializable) healthPageDetailsBean);
                intent.putExtra("aid", aid);
                intent.setClass(this, Act_I_Know.class);
//                startAct(intent, Act_I_Know.class);
                startActivityForResult(intent, 10);
                break;
            case R.id.iv_more1://更多
                if (datas.size()<=0) {
                    return;
                }
                startAct(Act_More.class);
                break;
            case R.id.healthpage_back:
                finish();
                break;
            case R.id.My_MessageSend_send_msg://发送
                if (TextUtils.isEmpty(Message.getText().toString())) {
                    MyToast.show(context, "请填写发送内容！");
                    return;
                }
                sendMessage();
                break;
            default:
                Debug.e("----------id----" + v.getTag());
                break;
        }
    }

    private HealthPageDetailsBean healthPageDetailsBean;

    /**
     * 获取记录详情
     */
    public void postLin() {
        showLoading();
        final HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("aid", aid);
        httpReqest.HttpPost(ComantUtils.Details_Growth, hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                healthPageDetailsBean = gson.fromJson(response.body(), HealthPageDetailsBean.class);
                if (healthPageDetailsBean.getError_code().equals("400")) {
                    MyToast.show(context, "没有该条数据详情！");
                    return;
                }
                title.setText(healthPageDetailsBean.getData().getArticle_title());
                tvContext.setText(healthPageDetailsBean.getData().getContent());
                Glide.with(context).load(healthPageDetailsBean.getData().getImg()).placeholder(R.mipmap.icon_xxx).into(myHaderImge);
                hits.setText(healthPageDetailsBean.getData().getHits());
                comments.setText(healthPageDetailsBean.getData().getComments());
                Glide.with(context).load(healthPageDetailsBean.getData().getUserinfo().getCompany_img()).placeholder(R.mipmap.icon_hader).into(hader);
                name.setText(healthPageDetailsBean.getData().getUserinfo().getNickname());
                itemComments();
                showCView();
            }

            @Override
            public void onError(Response<String> response) {
                showCView();
            }
        });
    }

    /**
     * 获取评论列表
     */
    private HealthPage_DetailsAdpater adpater = null;
    private List<ItemCommentsBean.CommentDataBean.CommentBean> datas = new ArrayList<>();

    public void itemComments() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("module", "2");
        hashMap.put("id", aid);
        hashMap.put("page", "1");
        hashMap.put("psize", "2");
        hashMap.put("mb", "1");
        httpReqest.HttpPost(ComantUtils.More_Comments, hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                ItemCommentsBean bean = gson.fromJson(response.body(), ItemCommentsBean.class);
                datas.clear();
                for (int i = 0; i < bean.getComment_data().getComment().size(); i++) {
                    ItemCommentsBean.CommentDataBean.CommentBean bean1 = bean.getComment_data().getComment().get(i);
                    datas.add(bean1);
                }
                if (adpater == null) {
                    adpater = new HealthPage_DetailsAdpater();
                    adpater.setDatas(datas, context);
                    adpater.setClickCallBack(Act_HealthPage_Details.this);
                    mRecyclerView.setAdapter(adpater);
                } else {
                    adpater.setDatas(datas, context);
                    adpater.notifyDataSetChanged();
                }
                message_Send.setVisibility(View.GONE);
                showCView();
            }

            @Override
            public void onError(Response<String> response) {
                showCView();
            }
        });
    }

    String comment_id;

    /**
     * 发送消息
     */
    public void sendMessage() {
        mSVProgressHUD.showWithStatus("发送中...");
        HashMap<String, String> body = new HashMap<>();
        body.put("user_token", aCache.getAsString("User_token"));
        body.put("skill_id", aid);
        body.put("module", "2");
        body.put("comment_id", comment_id);
        body.put("content", Message.getText().toString());
        body.put("mb", "1");
        httpReqest.HttpPost(ComantUtils.Growth_Advisory_release, body, back);
    }

    BackString back = new BackString() {
        @Override
        public void onSuccess(Response<String> response) {
            itemComments();
            mSVProgressHUD.dismiss();
        }

        @Override
        public void onError(Response<String> response) {
            mSVProgressHUD.dismiss();
        }
    };

    @Override
    public void onItemClick(int pos) {
        comment_id = datas.get(pos).getId();
        message_Send.setVisibility(View.VISIBLE);
    }

    @Override
    public void onChlidItemClick(int pos, int chlid) {
        comment_id = datas.get(pos).getMore().get(chlid).getId();
        message_Send.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && requestCode == 10) {
            itemComments();
        }
    }

    @Override
    public void onLoadingMore(View yourFooterView) {

    }

    @Override
    public void onLoadMoreComplete(View yourFooterView) {

    }

    @Override
    public void onSetNoMore(View yourFooterView, boolean noMore) {

    }
}
