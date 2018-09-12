package com.example.lishan.timbo_min.ui;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.CodeBean;
import com.example.lishan.timbo_min.bean.InforMationBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

/**
 * Created by lishan on 2017/12/10.
 */

public class Act_RG_Perfect_information extends BaseAct {
    private SVProgressHUD mSVProgressHUD;
    private ACache aCache;
    private EditText real_name, age, address, relation_type_1, relation_name_1, relation_type_2, relation_name_2;
    private RadioGroup radioGroup;

    @Override
    public int initLayoutId() {
        return R.layout.act_rg_perfect_information;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.rgper_back);
        setOnClickListener(R.id.rgper_enterprise);
        setOnClickListener(R.id.rg_next_step);
        real_name = getView(R.id.information_real_name);//孩子姓名
        radioGroup = getView(R.id.information_sex);//选择男女
        age = getView(R.id.information_age);//年龄
        address = getView(R.id.information_address);//详细地址
        relation_type_1 = getView(R.id.Child_relationship1);//与孩子关系1
        relation_name_1 = getView(R.id.Child_relationship_name1);//姓名1
        relation_type_2 = getView(R.id.Child_relationship2);//与孩子关系2
        relation_name_2 = getView(R.id.Child_relationship_name2);//姓名2
    }

    private int gender = 7;

    @Override
    public void initData() {
        mSVProgressHUD = new SVProgressHUD(context);
        aCache = ACache.get(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == 3) {
                    gender = 1;
                } else if (checkedId == 4) {
                    gender = 0;
                }
            }
        });
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
            case R.id.rgper_back:
                finish();
                break;
            case R.id.rgper_enterprise://个业注册
                startAct(Act_Enterprise_Registration.class);
                break;
            case R.id.rg_next_step://注册
                postPersonal();
                break;
        }
    }

    /**
     * 个人注册请求
     */
    public void postPersonal() {
        if (real_name.getText().toString() == null) {
            MyToast.show(context, "请输入孩子姓名");
            return;
        }
        if (gender == 7) {
            MyToast.show(context, "请选择你的性别");
            return;
        }
        if (age.getText().toString() == null) {
            MyToast.show(context, "请输入孩子年龄");
            return;
        }
        if (address.getText().toString() == null) {
            MyToast.show(context, "请输入详细地址");
            return;
        }

        mSVProgressHUD.showWithStatus("请求中...");
        HttpReqest httpReqest = new HttpReqest();
        HashMap hashMap = new HashMap();
        hashMap.put("phone", aCache.getAsString("phone"));
        hashMap.put("captcha", aCache.getAsString("captcha"));
        hashMap.put("password", aCache.getAsString("password"));
        hashMap.put("type", aCache.getAsString("type"));
        hashMap.put("province", aCache.getAsString("province"));
        hashMap.put("city", aCache.getAsString("city"));
        hashMap.put("district", aCache.getAsString("district"));
        hashMap.put("real_name", real_name.getText().toString());
        hashMap.put("gender", aCache.getAsString("phone"));
        hashMap.put("address", address.getText().toString());
        hashMap.put("relation_type_1", relation_type_1.getText().toString());
        hashMap.put("relation_name_1", relation_name_1.getText().toString());
        if (relation_type_2.getText().toString() != null && relation_name_2.getText().toString() != null) {
            hashMap.put("relation_type_2", relation_type_2.getText().toString());
            hashMap.put("relation_name_2", relation_name_2.getText().toString());
        }
        hashMap.put("phone", aCache.getAsString("phone"));
        hashMap.put("phone", aCache.getAsString("phone"));
    Debug.e("=========="+aCache.getAsString("session_id"));
        httpReqest.HttpPost("i=1&c=entry&do=signup&m=ted_users", hashMap,aCache.getAsString("session_id"), new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e("-onSuccess-----" + response.body());
                InforMationBean bean = new InforMationBean();
                Gson gson = new Gson();
                bean = gson.fromJson(response.body(), InforMationBean.class);
                if (bean.getError_code().equals("200")) {
                    startActClear(Act_Login.class);
                }
                mSVProgressHUD.dismiss();
            }

            @Override
            public void onError(Response<String> response) {
                mSVProgressHUD.dismiss();
            }
        });
    }
}
