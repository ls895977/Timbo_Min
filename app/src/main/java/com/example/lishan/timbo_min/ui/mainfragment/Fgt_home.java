package com.example.lishan.timbo_min.ui.mainfragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.HomeCouponAdapter;
import com.example.lishan.timbo_min.adapter.HomeGridAdapter;
import com.example.lishan.timbo_min.adapter.HomeListAdapter;
import com.example.lishan.timbo_min.bean.HomGrdBean;
import com.example.lishan.timbo_min.bean.HomeCouponBean;
import com.example.lishan.timbo_min.bean.HomeListBean;
import com.example.lishan.timbo_min.common.BaseFgt;
import com.example.lishan.timbo_min.tool.GlideImageLoader;
import com.example.lishan.timbo_min.ui.MyWebView;
import com.example.lishan.timbo_min.ui.home.Act_HealthPage;
import com.example.lishan.timbo_min.ui.home.arena.Act_Arena;
import com.example.lishan.timbo_min.ui.home.basningskills.Act_BasningSkills;
import com.example.lishan.timbo_min.ui.home.competencedducation.Act_CompetencEdducation;
import com.example.lishan.timbo_min.ui.home.latestactivities.Act_LatestActivities;
import com.example.lishan.timbo_min.ui.home.motion.Act_MyMovem;
import com.example.lishan.timbo_min.ui.home.growth.Act_MyGrowth;
import com.example.lishan.timbo_min.ui.home.myclass.Act_MyClass;
import com.example.lishan.timbo_min.ui.home.traininginstitutions.Act_TrainingInstitutionsHome;
import com.example.lishan.timbo_min.view.FullyLinearLayoutManager;
import com.example.lishan.timbo_min.view.MyGridView;
import com.example.lishan.timbo_min.view.ObserveScrollView;
import com.lykj.aextreme.afinal.utils.Debug;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishan on 2017/12/10.
 */

public class Fgt_home extends BaseFgt implements HomeGridAdapter.backItem {
    RecyclerView myGridView;
    private RecyclerView myRecyclerView, myRecyclerView1, youhuijuan, chenzhang;
    private Banner myBanner;
    //    private int images[] = {R.mipmap.icon_g1, R.mipmap.icon_g2, R.mipmap.icon_g3, R.mipmap.icon_g4, R.mipmap.icon_g5,
//            R.mipmap.icon_g6, R.mipmap.icon_g7, R.mipmap.icon_g8, R.mipmap.icon_g9, R.mipmap.icon_g10};
//    private String name[] = {"我要运动", "PK竞技场", "我的成长", "我的班级", "积分商城"
//            , "素质课堂", "培训机构", "晒 技 能", "最新活动", "健康知识"};
    private int images[] = {R.mipmap.icon_h1, R.mipmap.icon_h2, R.mipmap.icon_h3, R.mipmap.icon_h4, R.mipmap.icon_h5, R.mipmap.icon_h6,
            R.mipmap.icon_h7, R.mipmap.icon_h8, R.mipmap.icon_h9, R.mipmap.icon_h10, R.mipmap.icon_h11, R.mipmap.icon_h12, R.mipmap.icon_h3};
    private String name[] = {"成长咨询", "亲子活动", "我的班级", "成长轨迹", "我要运动", "素质课堂", "培训机构", "晒技能",
            "PK竞技", "投票", "备忘录", "积分商场", "优惠卷"};

    private LinearLayout showLinear, title1;
    private com.example.lishan.timbo_min.view.ObserveScrollView homeScrollview;

    @Override
    public void sendMsg(int flag, Object obj) {

    }

    @Override
    public int initLayoutId() {
        return R.layout.fgt_home;
    }

    @Override
    public void initView() {
        hideHeader();
        myBanner = getView(R.id.banner);
        myGridView = getView(R.id.home_gridivew);
        myRecyclerView = getView(R.id.id_Recyclerview);
        myRecyclerView1 = getView(R.id.home_gridivew1);
        showLinear = getView(R.id.home_title);
        title1 = getView(R.id.home_title1);//搜索页面
        homeScrollview = getView(R.id.home_scrollview);
        youhuijuan = getView(R.id.home_youhuijuan);//优惠卷
        chenzhang = getView(R.id.home_chenzhang);//成长咨询
    }

    @Override
    public void initData() {
        //本地图片数据（资源文件）
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.b1);
        list.add(R.mipmap.b2);
        list.add(R.mipmap.b3);
        myBanner.setImages(list)
                .setImageLoader(new GlideImageLoader())
                .start();

