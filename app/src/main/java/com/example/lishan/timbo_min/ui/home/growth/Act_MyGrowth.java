package com.example.lishan.timbo_min.ui.home.growth;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TableLayout;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.common.BaseFgt;
import com.example.lishan.timbo_min.ui.home.growth.fragment.Fgt_GrowthActivity;
import com.example.lishan.timbo_min.ui.home.growth.fragment.Fgt_GrowthRecord;
import com.example.lishan.timbo_min.ui.home.growth.fragment.Fgt_MyAlbum;
import com.example.lishan.timbo_min.ui.home.growth.fragment.Fgt_MyEssay;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

/**
 * Created by lishan on 2017/12/25.
 */

public class Act_MyGrowth extends BaseAct implements OnTabSelectListener {
    private final String[] mTitles = {
            "成长记录", " 的随笔", "成长活动"
            , "我的相册",};
    private ArrayList<BaseFgt> mFragments = new ArrayList<>();

    @Override
    public int initLayoutId() {
        return R.layout.act_mygrowth;
    }

    @Override
    public void initView() {
        setTitle(R.string.mygrowth_title);
        setHeaderLeft(R.mipmap.icon_mygrowth_title);

    }

    MyPagerAdapter mAdapter;

    @Override
    public void initData() {
        mFragments.add( new Fgt_GrowthRecord());
        mFragments.add(new Fgt_MyEssay());
        mFragments.add(new Fgt_GrowthActivity());
        mFragments.add(new Fgt_MyAlbum());
        TabLayout tabLayout = getView(R.id.tablayout);
        ViewPager vp = getView(R.id.vp);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(mAdapter);
        tabLayout.addTab(tabLayout.newTab().setText("成长记录"));
        tabLayout.addTab(tabLayout.newTab().setText("我的随笔"));
        tabLayout.addTab(tabLayout.newTab().setText("成长活动"));
        tabLayout.addTab(tabLayout.newTab().setText("我的相册"));
        //第三步：关联ViewPager
        tabLayout.setupWithViewPager(vp);
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
    public void onTabSelect(int position) {

    }

    @Override
    public void onTabReselect(int position) {

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
