package com.example.lishan.timbo_min.ui.home.growth.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.MyAlbumListAdapter;
import com.example.lishan.timbo_min.bean.MyAlbumBean;
import com.example.lishan.timbo_min.common.BaseFgt;
import com.example.lishan.timbo_min.ui.home.growth.Act_Comment_Details;
import com.example.lishan.timbo_min.ui.home.growth.Act_Picture_Browsing;
import com.example.lishan.timbo_min.view.FullyLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishan on 2017/12/25.
 */

public class Fgt_MyAlbum extends BaseFgt implements MyAlbumListAdapter.ObackItem {
    private RecyclerView myRecyclerView;
    private List<MyAlbumBean> datas;

    @Override
    public void sendMsg(int flag, Object obj) {

    }

    @Override
    public int initLayoutId() {
        return R.layout.fgt_myalbum;
    }

    @Override
    public void initView() {
        hideHeader();
        myRecyclerView = getView(R.id.myalbum_recyclerview);
    }

    @Override
    public void initData() {
        datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyAlbumBean bean = new MyAlbumBean();
            datas.add(bean);
        }
        MyAlbumListAdapter adapter = new MyAlbumListAdapter(this);
        adapter.setContext(context);
        adapter.setDatas(datas);
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

    }

    @Override
    public void itemMessage(int position) {
        startAct(Act_Comment_Details.class);
    }

    @Override
    public void itemImage(int position) {
            startAct(Act_Picture_Browsing.class);
    }
}
