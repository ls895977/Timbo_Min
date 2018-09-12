package com.example.lishan.timbo_min.ui.member;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.IntegralAdapter;
import com.example.lishan.timbo_min.bean.IntegralBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 金豆
 * Created by Administrator on 2018/3/23 0023.
 */

public class Act_Imazamox extends BaseAct {
    TextView tv[] = new TextView[3];
    private XRecyclerView mRecyclerView;
    private List<IntegralBean> listData;
    private int indext = 0;

    @Override
    public int initLayoutId() {
        return R.layout.act_imazamox;
    }

    private IntegralAdapter mAdapter;
    private View header;

    //此页面adapter复用了积分adapter
    @Override
    public void initView() {
        hideHeader();
        mRecyclerView = getView(R.id.imazamox_xRecyclerview);
        header = LayoutInflater.from(this).inflate(R.layout.hader_imazamox, null);
        tv[0] = getViewAndClick(header, R.id.imazamox_tv_all);
        tv[1] = getViewAndClick(header, R.id.imazamox_tv_income);
        tv[2] = getViewAndClick(header, R.id.imazamox_tv_expenditure);
        setOnClickListener(header, R.id.imazamox_Rechargeofgoldbean);
        setOnClickListener(header, R.id.imazamox_ExtractionOfGoldBean);
        tv[indext].setSelected(true);
        setOnClickListener(R.id.imazamox_back);

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
            IntegralBean bean = new IntegralBean();
            listData.add(bean);
        }
        mRecyclerView.addHeaderView(header);
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                refreshTime++;
                listData.clear();
                for (int i = 0; i < 10; i++) {
                    IntegralBean bean = new IntegralBean();
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
                        IntegralBean bean = new IntegralBean();
                        listData.add(bean);
                    }
                    if (mRecyclerView != null) {
                        mRecyclerView.setNoMore(true);
                        mAdapter.notifyDataSetChanged();
                    }
                } else {
                    for (int i = 0; i < 10; i++) {
                        IntegralBean bean = new IntegralBean();
                        listData.add(bean);
                    }
                    if (mRecyclerView != null) {
                        mRecyclerView.loadMoreComplete();
                        mAdapter.notifyDataSetChanged();
                    }
                }
            }
        });

        mAdapter = new IntegralAdapter(listData);
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
            case R.id.imazamox_back:
                finish();
                break;
            case R.id.imazamox_tv_all:
                onSwcheSlecte(0);
                break;
            case R.id.imazamox_tv_income:
                onSwcheSlecte(1);
                break;
            case R.id.imazamox_tv_expenditure:
                onSwcheSlecte(2);
                break;
            case R.id.imazamox_Rechargeofgoldbean://金豆重置
                startAct(Act_Rechargeofgoldbean.class);
                break;
            case R.id.imazamox_ExtractionOfGoldBean://金豆体现
                startAct(Act_ExtractionOfGoldBean.class);
                break;

        }
    }

    public void onSwcheSlecte(int indext1) {
        tv[indext1].setSelected(true);
        tv[indext].setSelected(false);
        indext = indext1;
    }
}
