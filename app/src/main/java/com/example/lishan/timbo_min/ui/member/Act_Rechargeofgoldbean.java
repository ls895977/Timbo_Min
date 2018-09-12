package com.example.lishan.timbo_min.ui.member;

import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;

/**
 * 金豆充值
 * Created by Administrator on 2018/3/23 0023.
 */

public class Act_Rechargeofgoldbean extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_rechargeofgoldbean;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.Rechargeofgoldbean_back);
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
            case R.id.Rechargeofgoldbean_back:
                finish();
                break;
        }
    }
}
