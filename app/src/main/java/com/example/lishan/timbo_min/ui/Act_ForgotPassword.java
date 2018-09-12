package com.example.lishan.timbo_min.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.CodeBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.example.lishan.timbo_min.view.CountdownButton;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

/**
 * Created by lishan on 2017/12/9.
 */

public class Act_ForgotPassword extends BaseAct {
    private EditText phone;
    private CountdownButton code;
    @Override
    public int initLayoutId() {
        return R.layout.act_forgotpassword;
    }

    @Override
    public void initView() {
        hideHeader();
        phone = getView(R.id.forgotpassword_phone);
        code = getViewAndClick(R.id.forgotpassword_countdownButton);
    }

    @Override
    public void initData() {
        mSVProgressHUD = new SVProgressHUD(context);
        httpReqest = new HttpReqest();
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
                    case R.id.forgotpassword_countdownButton:
                        PostBackCode();
                        break;
                }
    }

    /**
     * 发送验证码
     */
    private SVProgressHUD mSVProgressHUD;
    private HttpReqest httpReqest;
    public void PostBackCode() {
        if (TextUtils.isEmpty(phone.getText().toString())) {
            MyToast.show(context, "请输入手机号码！");
            return;
        }
        if (phone.getText().toString().length() == 18) {
            MyToast.show(context, "请输入手机号码位数错误！");
            return;
        }
        mSVProgressHUD.showWithStatus("发送中...");
        HashMap hashMap = new HashMap();
        hashMap.put("phone", phone.getText().toString());
        httpReqest.HttpPost("i=1&c=entry&do=find_send_captcha&m=ted_users", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e("---------" + response.body());
                mSVProgressHUD.dismiss();
                if (response.body().contains("204")) {
                    MyToast.show(context, "该手机号已注册！");
                    return;
                }
//                codeBean = gson.fromJson(response.body(), CodeBean.class);
//                if (codeBean.getSession_id() != null)
//                    aCache.put("session_id", codeBean.getSession_id());
                MyToast.show(context, "短信发送成功！");
            }

            @Override
            public void onError(Response<String> response) {
                mSVProgressHUD.dismiss();
            }
        });
    }
}
