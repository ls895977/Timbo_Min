package com.example.lishan.timbo_min.ui.home.latestactivities;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.LatesActivitivitiesAdapter;
import com.example.lishan.timbo_min.bean.LatesActivitivitiesBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.example.lishan.timbo_min.tool.GlideImageLoader;
import com.example.lishan.timbo_min.view.FullyLinearLayoutManager;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 最新活动
 * Created by lishan on 2018/1/17.
 */

public class Act_LatestActivities extends BaseAct implements LatesActivitivitiesAdapter.OnBackButtonItemClick, XRecyclerView.LoadingListener {
    private XRecyclerView myRecyclerView;
    private SVProgressHUD mSVProgressHUD;
    private TextView[] title = new TextView[5];
    private TextView[] tvTime = new TextView[4];
    private TextView[] huodong = new TextView[2];
    private TextView hom, huiyuan;
    private View hader;
    private Banner myBanner;
    private LinearLayout showChoseTime;
    private EditText startTime, endTime, stActivity;
    private String ord = "ctime", stTitle = "", stHuodong = "", stTime = "";
    private ACache aCache;

    @Override
    public int initLayoutId() {
        return R.layout.act_latestactivities;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.latestactivities_back);
        setOnClickListener(R.id.releaseactivities);
        myRecyclerView = getView(R.id.latestactivities_xrecyclerview);
        hader = LayoutInflater.from(this).inflate(R.layout.item_latestactivities, null);
        title[0] = getViewAndClick(hader, R.id.item_lateszuixin);
        title[0].setSelected(true);
        title[1] = getViewAndClick(hader, R.id.item_lateszuijin);
        title[2] = getViewAndClick(hader, R.id.item_latesshzuire);
        title[3] = getViewAndClick(hader, R.id.item_latesshjian);
        title[4] = getViewAndClick(hader, R.id.item_lateslishihuodong);
        tvTime[0] = getViewAndClick(hader, R.id.item_latestactivites_oneday);
        tvTime[1] = getViewAndClick(hader, R.id.item_latestactivites_thyday);
        tvTime[2] = getViewAndClick(hader, R.id.item_latestactivites_zhou);
        tvTime[3] = getViewAndClick(hader, R.id.item_latestactivites_yue);
        huodong[0] = getViewAndClick(hader, R.id.item_latestactivityes_geren);
        huodong[1] = getViewAndClick(hader, R.id.item_latestactivityes_qiye);
        huodong[0].setSelected(true);
        stActivity = getView(hader, R.id.item_latestactivites_huodong);
        setOnClickListener(hader, R.id.item_latestactivites_delete);
        setOnClickListener(hader, R.id.time_latestactivities_sousuo);
        startTime = getView(hader, R.id.item_startTime);
        endTime = getView(hader, R.id.item_endTime);
        showChoseTime = getView(hader, R.id.item_showLinearTime);
        showChoseTime.setVisibility(View.GONE);
        myBanner = getView(hader, R.id.item_latesactivity_banner);
        myRecyclerView.addHeaderView(hader);
        //本地图片数据（资源文件）
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.icon_xxx1);
        list.add(R.mipmap.b2);
        list.add(R.mipmap.b3);
        myBanner.setImages(list)
                .setImageLoader(new GlideImageLoader())
                .start();
        setOnClickListener(R.id.tab_zhong);//发布活动
        hom = getViewAndClick(R.id.tab_lateshome);//首页
        huiyuan = getViewAndClick(R.id.tab_latestmember);//会员
        hom.setSelected(true);
        startTime.addTextChangedListener(new TextWatcher() {//时间 。。开始时间
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                setTime(100);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        endTime.addTextChangedListener(new TextWatcher() {//时间 。。结整时间
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                setTime(100);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        stActivity.addTextChangedListener(new TextWatcher() {//活动类别
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                sethuodong(100);
                stHuodong = stActivity.getText().toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private List<LatesActivitivitiesBean.ActDataBean> datas;

    @Override
    public void initData() {
        mSVProgressHUD = new SVProgressHUD(context);
        aCache = ACache.get(this);
        datas = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        myRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        myRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);
        myRecyclerView.setLoadingListener(this);
        postData();
    }

    private LatesActivitivitiesAdapter adapter;

    @Override
    public void requestData() {

    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.latestactivities_back:
                finish();
                break;
            case R.id.item_lateszuixin:
                showChoseTime.setVisibility(View.GONE);
                ord = "ctime";
                setChage(0);
                datas.clear();
                postData();
                break;
            case R.id.item_lateszuijin:
                showChoseTime.setVisibility(View.GONE);
                setChage(1);
                ord = "see_num";
                datas.clear();
                postData();
                break;
            case R.id.item_latesshzuire:
                showChoseTime.setVisibility(View.GONE);
                setChage(2);
                ord = "collect_num";
                datas.clear();
                postData();
                break;
            case R.id.item_latesshjian:
                showChoseTime.setVisibility(View.VISIBLE);
                setChage(3);
                setTime(100);
                break;
            case R.id.item_lateslishihuodong:
                showChoseTime.setVisibility(View.GONE);
                setChage(4);
//                stTitle = "历史活动";
                break;
            case R.id.tab_zhong://发布活动
                hom.setSelected(true);
                huiyuan.setSelected(false);
                break;
            case R.id.tab_latestmember://会员
                hom.setSelected(false);
                huiyuan.setSelected(true);
                break;
            case R.id.releaseactivities://发布活动
                startAct(Act_ReleaseActivities.class);
                break;
            case R.id.item_latestactivites_oneday://一天内
                stTime = "oneday";
                setTime(0);
                datas.clear();
                postData();
                break;
            case R.id.item_latestactivites_thyday://三天内
                setTime(1);
                stTime = "threeday";
                datas.clear();
                postData();
                break;
            case R.id.item_latestactivites_zhou://一周内
                setTime(2);
                stTime = "oneweek";
                datas.clear();
                postData();
                break;
            case R.id.item_latestactivites_yue://一个月内
                setTime(3);
                stTime = "month";
                datas.clear();
                postData();
                break;
            case R.id.time_latestactivities_sousuo://时间==搜索
                ord = "";
                datas.clear();
                postData();
                break;
            case R.id.item_latestactivityes_geren://个人活动
                stHuodong = "个人活动";
                sethuodong(0);
                datas.clear();
                postData();
                break;
            case R.id.item_latestactivityes_qiye://企业活动
                sethuodong(1);
                stHuodong = "企业活动";
                datas.clear();
                postData();
                break;
            case R.id.item_latestactivites_delete://企业搜素处删除

                break;


        }
    }

    int sta = 0;

    public void setChage(int stats) {
        title[sta].setSelected(false);
        title[stats].setSelected(true);
        sta = stats;
    }

    int sta1 = 0;

    public void sethuodong(int stats) {
        if (stats != 100) {
            Debug.e("--sta1-----" + sta1);
            huodong[sta1].setSelected(false);
            huodong[stats].setSelected(true);
            Debug.e("--stats-----" + stats);
            sta1 = stats;
        } else {
            huodong[0].setSelected(false);
            huodong[1].setSelected(false);
        }
    }

    int statime = 100;
    boolean timeStatus = false;

    public void setTime(int stats) {
        if (stats != 100) {
            timeStatus = false;
            tvTime[sta].setSelected(false);
            tvTime[stats].setSelected(true);
            statime = stats;
        } else {
            timeStatus = true;
            tvTime[0].setSelected(false);
            tvTime[1].setSelected(false);
            tvTime[2].setSelected(false);
            tvTime[3].setSelected(false);
        }
    }

    @Override
    public void backItemClcik(int indext) {
        Intent intent = new Intent();
        intent.putExtra("id", datas.get(indext).getId());
        startAct(intent, Act_Activity_Content.class);
    }

    private int page = 0;

    public void postData() {
        if (timeStatus) {
            if (TextUtils.isEmpty(startTime.getText().toString())) {
                MyToast.show(context, "请输入开始时间");
                return;
            }
            if (TextUtils.isEmpty(endTime.getText().toString())) {
                MyToast.show(context, "请输入结束时间");
                return;
            }
        }
        mSVProgressHUD.showWithStatus("数据请求中...");
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body = new HashMap<>();
        body.put("title", stTitle);
        body.put("uid_type", aCache.getAsString("uid_type"));
        body.put("page", String.valueOf(page));
        if (ord.equals("")) {
            if (timeStatus) {//输入时间时判断
                body.put("zdy_start", startTime.getText().toString());
                body.put("zdy_end", endTime.getText().toString());
            } else {
                body.put("time", stTime);
            }
        } else {
            body.put("ord", ord);
        }
        httpReqest.HttpPost("i=1&c=entry&do=activity&m=dxf_act&op=actlist", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e(response.body());
                Gson gson = new Gson();
                LatesActivitivitiesBean bean = gson.fromJson(response.body(), LatesActivitivitiesBean.class);
                if (bean.getAct_data() == null || bean.getAct_data().size() == 0) {//没有数据的时候
                datas.clear();
                LatesActivitivitiesBean.ActDataBean datasBean = new LatesActivitivitiesBean.ActDataBean();
                datas.add(datasBean);
                } else {
                Debug.e("--------------数据刷新中。。。");
                for (int i = 0; i < bean.getAct_data().size(); i++) {
                    LatesActivitivitiesBean.ActDataBean datasBean = bean.getAct_data().get(i);
                    datas.add(datasBean);
                }
            }
                if (adapter == null) {
                    adapter = new LatesActivitivitiesAdapter(Act_LatestActivities.this, datas);
                    adapter.setContext(Act_LatestActivities.this);
                    myRecyclerView.setAdapter(adapter);
                } else {
                    adapter.notifyDataSetChanged();
                }
                mSVProgressHUD.dismiss();
            }

            @Override
            public void onError(Response<String> response) {
                mSVProgressHUD.dismiss();
            }
        });
    }

    @Override
    public void onRefresh() {
        page = 0;
        datas.clear();
        postData();
    }

    @Override
    public void onLoadMore() {
        page++;
        postData();
    }
}