        //导航
        List<HomGrdBean> gridData = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            HomGrdBean bena = new HomGrdBean();
            bena.setImages(images[i]);
            bena.setName(name[i]);
            gridData.add(bena);
        }
        HomeGridAdapter gridAdapter = new HomeGridAdapter(gridData, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        myGridView.setLayoutManager(linearLayoutManager);
        myGridView.setAdapter(gridAdapter);


        //亲子活动
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(context);
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        myRecyclerView1.setLayoutManager(linearLayoutManager1);
        myRecyclerView1.setAdapter(gridAdapter);
        FullyLinearLayoutManager manager = new FullyLinearLayoutManager(context);
        myRecyclerView.setLayoutManager(manager);
        HomeListAdapter myreist = new HomeListAdapter();
        List<HomeListBean> datas = new ArrayList<>();
        for (int f = 0; f < 10; f++) {
            HomeListBean bean = new HomeListBean();
            if (f == 1 || f == 4 || f == 7) {
                bean.setState("1");
            } else if (f == 2 || f == 4 || f == 6) {
                bean.setState("2");
            } else {
                bean.setState("3");
            }
            datas.add(bean);
        }
        myreist.setContext(context);
        myreist.setDatas(datas);
        myRecyclerView.setNestedScrollingEnabled(false);
        myRecyclerView.setAdapter(myreist);


        /**
         * 显示搜索TITLE问题
         */
        homeScrollview.setScrollListener(new ObserveScrollView.ScrollListener() {
            @Override
            public void scrollOritention(int l, int t, int oldl, int oldt) {
                //滑动数据已经接收，在这里实现你的功能
                if (oldt >= 553) {
                    showLinear.setVisibility(View.VISIBLE);
                    title1.setVisibility(View.GONE);
                } else {
                    showLinear.setVisibility(View.GONE);
                    title1.setVisibility(View.VISIBLE);
                }
            }
        });
        /**
         * 成长咨询
         */
        LinearLayoutManager chenzhangmanager = new LinearLayoutManager(context);
        chenzhangmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
        chenzhang.setLayoutManager(chenzhangmanager);
        chenzhang.setAdapter(gridAdapter);
        FullyLinearLayoutManager manager1 = new FullyLinearLayoutManager(context);
        chenzhang.setLayoutManager(manager1);
        HomeListAdapter myreist1 = new HomeListAdapter();
        List<HomeListBean> datas1 = new ArrayList<>();
        for (int f = 0; f < 10; f++) {
            HomeListBean bean = new HomeListBean();
            if (f == 1 || f == 4 || f == 7) {
                bean.setState("1");
            } else if (f == 2 || f == 4 || f == 6) {
                bean.setState("2");
            } else {
                bean.setState("3");
            }
            datas1.add(bean);
        }
        myreist1.setContext(context);
        myreist1.setDatas(datas1);
        chenzhang.setNestedScrollingEnabled(false);
        chenzhang.setAdapter(myreist1);


        /**
         * 优惠卷
         */
        FullyLinearLayoutManager manager2 = new FullyLinearLayoutManager(context);
        youhuijuan.setLayoutManager(manager2);
        List<HomeCouponBean> coupondata = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            HomeCouponBean bean1 = new HomeCouponBean();
            bean1.setImages(i);
            coupondata.add(bean1);
        }
        HomeCouponAdapter adapter = new HomeCouponAdapter(coupondata);
        adapter.setmContext(getContext());
        youhuijuan.setAdapter(adapter);


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
    public void OnBackItem(int position) {
        Intent intent = new Intent();
        switch (position) {
            case 0://成长咨询
                intent.putExtra("indext", 7);
                startAct(intent, MyWebView.class);
                break;
            case 1://亲子活动
                intent.putExtra("indext", 8);
                startAct(intent, MyWebView.class);
                break;
            case 2://我的班级
//                startAct(Act_MyClass.class);
                intent.putExtra("indext", 9);
                startAct(intent, MyWebView.class);
                break;
            case 3://成长轨迹
                intent.putExtra("indext", 10);
                startAct(intent, MyWebView.class);
                break;
            case 4://我要运动
                startAct(Act_MyMovem.class);
//                intent.putExtra("index、t", 11);
//                startAct(intent, MyWebView.class);
                break;
            case 5://素质课堂
                startAct(Act_CompetencEdducation.class);
//                intent.putExtra("indext", 12);
//                startAct(intent, MyWebView.class);
                break;
            case 6://培训机构
//                startAct(Act_TrainingInstitutionsHome.class);
                intent.putExtra("indext", 13);
                startAct(intent, MyWebView.class);
                break;
            case 7://晒技能
//                startAct(Act_BasningSkills.class);
                intent.putExtra("indext", 14);
                startAct(intent, MyWebView.class);
                break;
            case 8://PK竞技
                startAct(Act_Arena.class);
//                intent.putExtra("indext", 15);
//                startAct(intent, MyWebView.class);
                break;
            case 9://投票
                intent.putExtra("indext", 16);
                startAct(intent, MyWebView.class);
                break;
            case 10://备忘录
                intent.putExtra("indext", 17);
                startAct(intent, MyWebView.class);
                break;
            case 11://积分商场
                intent.putExtra("indext", 18);
                startAct(intent, MyWebView.class);
                break;
            case 12://优惠卷
                intent.putExtra("indext", 19);
                startAct(intent, MyWebView.class);
                break;
        }
    }
//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        switch (i) {
//            case 2://我的成长
//                startAct(Act_MyGrowth.class);
//                break;
//            case 8://最新活动
//                startAct(Act_LatestActivities.class);
//                break;
//            case 9:
//                startAct(Act_HealthPage.class);
//                break;
//        }
//    }
}
