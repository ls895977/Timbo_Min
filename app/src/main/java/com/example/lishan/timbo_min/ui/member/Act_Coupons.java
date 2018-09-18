package com.example.lishan.timbo_min.ui.member;

import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;

/**
 * 优惠劵
 */
public class Act_Coupons extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_coupons;
    }

    @Override
    public void initView() {
        setOnClickListener(R.id.coupons_back);
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
            case R.id.coupons_back:
                finish();
                break;
        }
    }
}
