package com.example.lishan.timbo_min.ui.home.traininginstitutions;

import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;

/**
 * 联系我们
 * Created by lishan on 2018/1/24.
 */

public class Act_ContactUs extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_contactus;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.contactus_back);
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
                case R.id.contactus_back:
                    finish();
                    break;
            }
    }
}
