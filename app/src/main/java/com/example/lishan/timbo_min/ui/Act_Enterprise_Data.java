package com.example.lishan.timbo_min.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.lishan.timbo_min.R;
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

public class Act_Enterprise_Data extends BaseAct {
    private String phone, captcha, password, gender, province, city,
            real_name;
    private ImageView iv1, iv2, iv3;
    private TextView tv1, tv2, tv3;
    private EditText company_name, credit_code, address, guhua, quhao, fenji, education_type;

    @Override
    public int initLayoutId() {
        return R.layout.act_enterprise_data;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.ed_back);
        setOnClickListener(R.id.Enterprise_Data_p1);
        setOnClickListener(R.id.Enterprise_Data_p2);
        setOnClickListener(R.id.Enterprise_Data_p3);
        iv1 = getView(R.id.Enterprise_Data_iv1);
        iv2 = getView(R.id.Enterprise_Data_iv2);
        iv3 = getView(R.id.Enterprise_Data_iv3);
        tv1 = getView(R.id.Enterprise_Data_t1);
        tv2 = getView(R.id.Enterprise_Data_t2);
        tv3 = getView(R.id.Enterprise_Data_t3);
        company_name = getView(R.id.Enterprisecompany_name);
        credit_code = getView(R.id.Enterprise_credit_code);
        address = getView(R.id.Enterprise_Data_address);
        guhua = getView(R.id.rg_guhua);
        quhao = getView(R.id.rg_quhao);
        fenji = getView(R.id.rg_fenji);
        education_type = getView(R.id.Enterprise_Data_education_type);
        setOnClickListener(R.id.Enterprise_Data_zhuce);
    }

    @Override
    public void initData() {
        phone = getIntent().getStringExtra("phone");
        captcha = getIntent().getStringExtra("code");
        password = getIntent().getStringExtra("pwd");
        gender = getIntent().getStringExtra("sex");
        province = getIntent().getStringExtra("shen");
        city = getIntent().getStringExtra("shi");
        real_name = getIntent().getStringExtra("contacts");
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
            case R.id.ed_back:
                finish();
                break;
            case R.id.Enterprise_Data_p1://法人身份证正面

                break;
            case R.id.Enterprise_Data_p2://法人身份证反面

                break;
            case R.id.Enterprise_Data_p3://营业执照

                break;
            case R.id.Enterprise_Data_zhuce://注册
                postPersonal();
                break;
        }
    }

    /**
     * 个人注册请求
     */
    private ACache aCache;
    private SVProgressHUD mSVProgressHUD;
    private InforMationBean bean;

    public void postPersonal() {
        if (TextUtils.isEmpty(company_name.getText().toString())) {
            MyToast.show(context, "请输入企业名称");
            return;
        }
        if (TextUtils.isEmpty(credit_code.getText().toString())) {
            MyToast.show(context, "请输入信用代码");
            return;
        }
        if (TextUtils.isEmpty(address.getText().toString())) {
            MyToast.show(context, "请输入详细地址");
            return;
        }
        if (TextUtils.isEmpty(guhua.getText().toString())) {
            MyToast.show(context, "请输入固话");
            return;
        }
        if (TextUtils.isEmpty(quhao.getText().toString())) {
            MyToast.show(context, "请输入区号");
            return;
        }
        if (TextUtils.isEmpty(fenji.getText().toString())) {
            MyToast.show(context, "请输入分机");
            return;
        }
        if (TextUtils.isEmpty(education_type.getText().toString())) {
            MyToast.show(context, "请输入教育类型");
            return;
        }
        mSVProgressHUD = new SVProgressHUD(context);
        aCache = ACache.get(context);
        mSVProgressHUD.showWithStatus("请求中...");
        HttpReqest httpReqest = new HttpReqest();
        HashMap hashMap = new HashMap();
        hashMap.put("phone", phone);
        hashMap.put("captcha",captcha);
        Debug.e("----captcha----"+captcha);
        hashMap.put("password", password);
        hashMap.put("type", aCache.getAsString("type"));
        hashMap.put("province", province);
        hashMap.put("city", city);
        hashMap.put("real_name", real_name);
        hashMap.put("gender", gender);
        hashMap.put("address", address.getText().toString());
        Debug.e("session_id======="+aCache.getAsString("session_id"));
        httpReqest.HttpPost("i=1&c=entry&do=signup&m=ted_users",hashMap,aCache.getAsString("session_id"), new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e("-onSuccess-----" + response.body());
                Gson gson = new Gson();
                bean = gson.fromJson(response.body(), InforMationBean.class);
                if (bean.getError_code().equals("200")) {
                    startActClear(Act_Login.class);
                }else {
                    MyToast.show(context,bean.getError_message());
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
