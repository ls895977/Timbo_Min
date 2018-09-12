package com.example.lishan.timbo_min.ui.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.ProblemGridAdapter;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.dialog.Dlg_PhotoAlbum;
import com.lykj.aextreme.afinal.utils.Debug;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishan on 2017/12/20.
 */

public class Act_Problem extends BaseAct implements AdapterView.OnItemClickListener, Dlg_PhotoAlbum.OnClick {
    private GridView myGridView;
    private Dlg_PhotoAlbum myDailog;

    @Override
    public int initLayoutId() {
        return R.layout.act_problem;
    }

    @Override
    public void initView() {
        setLeftTitle();
        myGridView = getView(R.id.problem_gridView);


    }

    private List<String> datas;

    @Override
    public void initData() {
        ProblemGridAdapter adapter = new ProblemGridAdapter();
        adapter.setContext(this);
        datas = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            datas.add("");
        }
        adapter.setStr(datas);
        myGridView.setAdapter(adapter);
        myGridView.setOnItemClickListener(this);
        myDailog = new Dlg_PhotoAlbum(this, this);
        setOnClickListener(R.id.bt_problem);
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
                        case R.id.bt_problem://提交

                            break;
                    }
        }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (datas.size() < 4) {
            if (datas.size() - 1 == i) {
                myDailog.show();
            }
        }
    }

    @Override
    public void carmer() {//相机
        Debug.e("相机");

    }

    @Override
    public void phonto() {//相册
        Debug.e("相册");
    }
}
