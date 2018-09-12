package com.example.lishan.timbo_min.ui.home.traininginstitutions;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.TraininginstitutionsTuanduiAdapter;
import com.example.lishan.timbo_min.bean.TraininginstitutionsTuanduiBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.view.FullyLinearLayoutManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 企业活动
 * Created by lishan on 2018/1/23.
 */

public class Act_TraininginstitutionsTuandui extends BaseAct {
    private RecyclerView myRecyclerview;
    private SmartRefreshLayout myrefreshLayout;

    @Override
    public int initLayoutId() {
        return R.layout.act_traininginstitutionstuandui;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.traininginstitutionstuandui_back);
        myRecyclerview = getView(R.id.traininginstitutionstuandui_recyclerview);
        myrefreshLayout = getView(R.id.traininginstitutionstuandui_refreshLayout);
    }

    private List<TraininginstitutionsTuanduiBean> datas;

    @Override
    public void initData() {
        myrefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        myrefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000/*,false*/);//传入false表示加载失败
            }
        });
        datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TraininginstitutionsTuanduiBean bean = new TraininginstitutionsTuanduiBean();
            datas.add(bean);
        }

        TraininginstitutionsTuanduiAdapter adapter = new TraininginstitutionsTuanduiAdapter();
        adapter.setContext(this);
        adapter.setDatas(datas);
        FullyLinearLayoutManager manager = new FullyLinearLayoutManager(this);
        myRecyclerview.setLayoutManager(manager);
        myRecyclerview.setAdapter(adapter);

        //设置头布局样式,全局有效
        myrefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                //全局设置主题颜色
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);
                //指定为经典Header，默认是 贝塞尔雷达Header
                return new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate);
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
            case R.id.traininginstitutionstuandui_back:
                finish();
                break;
        }
    }
}
