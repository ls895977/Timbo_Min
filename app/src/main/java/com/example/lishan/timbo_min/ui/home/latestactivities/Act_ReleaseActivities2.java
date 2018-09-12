package com.example.lishan.timbo_min.ui.home.latestactivities;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.ReleaseActivities1Bean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.common.MyTooL;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

/**
 * 发布活动第三个界面
 * Created by lishan on 2018/1/18.
 */

public class Act_ReleaseActivities2 extends BaseAct {
    private EditText enroll_contact,enroll_phone,enroll_wx,enroll_email,enroll_qq;
    @Override
    public int initLayoutId() {
        return R.layout.act_releaseactivities2;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.releaseactivities2_back);
        setOnClickListener(R.id.releaseactivities23_but);
        enroll_contact=getView(R.id.releaseactivities2_enroll_contact);
        enroll_phone=getView(R.id.releaseactivities2_enroll_phone);
        enroll_wx=getView(R.id.releaseactivities2_enroll_wx);
        enroll_email=getView(R.id.releaseactivities2_enroll_email);
        enroll_qq=getView(R.id.releaseactivities2_enroll_qq);
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
            case R.id.releaseactivities2_back:
                finish();
                break;
            case R.id.releaseactivities23_but://下一步
                postDataBack();
//                startAct(Act_ReleaseActivities3.class);
                break;
        }
    }
    private ACache aCache;
    private SVProgressHUD mSVProgressHUD;

    public void postDataBack() {
        if (TextUtils.isEmpty(enroll_contact.getText().toString())) {
            MyToast.show(context, "请输入联系人");
            return;
        }
        if (TextUtils.isEmpty(enroll_phone.getText().toString())) {
            MyToast.show(context, "请输入联系电话");
            return;
        }
        if (TextUtils.isEmpty(enroll_wx.getText().toString())) {
            MyToast.show(context, "请输入微信");
            return;
        }
        if (TextUtils.isEmpty(enroll_email.getText().toString())) {
            MyToast.show(context, "请输入邮箱");
            return;
        }
        if (TextUtils.isEmpty(enroll_qq.getText().toString())) {
            MyToast.show(context, "请输入qq");
            return;
        }

        aCache = ACache.get(context);
        mSVProgressHUD = new SVProgressHUD(context);
        mSVProgressHUD.showWithStatus("加载中...");
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body = new HashMap<>();
        body.put("user_token", aCache.getAsString("User_token"));
        body.put("id", aCache.getAsString("id"));//修改是必传
        body.put("enroll_contact",enroll_contact.getText().toString());
        body.put("enroll_phone",enroll_phone.getText().toString());
        body.put("enroll_qq",enroll_qq.getText().toString());
        body.put("enroll_email",enroll_email.getText().toString());
        body.put("enroll_wx",enroll_wx.getText().toString());
        body.put("enroll_img","");
        httpReqest.HttpPost("i=1&c=entry&do=activity&m=dxf_act&op=addfour", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e("----000-"+response.body());
                Gson gson = new Gson();
                ReleaseActivities1Bean bean=gson.fromJson(response.body(),ReleaseActivities1Bean.class);
                mSVProgressHUD.dismiss();
                if(bean.getError_code()==200){
                    startAct(Act_ReleaseActivities3.class);
                }else {
                    MyToast.show(context,bean.getError_message());
                }
            }
            @Override
            public void onError(Response<String> response) {
                mSVProgressHUD.dismiss();
            }
        });
    }
}