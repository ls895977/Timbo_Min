package com.example.lishan.timbo_min.ui.home;

import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;
import com.lykj.aextreme.afinal.utils.Debug;

/**
 * Created by lishan on 2017/12/22.
 */

public class Act_HealthPage_Details extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_healthpage_details;
    }

    @Override
    public void initView() {
        setLeftTitle();
        setOnClickListener(R.id.healthpage_details_huida);
        setOnClickListener(R.id.iv_more1);
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
            case R.id.healthpage_details_huida://我的回答
                startAct(Act_I_Know.class);
                break;
            case R.id.iv_more1://更多
                startAct(Act_More.class);
                break;
        }
    }
}
