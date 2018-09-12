package com.example.lishan.timbo_min.ui.home.growth.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.GrowthActivityListAdapter;
import com.example.lishan.timbo_min.bean.GrowthActivityBean;
import com.example.lishan.timbo_min.common.BaseFgt;
import com.example.lishan.timbo_min.view.FullyLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishan on 2017/12/25.
 */

public class Fgt_GrowthActivity extends BaseFgt {
    private RecyclerView myRecyclerview;

    @Override
    public void sendMsg(int flag, Object obj) {

    }

    @Override
    public int initLayoutId() {
        return R.layout.fgt_growthactivity;
    }

    @Override
    public void initView() {
        hideHeader();
        myRecyclerview = getView(R.id.growthactivity_recyclerview);
    }

    private List<GrowthActivityBean> datas;

    @Override
    public void initData() {
        datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GrowthActivityBean bean = new GrowthActivityBean();
            datas.add(bean);
        }
        GrowthActivityListAdapter activityListAdapter = new GrowthActivityListAdapter();
        activityListAdapter.setDatas(datas);
        activityListAdapter.setContext(context);
        FullyLinearLayoutManager manager=new FullyLinearLayoutManager(context);
        myRecyclerview.setLayoutManager(manager);
        myRecyclerview.setAdapter(activityListAdapter);
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
}
