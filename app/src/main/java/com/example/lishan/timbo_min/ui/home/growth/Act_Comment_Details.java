package com.example.lishan.timbo_min.ui.home.growth;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.bumptech.glide.Glide;
import com.example.lishan.timbo_min.MyWeb;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.ArenaDetalListAdapter;
import com.example.lishan.timbo_min.bean.ArenaDetalBean;
import com.example.lishan.timbo_min.bean.Comment_DetailsBean;
import com.example.lishan.timbo_min.bean.ZanBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.common.MyTooL;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.example.lishan.timbo_min.ui.home.arena.Act_ArenaDetailPage;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by lishan on 2018/1/5.
 */

public class Act_Comment_Details extends BaseAct {
    ACache aCache;
    private Gson gson;
    private LinearLayout linear_message, senMessage;
    private SVProgressHUD svProgressHUD;
    private EditText messageContext;

    @Override
    public int initLayoutId() {
        return R.layout.act_comment_details;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.comment_details_back);
        linear_message = getView(R.id.comment_details_message);
        senMessage = getView(R.id.comment_details_senMessage);
//        senMessage.setVisibility(View.GONE);
        setOnClickListener(R.id.comment_details_senbutton);
        messageContext = getView(R.id.comment_details_messageContext);
    }

    @Override
    public void initData() {
        gson = new Gson();
        svProgressHUD = new SVProgressHUD(context);
        aCache = ACache.get(context);
        type_id = getIntent().getStringExtra("type_id");
        backDate();
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
            case R.id.comment_details_back:
                finish();
                break;
            case R.id.comment_details_senbutton://发送消息
                if (TextUtils.isEmpty(messageContext.getText().toString())) {
                    MyToast.show(context, "请输入要发送的内容！");
                    return;
                }
                postMessage(messageContext.getText().toString());
                break;
        }
    }
    /**
     * 评论p
     */
    private String type_id, cid;
    public void postMessage(String content) {
        svProgressHUD.showWithStatus("数据请请中.....");
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("user_token", aCache.getAsString("User_token"));
        hashMap.put("skill_id", type_id);
        hashMap.put("module", "7");
        hashMap.put("comment_id", "");
        hashMap.put("content", content);
        hashMap.put("mb", "1");
        httpReqest.HttpPost("i=6&c=entry&m=dxf_skill&do=write&op=comment", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e("-------" + response.body());
                svProgressHUD.dismiss();
                linear_message.removeAllViews();
                senMessage.setVisibility(View.GONE);
                backDate();
            }

            @Override
            public void onError(Response<String> response) {
                MyToast.show(context, "数据请求失败!");
                svProgressHUD.dismiss();
            }
        });
    }

    /**
     * 评论请求
     */
    Comment_DetailsBean bean;
    public void backDate() {
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("module", "7");
        hashMap.put("id", type_id);
        hashMap.put("page", "1");
        hashMap.put("psize", "5");
        hashMap.put("mb", "1");
        httpReqest.HttpPost("i=1&c=entry&do=write&m=dxf_skill&op=comt_more", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                bean = gson.fromJson(response.body(), Comment_DetailsBean.class);
                Debug.e("---11----" + response.body());
                for (int i = 0; i < bean.getComment_data().getComment().size(); i++) {
                    final Comment_DetailsBean.CommentDataBean.CommentBean benItem = bean.getComment_data().getComment().get(i);
                    View item = getLayoutInflater().inflate(R.layout.item_message, null);
                    de.hdodenhof.circleimageview.CircleImageView hader = (CircleImageView) item.findViewById(R.id.item_message_header);
                    Glide.with(context).load(benItem.getHeadimg()).error(R.mipmap.icon_hader).into(hader);
                    TextView name = (TextView) item.findViewById(R.id.item_message_name);
                    name.setText(benItem.getName());
                    TextView age = (TextView) item.findViewById(R.id.item_message_age);
                    age.setText(benItem.getAge() + " 岁" + "   " + benItem.getGrade() + "年级");
                    TextView substance = (TextView) item.findViewById(R.id.item_message_substance);
                    substance.setText(benItem.getContent());
                    ImageView show = (ImageView) item.findViewById(R.id.item_message_show);
                    show.setId(i);
                    show.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Debug.e("--------" + view.getId());
                            senMessage.setVisibility(View.VISIBLE);
                            cid = String.valueOf(benItem.getUid());
                        }
                    });
                    linear_message.addView(item);
                }
            }
            @Override
            public void onError(Response<String> response) {
                showCView();
                MyToast.show(context, "数据请求失败!");
            }
        });
    }

}
