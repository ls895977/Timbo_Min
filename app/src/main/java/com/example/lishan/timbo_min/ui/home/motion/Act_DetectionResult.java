package com.example.lishan.timbo_min.ui.home.motion;

import android.view.View;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.DetectionResultBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

/**
 * Created by lishan on 2018/1/11.
 */

public class Act_DetectionResult extends BaseAct {
    private String age, gongjin, limi, sex;
    private TextView personInfo_sex, personInfo_height, personInfo_weight,
            personInfo_age, standard_sex, standard_height, standard_weight,
            standard_age,gongli,zhongliang,contexttv;

    @Override
    public int initLayoutId() {
        return R.layout.act_detectionresult;
    }

    @Override
    public void initView() {
        setTitle(R.string.Act_Sign_title);
        setHeaderLeft(R.mipmap.icon_mygrowth_title);
        setOnClickListener(R.id.detectionresult_lingqu);
        personInfo_sex = getView(R.id.standard_sex);
        personInfo_age = getView(R.id.standard_age);
        personInfo_height = getView(R.id.standard_shengao);
        personInfo_weight = getView(R.id.standard_gonjin);
        standard_sex = getView(R.id.you_sex);
        standard_age = getView(R.id.you_age);
        standard_weight = getView(R.id.you_gongjin);
        standard_height = getView(R.id.you_shengao);
        gongli=getView(R.id.detectionresult_planDistancePerDay);
        zhongliang=getView(R.id.zhongliang);
        contexttv=getView(R.id.standard_description);
    }

    @Override
    public void initData() {
        age = getIntent().getStringExtra("age");
        gongjin = getIntent().getStringExtra("gongjin");
        limi = getIntent().getStringExtra("limi");
        sex = getIntent().getStringExtra("sex");
        PostResult();
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
            case R.id.detectionresult_lingqu://领取计划
                startAct(Act_CreateAPlan.class);
                break;
        }

    }

    public void PostResult() {
        showLoading();
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body = new HashMap<>();
        body.put("op", "testPlan");
        body.put("weight", gongjin);
        body.put("age", age);
        body.put("height", limi);
        body.put("sex", sex);
        body.put("fHeight", "1");
        body.put("mHeight", "1");
        httpReqest.HttpPost("i=1&c=entry&do=enterPoint&m=b_isport&", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e("////===" + response.body());
                Gson gson = new Gson();
                DetectionResultBean bean = gson.fromJson(response.body(), DetectionResultBean.class);
                if (bean.getError_code() == 200) {
                    personInfo_age.setText(bean.getPersonInfo().getAge() + "岁");
                    personInfo_height.setText("身高：" + bean.getPersonInfo().getHeight() + "厘米");
                    personInfo_sex.setText(bean.getPersonInfo().getSex());
                    personInfo_weight.setText("体重：" + bean.getPersonInfo().getWeight() + "公斤");

                    standard_age.setText(bean.getStandard().getAge() + "岁");
                    standard_height.setText("身高：" + bean.getStandard().getHeight() + "厘米");
                    standard_sex.setText(bean.getStandard().getSex());
                    standard_weight.setText("体 重：" + bean.getStandard().getWeight() + "公斤");
                    gongli.setText(bean.getRecommandedPlan().getPlanDistancePerDay()+"");
                        zhongliang.setText(String.valueOf(bean.getRecommandedPlan().getTotalCalory()));
                    contexttv.setText(bean.getRecommandedPlan().getDescription());
                } else {
                    MyToast.show(context, bean.getError_message());
                }
                showCView();
            }

            @Override
            public void onError(Response<String> response) {
                Debug.e("////===" + response.body());
                showCView();
            }
        });


    }
}
