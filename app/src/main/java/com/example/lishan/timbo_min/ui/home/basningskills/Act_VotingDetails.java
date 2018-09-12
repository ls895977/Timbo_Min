package com.example.lishan.timbo_min.ui.home.basningskills;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.VotingDetailsAdapter;
import com.example.lishan.timbo_min.bean.VotingDetailsBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.ui.home.growth.Act_Comment_Details;
import com.example.lishan.timbo_min.view.FullyLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 投票详情页
 * Created by lishan on 2018/1/30.
 */

public class Act_VotingDetails extends BaseAct implements VotingDetailsAdapter.BackButtonClick1 {
    private RecyclerView myRecyclerview;

    @Override
    public int initLayoutId() {
        return R.layout.act_votingdetails;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.votedetails_back);
        myRecyclerview = getView(R.id.votingdetails_recyclerview);
        VotingDetailsAdapter adapter = new VotingDetailsAdapter(this);
        List<VotingDetailsBean> datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            VotingDetailsBean bean = new VotingDetailsBean();
            datas.add(bean);
        }
        adapter.setContext(this);
        adapter.setDatas(datas);
        myRecyclerview.setAdapter(adapter);
        FullyLinearLayoutManager manager = new FullyLinearLayoutManager(this);
        myRecyclerview.setLayoutManager(manager);
    }

    @Override
    public void initData() {

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
            case R.id.votedetails_back:
                finish();
                break;
        }
    }

    @Override
    public void backItem(int indext) {
        startAct(Act_Comment_Details.class);
    }
}
