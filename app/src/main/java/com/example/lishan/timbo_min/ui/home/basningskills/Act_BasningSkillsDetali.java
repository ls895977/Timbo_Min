package com.example.lishan.timbo_min.ui.home.basningskills;

import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.ui.home.Act_More;

/**
 * 晒技能详情页
 * Created by lishan on 2018/1/17.
 */

public class Act_BasningSkillsDetali extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_basningskillsdteali;
    }

    @Override
    public void initView() {
     hideHeader();
        setOnClickListener(R.id.basninaskills_back);
        setOnClickListener(R.id.basningskills_Mystudy);
        setOnClickListener(R.id.iv_basningskill);
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
                case R.id.basninaskills_back:
                        finish();
                    break;
                case R.id.basningskills_Mystudy://我要学习
                    startAct(Act_Mystudy.class);
                    break;
                case R.id.iv_basningskill://更多评论
                    startAct(Act_More.class);
                    break;
            }
    }
}
