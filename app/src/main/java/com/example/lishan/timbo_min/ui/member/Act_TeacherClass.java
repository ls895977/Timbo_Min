package com.example.lishan.timbo_min.ui.member;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.TeacherClassAdapter;
import com.example.lishan.timbo_min.bean.TeacherClassBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;

import java.util.ArrayList;
import java.util.List;

/**
 * 老师状态下的：我的班级
 * Created by Administrator on 2018/3/31 0031.
 */
public class Act_TeacherClass extends BaseAct {
    private View header;
    private TextView tv[] = new TextView[2];
    private XRecyclerView mRecyclerView;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mRecyclerView != null) {
            mRecyclerView.destroy();
            mRecyclerView = null;
        }
    }

    @Override
    public int initLayoutId() {
        return R.layout.act_teacherclass;
    }

    private int indext = 0;
    private List<TeacherClassBean> listData;
    private TeacherClassAdapter mAdapter;

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.teacherclass_back);
        header = LayoutInflater.from(this).inflate(R.layout.item_teacherclass_hader, (ViewGroup) findViewById(android.R.id.content), false);
        tv[0] = getViewAndClick(header, R.id.teacherclass_hadert_v1);
        tv[1] = getViewAndClick(header, R.id.teacherclass_hadert_v2);
        tv[indext].setSelected(true);
    }

    private int refreshTime = 0;
    private int mm = 0;

    @Override
    public void initData() {
        listData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TeacherClassBean bean = new TeacherClassBean();
            listData.add(bean);
        }
        mRecyclerView = getView(R.id.TeacherClass_XRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        mRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);
        mRecyclerView
                .getDefaultRefreshHeaderView()
                .setRefreshTimeVisible(true);
        mRecyclerView.addHeaderView(header);
        mRecyclerView.getDefaultFootView().setLoadingHint("自定义加载中提示");
        mRecyclerView.getDefaultFootView().setNoMoreHint("自定义加载完毕提示");
        mRecyclerView.setLimitNumberToCallLoadMore(2);
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                refreshTime++;
                listData.clear();
                for (int i = 0; i < 10; i++) {
                    TeacherClassBean bean = new TeacherClassBean();
                    listData.add(bean);
                }
                mAdapter.notifyDataSetChanged();
                if (mRecyclerView != null)
                    mRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                mm++;
                if (mm >= 2) {
                    for (int i = 0; i < 10; i++) {
                        TeacherClassBean bean = new TeacherClassBean();
                        listData.add(bean);
                    }
                    if (mRecyclerView != null) {
                        mRecyclerView.setNoMore(true);
                        mAdapter.notifyDataSetChanged();
                    }
                } else {
                    for (int i = 0; i < 10; i++) {
                        TeacherClassBean bean = new TeacherClassBean();
                        listData.add(bean);
                    }
                    if (mRecyclerView != null) {
                        mRecyclerView.loadMoreComplete();
                        mAdapter.notifyDataSetChanged();
                    }
                }
            }

        });

        listData = new ArrayList<>();
        mAdapter = new TeacherClassAdapter(listData);
        mAdapter.setClickCallBack(
                new TeacherClassAdapter.ItemClickCallBack() {
                    @Override
                    public void OnBackItem(int indext) {
                        startAct(Act_MyTeacher1.class);
                    }

                    @Override
                    public void OnModify(int indext)
                    {
                        startAct(Act_MyTeacher.class);
                    }

                    @Override
                    public void OnButn(int indext) {
                        startAct(Act_MyTeacher.class);
                    }
                }
        );
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.refresh();
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
            case R.id.teacherclass_hadert_v1:
                swche(0);
                break;
            case R.id.teacherclass_hadert_v2:
                swche(1);
                break;
            case R.id.teacherclass_back:
                finish();
                break;
        }
    }

    public void swche(int indext1) {
        tv[indext].setSelected(false);
        tv[indext1].setSelected(true);
        indext = indext1;
    }
}
