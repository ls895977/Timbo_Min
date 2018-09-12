package com.example.lishan.timbo_min.ui.member;

import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;

/**
 * 家长帮
 * Created by Administrator on 2018/3/29 0029.
 */

public class Act_Parent extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_parent;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.Parent_back);
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
            case R.id.Parent_back:
                finish();
                break;
        }
    }
}
