package com.example.lishan.timbo_min.ui.home;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.HealthPageListAdapter;
import com.example.lishan.timbo_min.bean.HealthPagerListBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.common.ComantUtils;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.example.lishan.timbo_min.view.FullyLinearLayoutManager;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.CustomFooterViewCallBack;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 成长咨询列表页
 * Created by lishan on 2017/12/20.
 */

public class Act_GrowthConsultation extends BaseAct implements HealthPageListAdapter.OnItem, CustomFooterViewCallBack {
    private String title, cate_id, orderby = "create", keywords = "";
    private XRecyclerView mRecyclerView;
    private RelativeLayout showRelat;
    private ImageView banwenhao;
    private TextView tvTitle, newest, hottest, review;
    private ACache aCache;
    private Gson gson = new Gson();
    private View header, bottom;
    public SVProgressHUD mSVProgressHUD;
    private EditText search;

    @Override
    public void postponeEnterTransition() {

    }

    @Override
    public int initLayoutId() {
        return R.layout.act_growthconsultation;
    }

    @Override
    public void initView() {
        hideHeader();
        title = getIntent().getStringExtra("title");
        cate_id = getIntent().getStringExtra("cate_id");
        tvTitle = getView(R.id.growthconsultation_title);
        tvTitle.setText(title);
        setOnClickListener(R.id.growthconsultation_back);
        setOnClickListener(R.id.growthconsultation_right);
        aCache = ACache.get(this);
        mRecyclerView = getView(R.id.growth_recyclerview);
        showRelat = getView(R.id.growth_show);
        setOnClickListener(R.id.growth_wenhao);
        setOnClickListener(R.id.growth_chacha);
        banwenhao = getViewAndClick(R.id.growth_banwenhao);
        header = LayoutInflater.from(context).inflate(R.layout.view_growthconsultation_head, null);
        newest = getViewAndClick(header, R.id.growThconsulTation_newest);
        hottest = getViewAndClick(header, R.id.growThconsulTation_Hottest);
        review = getViewAndClick(header, R.id.growThconsulTation_hot_review);
        search = getViewAndClick(header, R.id.growth__search);
        setOnClickListener(header, R.id.growth__shutdown);
        bottom = LayoutInflater.from(context).inflate(R.layout.view_growthconsultation_bottom, null);
    }

    @Override
    public void initData() {
        mSVProgressHUD = new SVProgressHUD(this);
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
        mRecyclerView.setFootView(bottom, this);
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
        postLin();
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                datass.clear();
                keywords = search.getText().toString();
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
            case R.id.growth_wenhao://问号
                Intent intent = new Intent();
                intent.putExtra("indext", getIntent().getStringExtra("indext"));
                intent.setClass(context, Act_Problem.class);
                startActivityForResult(intent, 10);
                break;
            case R.id.growth_chacha://叉叉
                banwenhao.setVisibility(View.VISIBLE);
                showRelat.setVisibility(View.GONE);
                break;
            case R.id.growth_banwenhao://半问号
                banwenhao.setVisibility(View.GONE);
                showRelat.setVisibility(View.VISIBLE);
                break;
            case R.id.growthconsultation_back:
                finish();
                break;
            case R.id.growthconsultation_right://右边按钮
                break;
            case R.id.growThconsulTation_newest://最新
                orderby = "create";
                keywords = "";
                newest.setTextColor(getResources().getColor(R.color.fond_cloer));
                hottest.setTextColor(getResources().getColor(R.color.gray));
                hottest.setTextColor(getResources().getColor(R.color.gray));
                datass.clear();
                postLin();
                break;
            case R.id.growThconsulTation_Hottest://最热
                orderby = "hits";
                keywords = "";
                newest.setTextColor(getResources().getColor(R.color.gray));
                hottest.setTextColor(getResources().getColor(R.color.fond_cloer));
                review.setTextColor(getResources().getColor(R.color.gray));
                datass.clear();
                postLin();
                break;
            case R.id.growThconsulTation_hot_review://热评
                orderby = "comments";
                keywords = "";
                newest.setTextColor(getResources().getColor(R.color.gray));
                hottest.setTextColor(getResources().getColor(R.color.gray));
                review.setTextColor(getResources().getColor(R.color.fond_cloer));
                datass.clear();
                postLin();
                break;
            case R.id.growth__shutdown://删除
                search.setText("");
                break;
        }
    }

    @Override
    public void clickView(View view, int position) {
        Intent intent = new Intent();
        intent.putExtra("aid", datass.get(position).getAid());
        intent.putExtra("title", getIntent().getStringExtra("title"));
        intent.putExtra("cate_id", datass.get(position).getCate_id());
        startAct(intent, Act_HealthPage_Details.class);
    }

    /**
     * 成长资讯列表
     */
    private int page = 1;
    List<HealthPagerListBean.DataBean> datass = new ArrayList<>();
    private HealthPageListAdapter healthpageAdapter = null;
    HttpReqest httpReqest = new HttpReqest();

    public void postLin() {
        mSVProgressHUD.showWithStatus("请稍后...");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("user_token", aCache.getAsString("User_token"));
        hashMap.put("page", String.valueOf(page));
        hashMap.put("cate_id", cate_id);
        hashMap.put("orderby", orderby);
        hashMap.put("keywords", keywords);
        httpReqest.HttpPost(ComantUtils.Basning_ted_grow_news_List_Url, hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                mSVProgressHUD.dismiss();
                HealthPagerListBean bean = gson.fromJson(response.body(), HealthPagerListBean.class);
                for (int i = 0; i < bean.getData().size(); i++) {
                    HealthPagerListBean.DataBean listBean = bean.getData().get(i);
                    datass.add(listBean);
                }
                if (healthpageAdapter == null) {
                    healthpageAdapter = new HealthPageListAdapter(Act_GrowthConsultation.this);
                    healthpageAdapter.setContext(Act_GrowthConsultation.this);
                    healthpageAdapter.setDatas(datass);
                    mRecyclerView.setAdapter(healthpageAdapter);
                } else {
                    healthpageAdapter.setDatas(datass);
                    healthpageAdapter.notifyDataSetChanged();
                }
                showCView();
            }

            @Override
            public void onError(Response<String> response) {
                mSVProgressHUD.dismiss();
                List<HealthPagerListBean.DataBean> datass = new ArrayList<>();
                for (int i = 0; i < 1; i++) {
                    HealthPagerListBean.DataBean listBean = new HealthPagerListBean.DataBean();
                    datass.add(listBean);
                }
                if (healthpageAdapter == null) {
                    healthpageAdapter = new HealthPageListAdapter(Act_GrowthConsultation.this);
                    healthpageAdapter.setContext(Act_GrowthConsultation.this);
                    healthpageAdapter.setDatas(datass);
                    mRecyclerView.setAdapter(healthpageAdapter);
                } else {
                    healthpageAdapter.setDatas(datass);
                    healthpageAdapter.notifyDataSetChanged();
                }
                showCView();
            }
        });
    }

    @Override
    public void onLoadingMore(View yourFooterView) {
    }

    @Override
    public void onLoadMoreComplete(View yourFooterView) {
    }

    @Override
    public void onSetNoMore(View yourFooterView, boolean noMore) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == 10) {
            datass.clear();
            postLin();
        }
    }
}
