package com.example.lishan.timbo_min.ui.home.latestactivities;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.bumptech.glide.Glide;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.LatesActivitivitiesAdapter;
import com.example.lishan.timbo_min.bean.LatesActivitivitiesBean;
import com.example.lishan.timbo_min.bean.ReleaseActivitiesBean;
import com.example.lishan.timbo_min.bean.ReleaseActivitiesBeanLogin;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * 发布活动
 * Created by lishan on 2018/1/18.
 */

public class Act_ReleaseActivities extends BaseAct {
    private de.hdodenhof.circleimageview.CircleImageView hadmerImage;
    private ACache aCache;
    private TextView name;
    private EditText title, des, age_start, age_end, addr, city, region;
    private RadioGroup radiosex;

    @Override
    public int initLayoutId() {
        return R.layout.act_releaseactivities;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.releaseactivities_back);
        setOnClickListener(R.id.releaseactivities_but);
        hadmerImage = getView(R.id.releaseacivities_haderimage);
        name = getView(R.id.releaseacivities_name);
        title = getView(R.id.ReleaseActivities_title);
        des = getView(R.id.ReleaseActivities_des);
        radiosex = getView(R.id.ReleaseActivities_sex);
        age_start = getView(R.id.ReleaseActivities_age_start);
        age_end = getView(R.id.ReleaseActivities_age_end);
        addr = getView(R.id.ReleaseActivities_addr);
        city = getView(R.id.ReleaseActivities_city);
        region = getView(R.id.ReleaseActivities_region);
    }

    private int sex;
    private SVProgressHUD mSVProgressHUD;

    @Override
    public void initData() {
        mSVProgressHUD = new SVProgressHUD(context);
        aCache = ACache.get(this);
        postIsLogin();
        radiosex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case 4:
                        sex = 0;
                        break;
                    case 5:
                        sex = 1;
                        break;
                    case 6:
                        sex = 2;
                        break;
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
            case R.id.releaseactivities_back:
                finish();
                break;
            case R.id.releaseactivities_but://下一步
                postDataBack();
                break;
        }
    }


    public void postIsLogin() {
        showLoading();
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body = new HashMap<>();
        body.put("user_token", aCache.getAsString("User_token"));
        httpReqest.HttpPost("i=1&c=entry&do=activity&m=dxf_act&op=addone", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                ReleaseActivitiesBeanLogin loginBean = gson.fromJson(response.body(), ReleaseActivitiesBeanLogin.class);
                Glide.with(context).load(loginBean.getData().getHeadimg()).into(hadmerImage);
                name.setText(loginBean.getData().getName());
                showCView();
            }

            @Override
            public void onError(Response<String> response) {
                showCView();
            }
        });
    }

    public void postDataBack() {
        if (TextUtils.isEmpty(title.getText().toString())) {
            MyToast.show(context, "请输入：活动标题");
            return;
        }
        if (TextUtils.isEmpty(des.getText().toString())) {
            MyToast.show(context, "请输入：活动内容");
            return;
        }
        if (TextUtils.isEmpty(age_start.getText().toString())) {
            MyToast.show(context, "请输入：开始年龄");
            return;
        }
        if (TextUtils.isEmpty(age_end.getText().toString())) {
            MyToast.show(context, "请输入：结束年龄");
            return;
        }
        if (TextUtils.isEmpty(city.getText().toString())) {
            MyToast.show(context, "请输入：城市");
            return;
        }
        if (TextUtils.isEmpty(region.getText().toString())) {
            MyToast.show(context, "请输入：城市区域");
            return;
        }
        if (TextUtils.isEmpty(addr.getText().toString())) {
            MyToast.show(context, "请输入：详细地址");
            return;
        }
        mSVProgressHUD.showWithStatus("加载中...");
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body = new HashMap<>();
        body.put("user_token", aCache.getAsString("User_token"));
        body.put("title", title.getText().toString());
        body.put("des", des.getText().toString());
        body.put("sex", String.valueOf(sex));
        body.put("age_start", age_start.getText().toString());
        body.put("age_end", age_end.getText().toString());
        body.put("city", city.getText().toString());
        body.put("region", region.getText().toString());
        body.put("address", addr.getText().toString());
//        body.put("id", aCache.getAsString("User_token"));//修改是必传
        httpReqest.HttpPost("i=1&c=entry&do=activity&m=dxf_act&op=addtwo", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e("-----------" + response.body());
                Gson gson = new Gson();
                ReleaseActivitiesBean loginBean = gson.fromJson(response.body(), ReleaseActivitiesBean.class);
                MyToast.show(context, loginBean.getError_message());
                aCache.put("id",loginBean.getData().getId());
                mSVProgressHUD.dismiss();
                startAct(Act_ReleaseActivities1.class);
            }

            @Override
            public void onError(Response<String> response) {
                mSVProgressHUD.dismiss();
            }
        });
    }
}
