package com.example.lishan.timbo_min.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.lishan.timbo_min.MainActivity;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.CodeBean;
import com.example.lishan.timbo_min.bean.LoginBean;
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
 * Created by lishan on 2017/12/9.
 */

public class Act_Login extends BaseAct {
    EditText phone, pwd;
    private SVProgressHUD mSVProgressHUD;
    private ACache aCache;

    @Override
    public int initLayoutId() {
        return R.layout.act_login;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.ForgotPassword);
        setOnClickListener(R.id.Register);
        setOnClickListener(R.id.bt_login);
        phone = getView(R.id.login_phone);
        pwd = getView(R.id.login_pwd);
        aCache = ACache.get(this);
    }

    @Override
    public void initData() {
        mSVProgressHUD = new SVProgressHUD(context);
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
            case R.id.ForgotPassword:
                startAct(Act_ForgotPassword.class);
                break;
            case R.id.Register:
                startAct(Act_RegistrationSelection.class);
                break;
            case R.id.bt_login:
                PostLogin();
                break;
        }
    }


    /**
     * 登录接口
     */
    public void PostLogin() {
        if (TextUtils.isEmpty(phone.getText().toString())) {
            MyToast.show(context, "请输入手机号码！");
            return;
        }
        if (phone.getText().toString().length() == 18) {
            MyToast.show(context, "请输入手机号码位数错误！");
            return;
        }
        mSVProgressHUD.showWithStatus("登录...");
        HttpReqest httpReqest = new HttpReqest();
        HashMap hashMap = new HashMap();
        hashMap.put("phone", phone.getText().toString());
        hashMap.put("password", pwd.getText().toString());
        httpReqest.HttpPost("i=1&c=entry&do=login&m=ted_users", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                if(!response.body().contains("204")){
                LoginBean loginBean = gson.fromJson(response.body(), LoginBean.class);
                MyToast.show(context, "登录成功！");
                if (loginBean.getError_code().equals("200")) {
                    startActClear(MainActivity.class);
                    Debug.e("----User_token-----"+loginBean.getData().getUser_token());
                    aCache.put("User_token",loginBean.getData().getUser_token());
                    aCache.put("uid_type", loginBean.getData().getType());
                    aCache.put("Company_img",loginBean.getData().getCompany_img());
                    aCache.put("company_name",loginBean.getData().getCompany_name());
                    aCache.put("id",loginBean.getData().getUid());
                    finish();
                }
                }else {
                    MyToast.show(context,"手机号不存在！");
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
