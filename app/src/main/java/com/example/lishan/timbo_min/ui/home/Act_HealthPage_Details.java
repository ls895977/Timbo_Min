package com.example.lishan.timbo_min.ui.home;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.HealthPageListAdapter;
import com.example.lishan.timbo_min.bean.HealthPageDetailsBean;
import com.example.lishan.timbo_min.bean.HealthPagerListBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.common.ComantUtils;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.header.material.CircleImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lishan on 2017/12/22.
 */

public class Act_HealthPage_Details extends BaseAct {
    private HttpReqest httpReqest = new HttpReqest();
    private ACache aCache;
    private String aid;
    private Gson gson = new Gson();
    private TextView title, tvContext, pageTitle, hits, comments, name;
    private ImageView myHaderImge;
    private de.hdodenhof.circleimageview.CircleImageView hader;

    @Override
    public int initLayoutId() {
        return R.layout.act_healthpage_details;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.healthpage_details_huida);
        title = getView(R.id.healthpage_Title);
        tvContext = getView(R.id.healthpage_context);
        myHaderImge = getView(R.id.healthpage_haderImg);
        setOnClickListener(R.id.healthpage_back);
        pageTitle = getView(R.id.healthpage_title);
        hits = getView(R.id.healthpage_detailskan);
        comments = getView(R.id.healthpage_comments);
        hader = getView(R.id.profile_image);
        name = getView(R.id.healthpage_name);
    }

    @Override
    public void initData() {
        aCache = ACache.get(this);
        aid = getIntent().getStringExtra("aid");
        pageTitle.setText(getIntent().getStringExtra("title"));
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
                startAct(intent, Act_I_Know.class);
                break;
            case R.id.iv_more1://更多
                startAct(Act_More.class);
                break;
            case R.id.healthpage_back:
                finish();
                break;
        }
    }

    private HealthPageDetailsBean healthPageDetailsBean;

    public void postLin() {
        showLoading();
        final HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("aid", aid);
        httpReqest.HttpPost(ComantUtils.Details_Growth, hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                showCView();
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
            }

            @Override
            public void onError(Response<String> response) {
                showCView();

            }
        });
    }
}
