package com.example.lishan.timbo_min.ui.home.myclass;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.MyClassAdapter;
import com.example.lishan.timbo_min.bean.MyClassBean;
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
 * 我的班级
 * Created by lishan on 2018/1/15.
 */

public class Act_MyClass extends BaseAct implements MyClassAdapter.BackButtonClick1 {
    private SmartRefreshLayout refreshLayout;
    private View haderView;
    private RecyclerView myRecyclerView;

    @Override
    public int initLayoutId() {
        return R.layout.act_myclass;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.myclass_back);
        refreshLayout = getView(R.id.refreshLayout);
        myRecyclerView = getView(R.id.item_classrecyclerview);
    }

    private List<MyClassBean> datas;

    @Override
    public void initData() {
        datas = new ArrayList<>();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000/*,false*/);//传入false表示加载失败
            }
        });
        haderView = LayoutInflater.from(this).inflate(R.layout.hader_myclass, null);
        for (int i = 0; i < 5; i++) {
            MyClassBean bean = new MyClassBean();
            bean.setBack(i);
            switch (i) {
                case 0:
                    bean.setName("运动");
                    break;
                case 1:
                    bean.setName("竞技场");
                    break;
                case 2:
                    bean.setName("成长");
                    break;
                case 3:
                    bean.setName("晒技能");
                    break;
                case 4:
                    bean.setName("活动");
                    break;
            }
            datas.add(bean);
        }
        MyClassAdapter adapter = new MyClassAdapter(this);
        adapter.setDatas(datas);
        adapter.setContext(this);
        FullyLinearLayoutManager manager = new FullyLinearLayoutManager(this);
        myRecyclerView.setLayoutManager(manager);
        myRecyclerView.setAdapter(adapter);


        //设置头布局样式,全局有效
        refreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
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
            case R.id.myclass_back:
                finish();
                break;
        }
    }

    @Override
    public void backItem(int indext) {
            startAct(Act_MyTeacher.class);
    }
}
