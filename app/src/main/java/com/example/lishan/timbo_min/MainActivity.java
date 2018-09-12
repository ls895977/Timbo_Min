package com.example.lishan.timbo_min;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.common.BaseFgt;
import com.example.lishan.timbo_min.dialog.Dlg_Release;
import com.example.lishan.timbo_min.ui.home.Act_HealthPage;
import com.example.lishan.timbo_min.ui.home.Act_Problem;
import com.example.lishan.timbo_min.ui.home.basningskills.Act_BasningSkills;
import com.example.lishan.timbo_min.ui.home.latestactivities.Act_ReleaseActivities;
import com.example.lishan.timbo_min.ui.mainfragment.Fgt_Enterprise;
import com.example.lishan.timbo_min.ui.mainfragment.Fgt_Follow;
import com.example.lishan.timbo_min.ui.mainfragment.Fgt_Member;
import com.example.lishan.timbo_min.ui.mainfragment.Fgt_Message;
import com.example.lishan.timbo_min.ui.mainfragment.Fgt_Zhong;
import com.example.lishan.timbo_min.ui.mainfragment.Fgt_home;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseAct implements Dlg_Release.OnClick {
    private Dlg_Release dalog;
    TextView[] tvItem;
    private List<BaseFgt> fgtData = new ArrayList<>();
    private ACache aCache;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        aCache = ACache.get(context);
        hideHeader();
        tvItem = new TextView[5];
        tvItem[0] = getViewAndClick(R.id.tab_home);
        tvItem[1] = getViewAndClick(R.id.tab_follow);
        tvItem[2] = getViewAndClick(R.id.tab_zhong);
        tvItem[3] = getViewAndClick(R.id.tab_message);
        tvItem[4] = getViewAndClick(R.id.tab_member);
        tvItem[0].setSelected(true);
    }

    @Override
    public void initData() {
        fgtData.add(new Fgt_home());
        fgtData.add(new Fgt_Follow());
        fgtData.add(new Fgt_Zhong());
        fgtData.add(new Fgt_Message());
        if (aCache.getAsString("uid_type") != null && aCache.getAsString("uid_type").equals("0")) {//个人
            fgtData.add(new Fgt_Member());
        } else if (aCache.getAsString("uid_type") != null && aCache.getAsString("uid_type").equals("2")) {//企业
            fgtData.add(new Fgt_Enterprise());
        }
        getSupportFragmentManager().beginTransaction().add(R.id.myFrame, fgtData.get(0)).add(R.id.myFrame, fgtData.get(1)).hide(fgtData.get(1)).show(fgtData.get(0)).commit();
        dalog = new Dlg_Release(this, this);
        dalog.setCanceledOnTouchOutside(false);
        dalog.setCancelable(false);
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
            case R.id.tab_home:
                setCurrent(0);
                break;
            case R.id.tab_follow:
                setCurrent(1);
                break;
            case R.id.tab_zhong:
//                        setCurrent(2);
                dalog.show();
               break;
            case R.id.tab_message:
                setCurrent(3);
                break;
            case R.id.tab_member:
                setCurrent(4);
                break;
        }
    }
    public int currentTabIndex = 0;
    public void setCurrent(int indext) {
        if (currentTabIndex != indext) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(fgtData.get(currentTabIndex));
            if (!fgtData.get(indext).isAdded()) {
                trx.add(R.id.myFrame, fgtData.get(indext));
            }
            trx.show(fgtData.get(indext)).commit();
        }
        tvItem[currentTabIndex].setSelected(false);
        tvItem[indext].setSelected(true);
        currentTabIndex = indext;
    }
    @Override
    public void OnBackClick(int p) {
        switch (p) {
            case 1://发布活动
                startAct(Act_ReleaseActivities.class);
                break;
            case 2://晒技能
                startAct(Act_BasningSkills.class);
                break;
            case 3://我要提问
                startAct(Act_Problem.class);
                break;
            case 4://成长资讯
                startAct(Act_HealthPage.class);
                break;
        }
        dalog.dismiss();
    }
}
