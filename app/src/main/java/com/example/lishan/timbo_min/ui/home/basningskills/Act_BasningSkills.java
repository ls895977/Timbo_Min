package com.example.lishan.timbo_min.ui.home.basningskills;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.BasningsKillstAdapter;
import com.example.lishan.timbo_min.bean.BasningskillstBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.view.MyGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 晒技能主界面
 * Created by lishan on 2018/1/17.
 */

public class Act_BasningSkills extends BaseAct implements BasningsKillstAdapter.BackButtonItemClick {

    private RecyclerView myRecyclerView;
    private TextView[] title = new TextView[5];

    @Override
    public int initLayoutId() {
        return R.layout.act_basningskills;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.basningskilll_back1);
        title[0] = getViewAndClick(R.id.item_basningskillsfenlei);
        title[1] = getViewAndClick(R.id.item_basningskillsrzuixin);
        title[2] = getViewAndClick(R.id.item_basningskillsrenqi);
        title[3] = getViewAndClick(R.id.item_basningskillsrepin);
        title[4] = getViewAndClick(R.id.item_basningskillstoupiao);
        title[indext].setSelected(true);
        myRecyclerView = getView(R.id.basningskillsRecyclerView);
    }

    private List<BasningskillstBean> datas;

    @Override
    public void initData() {
        datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            BasningskillstBean bean = new BasningskillstBean();
            datas.add(bean);
        }
        BasningsKillstAdapter adapter = new BasningsKillstAdapter(this);
        adapter.setContext(this);
        adapter.setDatas(datas);
        MyGridLayoutManager manager = new MyGridLayoutManager(this, 2);
        myRecyclerView.setLayoutManager(manager);
        myRecyclerView.setAdapter(adapter);
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
            case R.id.basningskilll_back1://返回
                finish();
                break;
            case R.id.item_basningskillsfenlei://分类
                OnTitle(0);
                break;
            case R.id.item_basningskillsrzuixin://最新
                OnTitle(1);
                break;
            case R.id.item_basningskillsrenqi://人气
                OnTitle(2);
                break;
            case R.id.item_basningskillsrepin://热评
                OnTitle(3);
                break;
            case R.id.item_basningskillstoupiao://投票
                startAct(Act_Vote.class);
                OnTitle(4);
                break;

        }
    }

    int indext = 0;

    public void OnTitle(int stats) {
        title[indext].setSelected(false);
        title[stats].setSelected(true);
        indext = stats;
    }

    @Override
    public void backClcikItem(int indext) {
        startAct(Act_BasningSkillsDetali.class);
    }
}
