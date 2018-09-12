package com.example.lishan.timbo_min.ui.member;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.ActivityRecordAdapter;
import com.example.lishan.timbo_min.adapter.IntegralAdapter;
import com.example.lishan.timbo_min.bean.ActivityRecordBean;
import com.example.lishan.timbo_min.bean.IntegralBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 活动记录
 * Created by Administrator on 2018/3/26 0026.
 */

public class Act_ActivityRecord extends BaseAct {
    TextView tv[] = new TextView[2];
    private XRecyclerView mRecyclerView;
    private List<ActivityRecordBean> listData;
    private ActivityRecordAdapter mAdapter;
    private int indext = 0;

    @Override
    public int initLayoutId() {
        return R.layout.act_activityrecord;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.ActivityRecord_back);
        tv[0] = getViewAndClick(R.id.ActivityRecord_tv_off);
        tv[1] = getViewAndClick(R.id.ActivityRecord_tv_center);
        tv[indext].setSelected(true);
        mRecyclerView = getView(R.id.ActivityRecord_xRecyclerview);
    }

    private int refreshTime = 0;
    private int times = 0;


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
            ActivityRecordBean bean = new ActivityRecordBean();
            listData.add(bean);
        }
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                refreshTime++;
                listData.clear();
                for (int i = 0; i < 10; i++) {
                    ActivityRecordBean bean = new ActivityRecordBean();
                    listData.add(bean);
                }
                mAdapter.notifyDataSetChanged();
                if (mRecyclerView != null)
                    mRecyclerView.refreshComplete();
            }

            int mm = 0;

            @Override
            public void onLoadMore() {
                mm++;
                if (mm >= 2) {
                    for (int i = 0; i < 10; i++) {
                        ActivityRecordBean bean = new ActivityRecordBean();
                        listData.add(bean);
                    }
                    if (mRecyclerView != null) {
                        mRecyclerView.setNoMore(true);
                        mAdapter.notifyDataSetChanged();
                    }
                } else {
                    for (int i = 0; i < 10; i++) {
                        ActivityRecordBean bean = new ActivityRecordBean();
                        listData.add(bean);
                    }
                    if (mRecyclerView != null) {
                        mRecyclerView.loadMoreComplete();
                        mAdapter.notifyDataSetChanged();
                    }
                }
            }
        });

        mAdapter = new ActivityRecordAdapter(listData);
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
        switch (v.getId()) {
            case R.id.ActivityRecord_back:
                finish();
                break;
            case R.id.ActivityRecord_tv_off:
                onSwcheSlecte(0);
                break;
            case R.id.ActivityRecord_tv_center:
                onSwcheSlecte(1);
                break;

        }
    }

    public void onSwcheSlecte(int indext1) {
        tv[indext1].setSelected(true);
        tv[indext].setSelected(false);
        indext = indext1;
    }
}
