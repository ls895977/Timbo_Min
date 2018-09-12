package com.example.lishan.timbo_min.ui.home.traininginstitutions;

import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;

/**
 * 机构报名
 * Created by lishan on 2018/1/29.
 */

public class Act_Enroll extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_enroll;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.enroll_back);
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
            case R.id.enroll_back:
                finish();
                break;
        }
    }
}
