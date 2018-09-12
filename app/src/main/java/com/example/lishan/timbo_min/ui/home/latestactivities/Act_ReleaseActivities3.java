package com.example.lishan.timbo_min.ui.home.latestactivities;

import android.view.View;

import com.example.lishan.timbo_min.MainActivity;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;

/**
 * 活动第四个页面
 * Created by lishan on 2018/1/18.
 */

public class Act_ReleaseActivities3 extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_releaseactivities3;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.re_bt1);
        setOnClickListener(R.id.re_bt2);
        setOnClickListener(R.id.re_bt3);
    }

    @Override
    public void initData() {

    }

    @Override
    public void requestData() {

    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onViewClick(View v) {
        switch (v.getId()){
            case R.id.re_bt3:
            case R.id.re_bt2:
            case R.id.re_bt1:
                startActClear(MainActivity.class);
                break;
        }
    }
}