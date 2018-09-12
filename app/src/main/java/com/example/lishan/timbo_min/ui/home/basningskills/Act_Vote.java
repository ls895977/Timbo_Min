package com.example.lishan.timbo_min.ui.home.basningskills;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.VoteAdapter;
import com.example.lishan.timbo_min.bean.VoteBean;
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
 * 投票
 * Created by lishan on 2018/1/30.
 */

public class Act_Vote extends BaseAct implements VoteAdapter.BackButtonClick1 {
    private SmartRefreshLayout MyRefreshlayout;

    private RecyclerView myRecyclerView;

    @Override
    public void postponeEnterTransition() {
        super.postponeEnterTransition();
    }

    @Override
    public int initLayoutId() {
        return R.layout.act_vote;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.vote_back);
        MyRefreshlayout = getView(R.id.vote_SmartRefreshLayout);
        myRecyclerView = getView(R.id.vote_RecyclerView);

    }

    @Override
    public void initData() {
        MyRefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        MyRefreshlayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000/*,false*/);//传入false表示加载失败
            }
        });

        //设置头布局样式,全局有效
        MyRefreshlayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                //全局设置主题颜色
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);
                //指定为经典Header，默认是 贝塞尔雷达Header
                return new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate);
            }
        });
        FullyLinearLayoutManager manager = new FullyLinearLayoutManager(this);
        myRecyclerView.setLayoutManager(manager);
        VoteAdapter voteAdapter = new VoteAdapter(this);
        List<VoteBean> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            VoteBean itemvote = new VoteBean();
            datas.add(itemvote);
        }
        voteAdapter.setContext(this);
        voteAdapter.setDatas(datas);
        myRecyclerView.setAdapter(voteAdapter);
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
            case R.id.vote_back:
                finish();
                break;
        }
    }

    @Override
    public void backItem(int indext) {
        startAct(Act_VotingDetails.class);
    }
}
