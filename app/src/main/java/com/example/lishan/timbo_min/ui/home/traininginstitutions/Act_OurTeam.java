package com.example.lishan.timbo_min.ui.home.traininginstitutions;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.EducationalVideoAdapter;
import com.example.lishan.timbo_min.adapter.OurTeamAdapter;
import com.example.lishan.timbo_min.bean.OurTeamBean;
import com.example.lishan.timbo_min.bean.TraininginstitutionsTuanduiBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.view.MyGridLayoutManager;
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
 * 优秀团队
 * Created by lishan on 2018/1/24.
 */

public class Act_OurTeam extends BaseAct {
    private RecyclerView myRecyclerView;
    private SmartRefreshLayout myRefresh;

    @Override
    public int initLayoutId() {
        return R.layout.act_ourteam;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.OurTeam_back);
        myRecyclerView = getView(R.id.OurTeam_recyclerview);
        myRefresh = getView(R.id.OurTeam_refreshLayout);

    }

    @Override
    public void initData() {
        myRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        myRefresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000/*,false*/);//传入false表示加载失败
            }
        });
        //设置头布局样式,全局有效
        myRefresh.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                //全局设置主题颜色
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);
                //指定为经典Header，默认是 贝塞尔雷达Header
                return new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate);
            }
        });
        datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            OurTeamBean bean = new OurTeamBean();
            datas.add(bean);
        }
        OurTeamAdapter adapter = new OurTeamAdapter();
        adapter.setContext(this);
        adapter.setDatas(datas);
        myRecyclerView.setAdapter(adapter);
        MyGridLayoutManager manager = new MyGridLayoutManager(this,2);
        myRecyclerView.setLayoutManager(manager);
    }
    private List<OurTeamBean> datas;
    @Override
    public void requestData() {

    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.OurTeam_back:
                finish();
                break;
        }
    }
}
