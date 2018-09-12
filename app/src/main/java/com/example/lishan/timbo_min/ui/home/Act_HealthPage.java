package com.example.lishan.timbo_min.ui.home;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.HealthPageListAdapter;
import com.example.lishan.timbo_min.adapter.HealthpageGridAdagper;
import com.example.lishan.timbo_min.bean.HealthPagerListBean;
import com.example.lishan.timbo_min.bean.HomGrdBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.view.FullyLinearLayoutManager;
import com.example.lishan.timbo_min.view.MyGridView;
import com.lykj.aextreme.afinal.utils.Debug;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishan on 2017/12/16.
 */

public class Act_HealthPage extends BaseAct implements AdapterView.OnItemClickListener ,HealthPageListAdapter.OnItem {
    private MyGridView myGridView;
    private int image[] = {R.mipmap.icon_cj, R.mipmap.icon_sx, R.mipmap.icon_yr, R.mipmap.icon_jb
            , R.mipmap.icon_xx, R.mipmap.icon_zw};
    private String gridstr[] = {"营养菜肴", "身心健康", "育儿心得", "疾病防治", "学习成长", "家长杂问"};
    private List<HomGrdBean> gridBeanList;
    private RecyclerView myRecyclerView;

    @Override
    public int initLayoutId() {
        return R.layout.act_healthpage;
    }

    @Override
    public void initView() {
        initHeaderBack(R.string.healthPage_tilte,R.mipmap.icon_fen);
        myGridView = getView(R.id.healthpage_myGridView);
        myRecyclerView = getView(R.id.healthpageRecyclerView);
        gridBeanList = new ArrayList<>();
        myGridView.setOnItemClickListener(this);
    }

    @Override
    public void initData() {
        for (int i = 0; i < image.length; i++) {
            HomGrdBean gridBean = new HomGrdBean();
            gridBean.setName(gridstr[i]);
            gridBean.setImages(image[i]);
            gridBeanList.add(gridBean);
        }
        HealthpageGridAdagper adagper = new HealthpageGridAdagper(this);
        adagper.setDatas(gridBeanList);
        myGridView.setAdapter(adagper);


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
    }

    @Override
    public void requestData() {

    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onViewClick(View v) {
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent();
        intent.putExtra("title", gridstr[i]);
        startAct(intent, Act_GrowthConsultation.class);
    }

    @Override
    public void clickView(View view, int position) {
            startAct(Act_HealthPage_Details.class);
    }
}
