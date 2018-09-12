package com.example.lishan.timbo_min.ui.home.growth.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.MyEssayListAdapter;
import com.example.lishan.timbo_min.bean.MyEssayBean;
import com.example.lishan.timbo_min.common.BaseFgt;
import com.example.lishan.timbo_min.ui.home.growth.Act_MyEssayDetails;
import com.example.lishan.timbo_min.view.FullyLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishan on 2017/12/25.
 */

public class Fgt_MyEssay extends BaseFgt {
    private RecyclerView myRecyclerView;
    private List<MyEssayBean> myEssayList;

    @Override
    public void sendMsg(int flag, Object obj) {

    }

    @Override
    public int initLayoutId() {
        return R.layout.fgt_myyessay;
    }

    @Override
    public void initView() {
        hideHeader();
        myRecyclerView = getView(R.id.myyessay_recyclerview);

        setOnClickListener(R.id.myyessay_chenzhang);
        setOnClickListener(R.id.myyessay_image);
        setOnClickListener(R.id.myyessay_grow);
    }

    @Override
    public void initData() {
        myEssayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyEssayBean bean = new MyEssayBean();
            myEssayList.add(bean);
        }
        MyEssayListAdapter adapter = new MyEssayListAdapter();
        adapter.setDatas(myEssayList);
        adapter.setContext(context);
        FullyLinearLayoutManager manager = new FullyLinearLayoutManager(context);
        myRecyclerView.setLayoutManager(manager);
        myRecyclerView.setAdapter(adapter);

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
            case R.id.myyessay_chenzhang:
            case R.id.myyessay_image:
            case R.id.myyessay_grow:
                startAct(Act_MyEssayDetails.class);
                break;
        }
    }
}
