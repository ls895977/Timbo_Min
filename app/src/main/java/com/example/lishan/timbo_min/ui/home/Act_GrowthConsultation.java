package com.example.lishan.timbo_min.ui.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.HealthPageListAdapter;
import com.example.lishan.timbo_min.bean.HealthPagerListBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.view.FullyLinearLayoutManager;
import com.lykj.aextreme.afinal.utils.Debug;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishan on 2017/12/20.
 */

public class Act_GrowthConsultation extends BaseAct implements HealthPageListAdapter.OnItem {
    private String title;
    private TextView tv_title;
    private RecyclerView myRecyclerView;
    private RelativeLayout showRelat;
    private ImageView banwenhao;

    @Override
    public int initLayoutId() {
        return R.layout.act_growthconsultation;
    }

    @Override
    public void initView() {
        title = getIntent().getStringExtra("title");
        initchatTitle(title, R.mipmap.icon_fen);
        myRecyclerView = getView(R.id.growth_recyclerview);
        HealthPageListAdapter healthpageAdapter = new HealthPageListAdapter(this);
        healthpageAdapter.setContext(this);
        List<HealthPagerListBean> datass = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            HealthPagerListBean listBean = new HealthPagerListBean();
            if (i % 2 == 0) {
                listBean.setName("1");
                Debug.e("-----" + "11");
            } else {
                listBean.setName("2");
            }
            datass.add(listBean);
        }
        Debug.e("--------" + datass.size());
        healthpageAdapter.setDatas(datass);
        myRecyclerView.setAdapter(healthpageAdapter);
        FullyLinearLayoutManager manager = new FullyLinearLayoutManager(context);
        myRecyclerView.setLayoutManager(manager);
        showRelat = getView(R.id.growth_show);
        setOnClickListener(R.id.growth_wenhao);
        setOnClickListener(R.id.growth_chacha);
        banwenhao = getViewAndClick(R.id.growth_banwenhao);
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
            case R.id.growth_wenhao://问号
                startAct(Act_Problem.class);
                break;
            case R.id.growth_chacha://叉叉
                banwenhao.setVisibility(View.VISIBLE);
                showRelat.setVisibility(View.GONE);
                break;
            case R.id.growth_banwenhao://半问号
                banwenhao.setVisibility(View.GONE);
                showRelat.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void clickView(View view, int position) {
        startAct(Act_HealthPage_Details.class);
    }
}
