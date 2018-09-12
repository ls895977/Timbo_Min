package com.example.lishan.timbo_min.ui.enterprise;

import android.view.View;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;

/**
 * 广告管理
 * Created by Administrator on 2018/4/4 0004.
 */

public class Act_AdvertisingManagement extends BaseAct {
    TextView tv[] = new TextView[3];
    private int indext=0;
    @Override
    public int initLayoutId() {
        return R.layout.act_advertisingmanagement;
    }

    @Override
    public void initView() {
        hideHeader();
        tv[0] = getViewAndClick(R.id.AdvertisingManagement_tv_Consultation);
        tv[1] = getViewAndClick(R.id.AdvertisingManagement_tv_Extension);
        tv[2] = getViewAndClick(R.id.AdvertisingManagement_tv_purchase);
        tv[indext].setSelected(true);
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
                    case R.id.AdvertisingManagement_tv_Consultation://广告咨询
                        onSwcheSlecte(0);
                        break;
                    case R.id.AdvertisingManagement_tv_Extension://推广中
                        onSwcheSlecte(1);
                        break;
                    case R.id.AdvertisingManagement_tv_purchase://购买记录
                        onSwcheSlecte(2);
                        break;
                }
    }

    public void onSwcheSlecte(int indext1) {
        tv[indext1].setSelected(true);
        tv[indext].setSelected(false);
        indext = indext1;
    }
}
