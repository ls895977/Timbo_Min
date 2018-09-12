package com.example.lishan.timbo_min.ui.member;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.ClassroomAdapter;
import com.example.lishan.timbo_min.adapter.CollectionAdapter;
import com.example.lishan.timbo_min.bean.ClassroomBean;
import com.example.lishan.timbo_min.bean.CollectionBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的课堂
 * Created by Administrator on 2018/3/26 0026.
 */
public class Act_Classroom extends BaseAct {
    private XRecyclerView mRecyclerView;
    private List<ClassroomBean> listData;
    private ClassroomAdapter mAdapter;
    int refreshTime=0;
    @Override
    public int initLayoutId() {
        return R.layout.act_collection;
    }

    @Override
    public void initView() {
        hideHeader();
        mRecyclerView = getView(R.id.collection_XRecyclerView);
        setOnClickListener(R.id.collection_back);


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
            ClassroomBean bean=new ClassroomBean();
            listData.add(bean);
        }
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                refreshTime++;
                listData.clear();
                for (int i = 0; i < 10; i++) {
                    ClassroomBean bean=new ClassroomBean();
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
                        ClassroomBean bean=new ClassroomBean();
                        listData.add(bean);
                    }
                    if (mRecyclerView != null) {
                        mRecyclerView.setNoMore(true);
                        mAdapter.notifyDataSetChanged();
                    }
                }else {
                    for (int i = 0; i < 10; i++) {
                        ClassroomBean bean=new ClassroomBean();
                        listData.add(bean);
                    }
                    if (mRecyclerView != null) {
                        mRecyclerView.loadMoreComplete();
                        mAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
        mAdapter=new ClassroomAdapter(listData);
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
            case R.id.collection_back:
                finish();
                break;
        }
    }
}
