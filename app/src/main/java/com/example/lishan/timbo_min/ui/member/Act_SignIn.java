package com.example.lishan.timbo_min.ui.member;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.IntegralAdapter;
import com.example.lishan.timbo_min.adapter.SignInAdapter;
import com.example.lishan.timbo_min.bean.IntegralBean;
import com.example.lishan.timbo_min.bean.SignInBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 签到记录
 * Created by Administrator on 2018/3/25 0025.
 */

public class Act_SignIn extends BaseAct {
    private XRecyclerView mRecyclerView;
    private List<SignInBean> listData;
    private SignInAdapter mAdapter;
    int refreshTime=0;
    @Override
    public int initLayoutId() {
        return R.layout.act_signin;
    }

    @Override
    public void initView() {
        hideHeader();
        mRecyclerView = getView(R.id.sigin_XRecyclerView);
        setOnClickListener(R.id.SignIn_back);
    }

    @Override
    public void initData() {
        listData = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        mRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);
        mRecyclerView
                .getDefaultRefreshHeaderView()
                .setRefreshTimeVisible(true);
        for (int i = 0; i < 10; i++) {
            SignInBean bean=new SignInBean();
            listData.add(bean);
        }
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                refreshTime++;
                listData.clear();
                for (int i = 0; i < 10; i++) {
                    SignInBean bean=new SignInBean();
                    listData.add(bean);
                }
                mAdapter.notifyDataSetChanged();
                if(mRecyclerView != null)
                    mRecyclerView.refreshComplete();
            }
            int mm=0;
            @Override
            public void onLoadMore() {
                mm++;
                if(mm>=2){
                    for (int i = 0; i < 10; i++) {
                        SignInBean bean=new SignInBean();
                        listData.add(bean);
                    }
                    if (mRecyclerView != null) {
                        mRecyclerView.setNoMore(true);
                        mAdapter.notifyDataSetChanged();
                    }
                }else {
                    for (int i = 0; i < 10; i++) {
                        SignInBean bean=new SignInBean();
                        listData.add(bean);
                    }
                    if (mRecyclerView != null) {
                        mRecyclerView.loadMoreComplete();
                        mAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
        mAdapter=new SignInAdapter(listData);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void requestData() {

    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onViewClick(View v) {
            switch (v.getId()){
                case R.id.SignIn_back:
                    finish();
                    break;
            }
    }
}
