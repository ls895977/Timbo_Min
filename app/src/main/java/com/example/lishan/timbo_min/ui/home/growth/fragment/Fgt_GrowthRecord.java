package com.example.lishan.timbo_min.ui.home.growth.fragment;

import android.graphics.Color;
import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseFgt;
import com.example.lishan.timbo_min.ui.home.growth.Act_GrowthRecord_Details;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishan on 2017/12/25.
 */

public class Fgt_GrowthRecord extends BaseFgt {
    private LineChart mChart;

    @Override
    public void sendMsg(int flag, Object obj) {

    }

    @Override
    public int initLayoutId() {
        return R.layout.fgt_growthrecord;
    }

    @Override
    public void initView() {
        hideHeader();
        mChart = getView(R.id.chart1);
        setOnClickListener(R.id.my_chenzhang);
        setOnClickListener(R.id.growthrecord_image);
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
            case R.id.growthrecord_image:
            case R.id.growthrecord_grow:
                startAct(Act_GrowthRecord_Details.class);
                break;
        }
    }
}
