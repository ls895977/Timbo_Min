package com.example.lishan.timbo_min.ui.home.latestactivities;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.Activity_ContentBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.common.MyTooL;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 我要报名
 * Created by lishan on 2018/1/18.
 */

public class Act_Enro extends BaseAct {
    private CircleImageView hidiamge;
    private TextView geren, mechanism_name, addr, title, des, ctime, num,enroll_money;
    private RadioButton main, girl;

    @Override
    public int initLayoutId() {
        return R.layout.act_enro;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.enro_back);
        hidiamge = getView(R.id.Act_Enro_image);
        geren = getView(R.id.Act_Enro_geren_name);
        mechanism_name = getView(R.id.Act_Enro_mechanism_name);
        addr = getView(R.id.Act_Enro_addr);
        title = getView(R.id.Act_Enro_title);
        des = getView(R.id.Act_Enro_des);
        ctime = getView(R.id.Act_Enro_ctime);
        num = getView(R.id.Act_Enro_collect_num);
        main = getView(R.id.Act_Enro_main);
        girl = getView(R.id.Act_Enro_girl);
        enroll_money=getView(R.id.Act_Enro_enroll_money);
    }

    @Override
    public void initData() {
        PostData();
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
            case R.id.enro_back:
                finish();
                break;
        }
    }

    private Activity_ContentBean contentBean;

    public void PostData() {
        showLoading();
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body = new HashMap<>();
        body.put("id", getIntent().getStringExtra("id"));
        Debug.e("id========" + getIntent().getStringExtra("id"));
        httpReqest.HttpPost("i=1&c=entry&do=activity&m=dxf_act&op=actdetail", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                contentBean = gson.fromJson(response.body(), Activity_ContentBean.class);
                showCView();
                Glide.with(context).load(contentBean.getMain_data().getCom_headimg()).into(hidiamge);
                switch (contentBean.getMain_data().getUid_type()) {
                    case "0"://学生
                        geren.setVisibility(View.VISIBLE);
                        geren.setText(contentBean.getMain_data().getCom_name());
                        mechanism_name.setVisibility(View.GONE);
                        break;
                    case "1"://老师
                        geren.setVisibility(View.GONE);
                        mechanism_name.setVisibility(View.GONE);
                        break;
                    case "2"://企业
                        geren.setVisibility(View.GONE);
                        mechanism_name.setVisibility(View.VISIBLE);
                        mechanism_name.setText(contentBean.getMain_data().getCom_name());
                        break;
                }
                addr.setText(contentBean.getMain_data().getAct_address());
                title.setText(contentBean.getMain_data().getTitle());
                des.setText(contentBean.getMain_data().getDes());
                num.setText(contentBean.getMain_data().getCollect_num());
                switch (contentBean.getMain_data().getSex()) {//设置性别
                    case "0"://不限
                        girl.setChecked(false);
                        main.setChecked(false);
                        break;
                    case "1"://男
                        girl.setChecked(false);
                        main.setChecked(true);
                        break;//女
                    case "2":
                        girl.setChecked(true);
                        main.setChecked(false);
                        break;
                }
                enroll_money.setText(contentBean.getMain_data().getEnroll_money()+"元");

            }

            @Override
            public void onError(Response<String> response) {
                showCView();

            }
        });
    }
}
