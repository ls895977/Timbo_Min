package com.example.lishan.timbo_min.ui.home.motion;

import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;

/**
 * 运动计数器
 * Created by lishan on 2018/1/11.
 */

public class Act_MotionCounter extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_motiocounter;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.motioncounter_back);
        setOnClickListener(R.id.pressed1dt);
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
        switch (v.getId()) {
            case R.id.motioncounter_back:
                finish();
                break;
            case R.id.pressed1dt://地图界面
                startAct(Act_Location.class);
                break;
        }
    }
}
