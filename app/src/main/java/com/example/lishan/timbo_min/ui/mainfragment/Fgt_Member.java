package com.example.lishan.timbo_min.ui.mainfragment;

import android.content.Intent;
import android.util.ArrayMap;
import android.view.View;
import android.widget.AdapterView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.MemberGridAdapter;
import com.example.lishan.timbo_min.bean.MemberBean;
import com.example.lishan.timbo_min.common.BaseFgt;
import com.example.lishan.timbo_min.common.ComantUtils;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.example.lishan.timbo_min.ui.Act_Login;
import com.example.lishan.timbo_min.ui.MyWebView;
import com.example.lishan.timbo_min.ui.member.Act_ActivityRecord;
import com.example.lishan.timbo_min.ui.member.Act_Classroom;
import com.example.lishan.timbo_min.ui.member.Act_Collection;
import com.example.lishan.timbo_min.ui.member.Act_Coupons;
import com.example.lishan.timbo_min.ui.member.Act_Follow;
import com.example.lishan.timbo_min.ui.member.Act_Imazamox;
import com.example.lishan.timbo_min.ui.member.Act_Integral;
import com.example.lishan.timbo_min.ui.member.Act_MyPK;
import com.example.lishan.timbo_min.ui.member.Act_MyRecord;
import com.example.lishan.timbo_min.ui.member.Act_Parent;
import com.example.lishan.timbo_min.ui.member.Act_PersonalData;
import com.example.lishan.timbo_min.ui.member.Act_SignIn;
import com.example.lishan.timbo_min.ui.member.Act_Skill;
import com.example.lishan.timbo_min.ui.member.Act_TeacherClass;
import com.example.lishan.timbo_min.view.MyGridView;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 会员
 * Created by lishan on 2017/12/10.
 */

public class Fgt_Member extends BaseFgt implements AdapterView.OnItemClickListener {
    private MyGridView myGridView;
    private int[] ims = {R.mipmap.icon_member1, R.mipmap.icon_member2, R.mipmap.icon_member3
            , R.mipmap.icon_member4, R.mipmap.icon_member5, R.mipmap.icon_member6, R.mipmap.icon_member7, R.mipmap.icon_member8
            , R.mipmap.icon_member9, R.mipmap.icon_member10, R.mipmap.icon_member11, R.mipmap.icon_member12, R.mipmap.icon_member13,
            R.mipmap.icon_member14, R.mipmap.icon_member15, R.mipmap.icon_member16, R.mipmap.baoming, R.mipmap.quan, R.mipmap.beiwang, R.mipmap.xinxi, R.mipmap.icon_member17, R.mipmap.icon_member18};
    private String[] name = {"积分 500", "金豆850", "签到记录", "我的关注", "成长记录", "我的评论", "我的计划", "我的班级", "体型检测"
            , "活动记录", "我的PK", "我的技能", "我的收藏", "我的课堂", "积分收藏", "家  长  帮", "报名管理", "优惠卷", "备忘录", "消息中心", "用户退出", "系统信息"};
    private ACache aCache;

    @Override
    public void sendMsg(int flag, Object obj) {

    }

    @Override
    public int initLayoutId() {
        return R.layout.fgt_member;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.member_fanhui);
        myGridView = getView(R.id.memberGridview);
        setOnClickListener(R.id.my_hader);
    }

    private List<MemberBean> datas;

    @Override
    public void initData() {
        datas = new ArrayList<>();
        aCache = ACache.get(context);
        for (int i = 0; i < ims.length; i++) {
            MemberBean bean = new MemberBean();
            bean.setImgs(ims[i]);
            bean.setTitle(name[i]);
            datas.add(bean);
        }
        MemberGridAdapter adapter = new MemberGridAdapter(context, datas);
        myGridView.setAdapter(adapter);
        myGridView.setOnItemClickListener(this);
        intent = new Intent();
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
            case R.id.member_fanhui:

                break;
            case R.id.my_hader:
                startAct(Act_PersonalData.class);
                break;
        }
    }

    private Intent intent;

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0://积分
                intent.putExtra("indext", 0);
                startAct(intent, MyWebView.class);
//                startAct(Act_Integral.class);
                break;
            case 1://金豆
                startAct(Act_Imazamox.class);
                break;
            case 2://签到记录
                startAct(Act_SignIn.class);
                break;
            case 3://我的关注
                startAct(Act_Follow.class);
            case 4://成长记录
                intent.putExtra("indext", 1);
                startAct(intent, MyWebView.class);
                break;
            case 5://我的评论
                intent.putExtra("indext", 2);
                startAct(intent, MyWebView.class);
//                startAct(Act_MyRecord.class);
                break;
            case 7://我的班级
                //老师状态
                startAct(Act_TeacherClass.class);
                break;
            case 9://活动记录
                intent.putExtra("indext", 3);
                startAct(intent, MyWebView.class);
//                startAct(Act_ActivityRecord.class);
                break;
            case 10://我的pk
                startAct(Act_MyPK.class);
                break;
            case 11://我的技能
//                startAct(Act_Skill.class);
                intent.putExtra("indext", 4);
                startAct(intent, MyWebView.class);
                break;
            case 12://我的收藏
                startAct(Act_Collection.class);
                break;
            case 13://我的课堂
                startAct(Act_Classroom.class);
                break;
            case 15://家长帮
                startAct(Act_Parent.class);
                break;
            case 18://优惠劵
                startAct(Act_Coupons.class);
                break;
            case 20://退出
                aCache.clear();
                startAct(Act_Login.class);
                break;
        }
    }

    /**
     * 签到状态
     */
    public void SignInStitic() {
        HttpReqest httpReqest = new HttpReqest();
        Map<String, String> params = new android.support.v4.util.ArrayMap<>();
        params.put("user_token", aCache.getAsString("User_token"));
        httpReqest.HttpPost(ComantUtils.SignInUrl, params, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e("----onSuccess---------" + response.body());
            }
            @Override
            public void onError(Response<String> response) {
                Debug.e("----onError---------" + response.body());
            }
        });
    }

}
