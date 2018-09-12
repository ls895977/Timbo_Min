package com.example.lishan.timbo_min.ui.home.competencedducation;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.CompetencEdducationAdapter;
import com.example.lishan.timbo_min.bean.ArenaTitleBean;
import com.example.lishan.timbo_min.bean.CED_PuPBean;
import com.example.lishan.timbo_min.bean.CompetencEdducationBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.example.lishan.timbo_min.view.FullyLinearLayoutManager;
import com.example.lishan.timbo_min.view.PopupWindowUtil;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 素质教育
 * Created by lishan on 2018/1/19.
 */
public class Act_CompetencEdducation extends BaseAct implements CompetencEdducationAdapter.BackButtonClicked, PopupWindowUtil.OnBackItemPosition {
    private SVProgressHUD mSVProgressHUD;
    private TextView[] title = new TextView[4];
    private RecyclerView myRecyclerView;

    //    private List<CompetencEdducationBean> datas;
    @Override
    public int initLayoutId() {
        return R.layout.act_competencedducation;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.competencedducation_back);
        title[0] = getViewAndClick(R.id.item_CompetencEdducatio_zuixin);
        title[1] = getViewAndClick(R.id.item_CompetencEdducatio_zuire);
        title[2] = getViewAndClick(R.id.item_CompetencEdducatio_haopin);
        title[3] = getViewAndClick(R.id.item_CompetencEdducatio_zuijin);
        myRecyclerView = getView(R.id.myCompetencedducation);
        setOnClickListener(R.id.CompetencEdducation_class);//分类
    }

    @Override
    public void initData() {
        mSVProgressHUD = new SVProgressHUD(context);
        dataBeanList = new ArrayList<>();
        showLoading();
        setSwche(0);
        onBackData();
    }

    @Override
    public void requestData() {

    }

    @Override
    public void updateUI() {

    }

    private View myshowView;

    @Override
    public void onViewClick(View v) {
        myshowView = v;
        switch (v.getId()) {
            case R.id.competencedducation_back:
                finish();
                break;
            case R.id.item_CompetencEdducatio_zuixin:
                setSwche(0);
                indext=0;
                onBackData();
                break;
            case R.id.item_CompetencEdducatio_zuire:
                setSwche(1);
                indext=1;
                onBackData();
                break;
            case R.id.item_CompetencEdducatio_haopin:
                setSwche(2);
                indext=2;
                onBackData();
                break;
            case R.id.item_CompetencEdducatio_zuijin:
                setSwche(3);
                indext=3;
                onBackData();
                break;
            case R.id.CompetencEdducation_class://分类
                postClassification();
                break;
        }
    }

    private int mm = 0;

    public void setSwche(int stas) {
        title[mm].setSelected(false);
        title[stas].setSelected(true);
        mm = stas;
    }

    @Override
    public void OnItemBack(int potion) {
        startAct(Act_CompetencEdducationDetal.class);
    }

    PopupWindowUtil popupWindowUtil;
    List<ArenaTitleBean.DataBean> datas;

    public void postClassification() {
        HashMap<String, String> hashMap = new HashMap<>();
        HttpReqest httpReqest = new HttpReqest();
        httpReqest.HttpPost("i=1&c=entry&do=category&m=ted_edu", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                CED_PuPBean puPBean = gson.fromJson(response.body(), CED_PuPBean.class);
                datas = new ArrayList<>();
                for (int i = 0; i < puPBean.getData().size(); i++) {
                    ArenaTitleBean.DataBean dataBean = new ArenaTitleBean.DataBean();
                    dataBean.setTitle(puPBean.getData().get(i).getCate_name());
                    dataBean.setId(puPBean.getData().get(i).getCate_id());
                    datas.add(dataBean);
                }
                popupWindowUtil = new PopupWindowUtil(context, datas, Act_CompetencEdducation.this);
                popupWindowUtil.show(myshowView);
                mSVProgressHUD.dismiss();
            }

            @Override
            public void onError(Response<String> response) {
                MyToast.show(context, "数据获取失败!");
                mSVProgressHUD.dismiss();
            }
        });


    }

    /**
     * 分类选择的结果
     *
     * @param position
     */
    @Override
    public void onBackPostion(int position) {
        popupWindowUtil.dismiss();
    }

    /**
     * 获取列表
     */
    private int indext = 0;
    CompetencEdducationAdapter adapter;
    private List<CompetencEdducationBean.DataBean> dataBeanList;

    public void onBackData() {
        HashMap<String, String> hashMap = new HashMap<>();
        HttpReqest httpReqest = new HttpReqest();
        hashMap.put("cate_id", String.valueOf(indext));
        httpReqest.HttpPost("i=1&c=entry&do=list&m=ted_edu", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                mSVProgressHUD.dismiss();
                CompetencEdducationBean bean = gson.fromJson(response.body(), CompetencEdducationBean.class);
                dataBeanList.clear();
                for (int i = 0; i < bean.getData().size(); i++) {
                    dataBeanList.add(bean.getData().get(i));
                }
                if (adapter == null) {
                    adapter = new CompetencEdducationAdapter(Act_CompetencEdducation.this);
                    adapter.setDatas(dataBeanList);
                    adapter.setContext(context);
                    myRecyclerView.setAdapter(adapter);
                    FullyLinearLayoutManager manager = new FullyLinearLayoutManager(Act_CompetencEdducation.this);
                    myRecyclerView.setLayoutManager(manager);
                }else {
                    adapter.setDatas(dataBeanList);
                    adapter.setContext(context);
                    adapter.notifyDataSetChanged();
                }
                showCView();

            }

            @Override
            public void onError(Response<String> response) {
                mSVProgressHUD.dismiss();
                MyToast.show(context, "数据获取失败!");
                showCView();
            }
        });


    }
}
