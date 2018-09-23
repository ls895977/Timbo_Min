package com.example.lishan.timbo_min.ui.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.HealthpageGridAdagper;
import com.example.lishan.timbo_min.adapter.ProblemGridAdapter;
import com.example.lishan.timbo_min.bean.HealthpageGridBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.common.ComantUtils;
import com.example.lishan.timbo_min.dialog.Dlg_PhotoAlbum;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lishan on 2017/12/20.
 */

public class Act_Problem extends BaseAct implements AdapterView.OnItemClickListener, Dlg_PhotoAlbum.OnClick {
    private GridView myGridView;
    private Dlg_PhotoAlbum myDailog;
    private HttpReqest httpReqest = new HttpReqest();
    private Gson gson = new Gson();
    public SVProgressHUD mSVProgressHUD;
    @Override
    public int initLayoutId() {
        return R.layout.act_problem;
    }

    @Override
    public void initView() {
        setLeftTitle();
        myGridView = getView(R.id.problem_gridView);
        mSVProgressHUD = new SVProgressHUD(this);

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

//        mSVProgressHUD.showWithStatus("请稍后...");
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


    /**
     * 咨询菜单获取
     */
    List<HealthpageGridBean.DataBean> MenuList = new ArrayList<>();
    HealthpageGridAdagper adagper;

    public void postMenu() {
        HashMap<String, String> hashMap = new HashMap<>();
        httpReqest.HttpPost(ComantUtils.Basning_ted_grow_news_Url, hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                HealthpageGridBean bean = gson.fromJson(response.body(), HealthpageGridBean.class);
                for (int i = 0; i < bean.getData().size(); i++) {
                    HealthpageGridBean.DataBean gridBean = bean.getData().get(i);
                    MenuList.add(gridBean);
                }

                if (adagper == null) {
                    adagper = new HealthpageGridAdagper(Act_Problem.this);
                    adagper.setDatas(MenuList);
                    myGridView.setAdapter(adagper);
                } else {
                    adagper.setDatas(MenuList);
                    adagper.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(Response<String> response) {

            }
        });
    }
}
