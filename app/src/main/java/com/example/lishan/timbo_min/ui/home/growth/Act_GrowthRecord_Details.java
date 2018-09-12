package com.example.lishan.timbo_min.ui.home.growth;

import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.common.BaseFgt;
import com.github.mikephil.charting.charts.LineChart;

/**
 * Created by lishan on 2017/12/25.
 */

public class Act_GrowthRecord_Details extends BaseAct {
    private LineChart mChart;


    @Override
    public int initLayoutId() {
        return R.layout.act_growthrecord_details;
    }

    @Override
    public void initView() {
        setLeftTitle();
        mChart = getView(R.id.chart1);
        setOnClickListener(R.id.growthrecord_details_click);
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
            case R.id.my_chenzhang:

                break;
        }
    }
}
