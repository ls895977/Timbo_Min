package com.example.lishan.timbo_min.ui.home.latestactivities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.Activity_ContentBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.common.MyTooL;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by lishan on 2018/1/19.
 */

public class Act_Activity_Content extends BaseAct {
    private ACache aCache;
    Activity_ContentBean contentBean;
    private CircleImageView myHamder;
    private TextView name, org_level, geren_name, title, time, see_num, collect_num, des,
            enlistStart, enlistend, act_start, act_end, addr, age, enroll_contact, enroll_phone,
            enroll_qq, enroll_wx, enroll_email, enroll_money;
    private LinearLayout myQiye, myaddImage;

    @Override
    public int initLayoutId() {
        return R.layout.act_activity_content;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.activity_back);
        myHamder = getView(R.id.Activity_Content_image);
        name = getView(R.id.Activity_Content_name);
        org_level = getView(R.id.Activity_Content_org_level);
        myQiye = getView(R.id.Activity_Content_uid_types);
        geren_name = getView(R.id.Activity_Content_geren_name);
        title = getView(R.id.Activity_Content_org_title);
        time = getView(R.id.Activity_Content_org_time);
        see_num = getView(R.id.Activity_Content_see_num);
        collect_num = getView(R.id.Activity_Content_collect_num);
        des = getView(R.id.Activity_Content_des);
        enlistStart = getView(R.id.Activity_Content_enlistStart);
        enlistend = getView(R.id.Activity_Content_enlistendt);
        act_start = getView(R.id.Activity_Content_act_start);
        act_end = getView(R.id.Activity_Content_act_end);
        addr = getView(R.id.Activity_Content_org_title);
        age = getView(R.id.Activity_Content_age);
        enroll_contact = getView(R.id.Activity_Content_enroll_contact);
        enroll_phone = getView(R.id.Activity_Content_enroll_phone);
        enroll_qq = getView(R.id.Activity_Content_enroll_enroll_qq);
        enroll_wx = getView(R.id.Activity_Content_enroll_enroll_wx);
        enroll_email = getView(R.id.Activity_Content_enroll_enroll_email);
        enroll_money = getView(R.id.Activity_Content_enroll_money);
        myaddImage = getView(R.id.Activity_Content_myaddimage);
        setOnClickListener(R.id.Activity_Content_enroll_mybaomin);
    }

    @Override
    public void initData() {
        aCache = ACache.get(this);
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
            case R.id.activity_back:
                finish();
                break;
            case R.id.Activity_Content_enroll_mybaomin:
                Intent intent = new Intent();
                intent.putExtra("id", getIntent().getStringExtra("id"));
                startAct(intent,Act_Enro.class);
                break;//去要报名
        }
    }

    private int[] img = {R.mipmap.icon_jin, R.mipmap.icon_jin, R.mipmap.icon_jin};

    public void PostData() {
        showLoading();
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body = new HashMap<>();
        body.put("id", getIntent().getStringExtra("id"));
        httpReqest.HttpPost("i=1&c=entry&do=activity&m=dxf_act&op=actdetail", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e(response.body());
                Gson gson = new Gson();
                contentBean = gson.fromJson(response.body(), Activity_ContentBean.class);
                Glide.with(context).load(contentBean.getMain_data().getCom_headimg()).into(myHamder);
                name.setText(contentBean.getMain_data().getAct_address());
                if (contentBean.getMain_data().getUid_type().equals("0")) {//显示学生
                    geren_name.setVisibility(View.VISIBLE);
                    geren_name.setText(contentBean.getMain_data().getCom_name());
                    myQiye.setVisibility(View.GONE);


                } else if (contentBean.getMain_data().getUid_type().equals("1")) {//显示老师
                    myQiye.setVisibility(View.GONE);
                    geren_name.setVisibility(View.GONE);

                } else if (contentBean.getMain_data().getUid_type().equals("2")) {//显示企业
                    myQiye.setVisibility(View.VISIBLE);
                    geren_name.setVisibility(View.GONE);
                    //                    case "0"://普通
//                        break;
//                    case "1"://银
//                        break;
//                    case "2"://金
                    Drawable drawable = getResources().getDrawable(img[Integer.valueOf(contentBean.getMain_data().getOrg_level())]);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    org_level.setCompoundDrawables(drawable, null, null, null);//设置TextView的drawableleft
                }
//                for (int i=0;i<contentBean.getMain_data().getImg().size();i++){
//                    ImageView imageView=new ImageView(context);
//                    myaddImage.addView(imageView);
//                    Glide.with(context).load(contentBean.getMain_data().getImg().get(i)).into(imageView);
//
//                }
                enroll_money.setText(contentBean.getMain_data().getEnroll_money());
                enroll_email.setText(contentBean.getMain_data().getEnroll_email());
                enroll_wx.setText(contentBean.getMain_data().getEnroll_wx());
                enroll_qq.setText(contentBean.getMain_data().getEnroll_qq());
                enroll_phone.setText(contentBean.getMain_data().getEnroll_phone());
                enroll_contact.setText(contentBean.getMain_data().getEnroll_contact());
                age.setText("报名范围：诸暨市 孩子年龄" + contentBean.getMain_data().getAge_start() + "-" + contentBean.getMain_data().getAct_end() + "岁");
                addr.setText(contentBean.getMain_data().getAct_address());
                enlistStart.setText("报名开始时间：" + contentBean.getMain_data().getEnroll_start());//报名开始时间
                enlistend.setText(("报名结束时间：" + contentBean.getMain_data().getEnroll_end()));//报名结束时间

                act_start.setText(("活动开始时间：" + contentBean.getMain_data().getAct_start()));//活动开始时间
                act_end.setText(("活动结束时间：" + contentBean.getMain_data().getAct_end()));

                des.setText(contentBean.getMain_data().getDes());
                collect_num.setText(contentBean.getMain_data().getCollect_num());
                see_num.setText(contentBean.getMain_data().getSee_num());
                time.setText(MyTooL.getStandardDate(contentBean.getMain_data().getCtime()));
                title.setText(contentBean.getMain_data().getTitle());
                showCView();
            }

            @Override
            public void onError(Response<String> response) {
                showCView();

            }
        });
    }
}
