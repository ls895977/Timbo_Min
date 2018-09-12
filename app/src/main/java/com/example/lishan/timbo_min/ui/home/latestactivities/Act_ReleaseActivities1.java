package com.example.lishan.timbo_min.ui.home.latestactivities;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.ReleaseActivities1Bean;
import com.example.lishan.timbo_min.bean.ReleaseActivitiesBean;
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
 * 发布活动第二个界面
 * Created by lishan on 2018/1/18.
 */

public class Act_ReleaseActivities1 extends BaseAct {
    private EditText enroll_start, enroll_end, enroll_address, act_start, act_end, act_address, money;

    @Override
    public int initLayoutId() {
        return R.layout.act_releaseactivities1;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.releaseactivities1_back);
        setOnClickListener(R.id.releaseactivities1_but);
        enroll_start = getView(R.id.releaseactivities1_enroll_start);//开始时间
        enroll_end = getView(R.id.releaseactivities1_enroll_end);//结束时间
        enroll_address = getView(R.id.releaseactivities1_enroll_address);//地点
        act_start = getView(R.id.releaseactivities1_act_start);//活动开始时间
        act_end = getView(R.id.releaseactivities1_act_endt);//活动结束时间
        act_address = getView(R.id.releaseactivities1_act_address);//活动报名地址
        money = getView(R.id.releaseactivities1_money);//费用


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
            case R.id.releaseactivities1_back:
                finish();
                break;
            case R.id.releaseactivities1_but://下一步
                postDataBack();
                break;
        }
    }

    private ACache aCache;
    private SVProgressHUD mSVProgressHUD;

    public void postDataBack() {
        if (MyTooL.isDate(enroll_start.getText().toString())!=true) {
            MyToast.show(context, "请输入正确报名开始日期");
            return;
        }
        if (MyTooL.isDate(enroll_end.getText().toString())!=true) {
            MyToast.show(context, "请输入正确报名结束日期");
            return;
        }
        if (MyTooL.isDate(enroll_address.getText().toString())) {
            MyToast.show(context, "请输入报名地址");
            return;
        }
        if (MyTooL.isDate(act_start.getText().toString())!=true) {
            MyToast.show(context, "请输入正确活动开始日期");
            return;
        }
        if (MyTooL.isDate(act_end.getText().toString())!=true) {
            MyToast.show(context, "请输入正确活动结束日期");
            return;
        }
        if (MyTooL.isDate(act_address.getText().toString())) {
            MyToast.show(context, "请输入报名地址");
            return;
        }
        if (MyTooL.isDate(money.getText().toString())) {
            MyToast.show(context, "请输入报名费用");
            return;
        }
        aCache = ACache.get(context);
        mSVProgressHUD = new SVProgressHUD(context);
        mSVProgressHUD.showWithStatus("加载中...");
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body = new HashMap<>();
        body.put("user_token", aCache.getAsString("User_token"));
        body.put("id", aCache.getAsString("id"));//修改是必传
        body.put("enroll_start", enroll_start.getText().toString());
        body.put("enroll_end", enroll_end.getText().toString());
        body.put("enroll_address", enroll_address.getText().toString());
        body.put("act_start", act_start.getText().toString());
        body.put("act_end", act_end.getText().toString());
        body.put("act_address",act_address.getText().toString());
        body.put("enroll_money",money.getText().toString());
        httpReqest.HttpPost("i=1&c=entry&do=activity&m=dxf_act&op=addthree", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                ReleaseActivities1Bean bean=gson.fromJson(response.body(),ReleaseActivities1Bean.class);
                mSVProgressHUD.dismiss();
                if(bean.getError_code()==200){
                startAct(Act_ReleaseActivities2.class);
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
