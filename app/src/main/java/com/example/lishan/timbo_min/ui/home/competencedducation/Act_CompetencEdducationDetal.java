package com.example.lishan.timbo_min.ui.home.competencedducation;

import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.ui.home.Act_More;

/**
 * 素质课堂详情页
 * Created by lishan on 2018/1/19.
 */

public class Act_CompetencEdducationDetal extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_competencedducationdetal;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.competencedducationdetal_back);
        setOnClickListener(R.id.competencedducationdetal_back_pinlun);
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
                case R.id.competencedducationdetal_back:
                    finish();
                    break;
                case R.id.competencedducationdetal_back_pinlun:
                    startAct(Act_More.class);
                    break;
            }
    }
}
