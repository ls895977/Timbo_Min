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
 * Created by lishan on 2017/12/23.
 */

public class Act_I_Know extends BaseAct implements Dlg_PhotoAlbum.OnClick, AdapterView.OnItemClickListener {
    private GridView myi_know_gridView;

    @Override
    public int initLayoutId() {
        return R.layout.act_i_know;
    }

    @Override
    public void initView() {
        setTitle1("我知道");
        myi_know_gridView = getView(R.id.i_know_gridView);
    }

    private List<String> datas;
    private Dlg_PhotoAlbum myDailog;

    @Override
    public void initData() {
        ProblemGridAdapter adapter = new ProblemGridAdapter();
        adapter.setContext(this);
        datas = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            datas.add("");
        }
        adapter.setStr(datas);
        myi_know_gridView.setAdapter(adapter);
        myi_know_gridView.setOnItemClickListener(this);
        myDailog = new Dlg_PhotoAlbum(this, this);
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
    public void carmer() {
        Debug.e("相机");
    }

    @Override
    public void phonto() {
        Debug.e("xc");
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (datas.size() < 4) {
            if (datas.size() - 1 == i) {
                myDailog.show();
            }
        }
    }
}
