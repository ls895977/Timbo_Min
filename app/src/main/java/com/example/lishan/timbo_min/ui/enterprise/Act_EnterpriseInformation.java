package com.example.lishan.timbo_min.ui.enterprise;

import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.common.BaseFgt;

/**
 * 企业个人中心
 * Created by lishan on 2018/4/2.
 */

public class Act_EnterpriseInformation extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_enterpriseinformation;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.EnterpriseInformation_back);
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
                case R.id.EnterpriseInformation_back:
                    finish();
                    break;
            }
    }
}
