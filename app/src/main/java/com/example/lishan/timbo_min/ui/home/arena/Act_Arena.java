package com.example.lishan.timbo_min.ui.home.arena;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.ArenaListAdapter;
import com.example.lishan.timbo_min.bean.ArenaBean;
import com.example.lishan.timbo_min.bean.ArenaTitleBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.example.lishan.timbo_min.view.MyGridLayoutManager;
import com.example.lishan.timbo_min.view.PopupWindowUtil;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * PK晋级场
 * Created by lishan on 2018/1/12.
 */

public class Act_Arena extends BaseAct implements ArenaListAdapter.BackButtonClick, PopupWindowUtil.OnBackItemPosition {
    private SVProgressHUD svProgressHUD;
    private RecyclerView myRecyclerView;
    private TextView[] title = new TextView[4];
    private final String[] mTitles = {
            "成长记录", " 的随笔", "成长活动"
            , "我的相册",};
    private String[] titlefenlei = {"跳绳", "跳远", "等等", "跳绳", "跳远", "跳绳", "跳远", "等等", "跳绳", "跳远"};
    List<String> datas = new ArrayList<>();
    private List<ArenaBean.DataBean> datassss;
    private Gson gson;

    @Override
    public int initLayoutId() {
        return R.layout.act_arena;
    }

    @Override
    public void initView() {
        hideHeader();
        datassss = new ArrayList<>();
        setOnClickListener(R.id.arena_back);
        setOnClickListener(R.id.arena_jiangbei);
        setOnClickListener(R.id.profile_image);
        setOnClickListener(R.id.arena_buttom);
        myRecyclerView = getView(R.id.arenaRecyclerView);
        title[0] = getViewAndClick(R.id.item_arenachengzhang);
        title[1] = getViewAndClick(R.id.item_arenasuibi);
        title[2] = getViewAndClick(R.id.item_arenahuodong);
        title[3] = getViewAndClick(R.id.item_arenaxiangce);
        for (int i = 1; i < title.length; i++) {
            title[i].setSelected(false);
        }
    }

    PopupWindowUtil popupWindowUtil;

    @Override
    public void initData() {
        gson = new Gson();
        svProgressHUD = new SVProgressHUD(context);
        for (int i = 0; i < titlefenlei.length; i++) {
            datas.add(titlefenlei[i]);
        }
        title[sta].setSelected(true);
        postBackHomeData("", "", "");
    }

    @Override
    public void requestData() {


    }

    @Override
    public void updateUI() {

    }

    private View myview;

    @Override
    public void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.arena_back:
                finish();
                break;
            case R.id.item_arenachengzhang:
                postShowTitle();
                myview = v;
                setChage(0);
                break;
            case R.id.item_arenasuibi:
//                popupWindowUtil.show(v);
                setChage(1);
                postBackHomeData("", "1", "");
                break;
            case R.id.item_arenahuodong:
//                popupWindowUtil.show(v);
                setChage(2);
                postBackHomeData("", "", "1");
                break;
            case R.id.item_arenaxiangce:
//                popupWindowUtil.show(v);
                setChage(3);
                break;
            case R.id.arena_jiangbei:
//                Intent intent = new Intent();
//                intent.putExtra("type_id", bean.getData().get(indext).getLz().getId());
//                startAct(intent,Act_MyEssay.class);
//                startAct(Act_ReleaseActivities.class);
                break;
            case R.id.profile_image:
            case R.id.arena_buttom:
                startAct(Act_MyEssay.class);
                break;
        }
    }


    int sta = 0;

    public void setChage(int stats) {
        title[sta].setSelected(false);
        title[stats].setSelected(true);
        sta = stats;
    }

    @Override
    public void backClcik(int indext) {
        Intent intent = new Intent();
        intent.putExtra("type_id", bean.getData().get(indext).getLz().getId());
        startAct(intent,Act_MyEssay.class);

    }

    @Override
    public void arenabutton(int indext) {
        Intent intent = new Intent();
        intent.putExtra("type_id", bean.getData().get(indext).getLz().getId());
        startAct(intent, Act_ArenaDetailPage.class);
    }


    /**
     * 显示title
     */
    ArenaTitleBean titleBean;
    public void postShowTitle() {
        svProgressHUD.showWithStatus("数据请请中.....");
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> hashMap = new HashMap<>();
        httpReqest.HttpPost("i=1&c=entry&do=app&m=pk_arena&op=get_type", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                svProgressHUD.dismiss();
                titleBean = gson.fromJson(response.body(), ArenaTitleBean.class);
                List<ArenaTitleBean.DataBean> datas = new ArrayList<>();
                for (int i = 0; i < titleBean.getData().size(); i++) {
                    ArenaTitleBean.DataBean bean1 = new ArenaTitleBean.DataBean();
                    bean1.setId(titleBean.getData().get(i).getId());
                    bean1.setTitle(titleBean.getData().get(i).getTitle());
                    datas.add(bean1);
                }
                popupWindowUtil = new PopupWindowUtil(context, datas, Act_Arena.this);
                popupWindowUtil.show(myview);
            }

            @Override
            public void onError(Response<String> response) {
                svProgressHUD.dismiss();
                MyToast.show(context, "数据请求失败!");
            }
        });

    }

    @Override
    public void onBackPostion(int position) {
        Debug.e(titleBean.getData().get(position).getId() + "----------" + titleBean.getData().get(position).getTitle());
        postBackHomeData(titleBean.getData().get(position).getId(), "", "");
        popupWindowUtil.dismiss();
    }
    /**
     * 获取首页数据
     */
    private ArenaListAdapter arenaListAdapter = null;
    private ArenaBean bean;
    public void postBackHomeData(String type_id, String is_new, String is_hot) {
        svProgressHUD.showWithStatus("数据请请中.....");
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("type_id", type_id);
        hashMap.put("is_new", is_new);
        hashMap.put("is_hot", is_hot);
        httpReqest.HttpGet("i=6&c=entry&do=app&m=pk_arena&op=index", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                bean = gson.fromJson(response.body(), ArenaBean.class);
                datassss.clear();
                for (int i = 0; i < bean.getData().size(); i++) {
                    ArenaBean.DataBean bean1 = bean.getData().get(i);
                    datassss.add(bean1);
                }
                if (arenaListAdapter == null) {
                    arenaListAdapter = new ArenaListAdapter(Act_Arena.this);
                    arenaListAdapter.setDatas(datassss);
                    arenaListAdapter.setContext(Act_Arena.this);
                    MyGridLayoutManager manager = new MyGridLayoutManager(Act_Arena.this, 2);
                    myRecyclerView.setLayoutManager(manager);
                    myRecyclerView.setAdapter(arenaListAdapter);
                } else {
                    myRecyclerView.setAdapter(arenaListAdapter);
                    arenaListAdapter.notifyDataSetChanged();
                }
                svProgressHUD.dismiss();
            }
            @Override
            public void onError(Response<String> response) {
                svProgressHUD.dismiss();
                MyToast.show(context, "数据请求失败!");
            }
        });

    }
}
