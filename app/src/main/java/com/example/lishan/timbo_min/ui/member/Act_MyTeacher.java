package com.example.lishan.timbo_min.ui.member;

import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;

/**
 * 我的老师
 * Created by Administrator on 2018/3/31 0031.
 */

public class Act_MyTeacher extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_my_teacher;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.MyTeacher_back);
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
            case R.id.MyTeacher_back:
                finish();
                break;
        }
    }
}
