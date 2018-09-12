package com.example.lishan.timbo_min.ui.home.myclass;

import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;

/**
 * Created by lishan on 2018/1/16.
 */

public class Act_MyTeacher extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_myteacher;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.myteacher_back);
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
            case R.id.myteacher_back:
                finish();
                break;
        }
    }
}
