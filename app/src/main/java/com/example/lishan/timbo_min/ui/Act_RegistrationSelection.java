package com.example.lishan.timbo_min.ui;

import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;
import com.lykj.aextreme.afinal.utils.ACache;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public class Act_RegistrationSelection extends BaseAct {
    private ACache aCache;
    @Override
    public int initLayoutId() {
        return R.layout.act_registrationselection;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.I_am_a_student);
        setOnClickListener(R.id.Teacher);
        setOnClickListener(R.id.mechanism);
        setOnClickListener(R.id.rgt_back);
    }

    @Override
    public void initData() {
    aCache=ACache.get(context);
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
            case R.id.I_am_a_student://我是学生
                aCache.put("type","0");
                startAct(Act_Register.class);
                break;
            case R.id.Teacher://我是老师
                aCache.put("type","1");
                startAct(Act_Register.class);
                break;
            case R.id.mechanism://我是机构
                aCache.put("type","2");
                startAct(Act_Enterprise_Registration.class);
                break;
            case R.id.rgt_back:
                finish();
                break;
        }
    }
}
