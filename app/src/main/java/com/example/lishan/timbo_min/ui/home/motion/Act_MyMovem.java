package com.example.lishan.timbo_min.ui.home.motion;

import android.graphics.Color;
import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.example.lishan.timbo_min.tool.CircleProgress;
import com.example.lishan.timbo_min.ui.home.motion.Act_Sign;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.Random;

/**
 *  我要运动
 * Created by lishan on 2018/1/9.
 */

public class Act_MyMovem extends BaseAct {
    private CircleProgress mCircleProgress3;
    private Random mRandom;

    @Override
    public int initLayoutId() {
        return R.layout.act_movem;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.movem_back);
        setOnClickListener(R.id.movem_new);
        setOnClickListener(R.id.movem_Get_into);
        setOnClickListener(R.id.movem_linear);
        mCircleProgress3 = getViewAndClick(R.id.circle_progress_bar3);
        setOnClickListener(R.id.motiogounter_click);
    }

    private final static int[] COLORS = new int[]{Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE};

    @Override
    public void initData() {
        mRandom = new Random();
        //在代码中动态改变渐变色，可能会导致颜色跳跃
        mCircleProgress3.setGradientColors(COLORS);
        mCircleProgress3.setValue(mRandom.nextFloat() * mCircleProgress3.getMaxValue());
        backData();
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
            case R.id.movem_back:
                finish();
                break;
            case R.id.movem_new://创建项目
                startAct(Act_CreateAPlan.class);
                break;
            case R.id.movem_Get_into://点击进入
                startAct(Act_Sign.class);
                break;
            case R.id.movem_linear://计划管理
                startAct(Act_CreateAPlan.class);
                break;
            case R.id.motiogounter_click://运动计数据
                startAct(Act_MotionCounter.class);
                break;
        }
    }
    public void backData() {
        showLoading();
        ACache aCache = ACache.get(this);
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body = new HashMap<>();
        body.put("op", "getDailyPlan");
        body.put("uid", aCache.getAsString("id"));
        httpReqest.HttpPost("i=1&c=entry&do=enterPoint&m=b_isport", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e("---首页--" + response.body());
                showCView();
            }

            @Override
            public void onError(Response<String> response) {
                Debug.e("---首页-onError-" + response.body());
                showCView();
            }
        });
    }
}
