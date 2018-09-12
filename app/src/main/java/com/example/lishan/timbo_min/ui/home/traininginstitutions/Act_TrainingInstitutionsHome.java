package com.example.lishan.timbo_min.ui.home.traininginstitutions;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.TraininginstitutionsHomeAdapter;
import com.example.lishan.timbo_min.bean.TraininginstitutionsHomeBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.tool.GlideImageLoader;
import com.example.lishan.timbo_min.ui.home.latestactivities.Act_Activity_Content;
import com.example.lishan.timbo_min.view.MyGridLayoutManager;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * 栏目首页
 * Created by lishan on 2018/1/24.
 */

public class Act_TrainingInstitutionsHome extends BaseAct implements TraininginstitutionsHomeAdapter.onBackItem {
    private Banner mybanner;
    private RecyclerView myRecyclerview;

    @Override
    public int initLayoutId() {
        return R.layout.act_traininginstitutionshome;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.TrainingInstitutionshome_back);
        mybanner = getView(R.id.TrainingInstitutionshome_banner);
        myRecyclerview = getView(R.id.TrainingInstitutionshome_recyclerview);


    }

    @Override
    public void initData() {
        //本地图片数据（资源文件）
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.b1);
        list.add(R.mipmap.b2);
        list.add(R.mipmap.b3);
        mybanner.setImages(list)
                .setImageLoader(new GlideImageLoader())
                .start();


        TraininginstitutionsHomeAdapter adapter = new TraininginstitutionsHomeAdapter(this);
        adapter.setContext(this);
        List<TraininginstitutionsHomeBean> datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            TraininginstitutionsHomeBean bean = new TraininginstitutionsHomeBean();
            datas.add(bean);
        }
        adapter.setDatas(datas);
        MyGridLayoutManager manager = new MyGridLayoutManager(this,2);
        myRecyclerview.setLayoutManager(manager);
        myRecyclerview.setAdapter(adapter);
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
            case R.id.TrainingInstitutionshome_back:
                finish();
                break;
        }
    }

    @Override
    public void onItem(int position) {
        startAct(Act_TrainingInstitutions.class);
    }
}
