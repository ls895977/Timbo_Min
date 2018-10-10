package com.example.lishan.timbo_min.ui.home;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.HealthPageListAdapter;
import com.example.lishan.timbo_min.adapter.HealthpageGridAdagper;
import com.example.lishan.timbo_min.bean.HealthPagerListBean;
import com.example.lishan.timbo_min.bean.HealthpageGridBean;
import com.example.lishan.timbo_min.bean.HomGrdBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.common.ComantUtils;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.example.lishan.timbo_min.view.FullyLinearLayoutManager;
import com.example.lishan.timbo_min.view.MyGridView;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 成长咨询首页
 * Created by lishan on 2017/12/16.
 */

public class Act_HealthPage extends BaseAct implements AdapterView.OnItemClickListener, HealthPageListAdapter.OnItem {
    private MyGridView myGridView;
    private List<HealthpageGridBean.DataBean> MenuList;
    private XRecyclerView mRecyclerView;
    private ACache aCache;
    private HttpReqest httpReqest = new HttpReqest();
    private View header;
    Gson gson = new Gson();
    private EditText serach;
    private String keywords = "";
    public SVProgressHUD mSVProgressHUD;
    @Override
    public int initLayoutId() {
        return R.layout.act_healthpage;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.healthpage_back);
        mRecyclerView = getView(R.id.healthpageRecyclerView);
        header = LayoutInflater.from(context).inflate(R.layout.view_healthpage, null);
        serach = getView(header, R.id.healthpage_search);
        setOnClickListener(header,R.id.healthpage_shutdown);
        myGridView = getView(header, R.id.healthpage_myGridView);
        MenuList = new ArrayList<>();
        myGridView.setOnItemClickListener(this);
        aCache = ACache.get(context);
        mSVProgressHUD = new SVProgressHUD(this);
    }

    @Override
    public void initData() {
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
        postMenu();
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                datass.clear();
                postLin();
                mRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                postLin();
                mRecyclerView.loadMoreComplete();
            }
        });
        serach.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                keywords = serach.getText().toString();
                postLin();
            }
        });
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
            case R.id.healthpage_back:
                finish();
                break;
            case R.id.healthpage_right://Title右边点击事件

                break;
            case R.id.healthpage_shutdown://删除
                keywords = "";
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent();
        intent.putExtra("title", MenuList.get(i).getCate_name());
        intent.putExtra("cate_id", MenuList.get(i).getCate_id());
        intent.putExtra("indext", String.valueOf(i));
        startAct(intent, Act_GrowthConsultation.class);
    }

    @Override
    public void clickView(View view, int position) {
        startAct(Act_HealthPage_Details.class);
    }

    /**
     * 咨询菜单获取
     */
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
                    adagper = new HealthpageGridAdagper(Act_HealthPage.this);
                    adagper.setDatas(MenuList);
                    myGridView.setAdapter(adagper);
                } else {
                    adagper.setDatas(MenuList);
                    adagper.notifyDataSetChanged();
                }
                postLin();
            }

            @Override
            public void onError(Response<String> response) {
                postLin();
            }
        });
    }

    /**
     * 成长资讯列表
     */
    private int page = 1;
    List<HealthPagerListBean.DataBean> datass = new ArrayList<>();
    private HealthPageListAdapter healthpageAdapter = null;
    public void postLin() {
        mSVProgressHUD.showWithStatus("请稍后...");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("user_token", aCache.getAsString("User_token"));
        hashMap.put("page", String.valueOf(page));
        hashMap.put("keywords", keywords);
        httpReqest.HttpPost(ComantUtils.Basning_ted_grow_news_List_Url, hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                HealthPagerListBean bean = gson.fromJson(response.body(), HealthPagerListBean.class);
                for (int i = 0; i < bean.getData().size(); i++) {
                    HealthPagerListBean.DataBean listBean = bean.getData().get(i);
                    datass.add(listBean);
                }
                if (healthpageAdapter == null) {
                    healthpageAdapter = new HealthPageListAdapter(Act_HealthPage.this);
                    healthpageAdapter.setContext(Act_HealthPage.this);
                    healthpageAdapter.setDatas(datass);
                    mRecyclerView.setAdapter(healthpageAdapter);
                } else {
                    healthpageAdapter.setDatas(datass);
                    healthpageAdapter.notifyDataSetChanged();
                }
                showCView();
                mSVProgressHUD.dismiss();
            }
            @Override
            public void onError(Response<String> response) {
                List<HealthPagerListBean.DataBean> datass = new ArrayList<>();
                for (int i = 0; i < 1; i++) {
                    HealthPagerListBean.DataBean listBean = new HealthPagerListBean.DataBean();
                    datass.add(listBean);
                }
                HealthPageListAdapter healthpageAdapter = new HealthPageListAdapter(Act_HealthPage.this);
                healthpageAdapter.setContext(Act_HealthPage.this);
                healthpageAdapter.setDatas(datass);
                mRecyclerView.setAdapter(healthpageAdapter);
                showCView();
                mSVProgressHUD.dismiss();
            }
        });
    }
}
