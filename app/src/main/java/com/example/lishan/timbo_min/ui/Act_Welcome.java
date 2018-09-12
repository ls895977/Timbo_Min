package com.example.lishan.timbo_min.ui;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lishan.timbo_min.MainActivity;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;

/**
 * 欢迎页
 * Created by lishan on 2018/1/28.
 */

public class Act_Welcome extends BaseAct implements View.OnTouchListener {
    ACache aCache;
    private ViewPager myViewPager;

    @Override
    public int initLayoutId() {
        return R.layout.act_welcome;
    }

    @Override
    public void initView() {
        hideHeader();
        aCache = ACache.get(this);
        aCache.put("huanyin", "1");
        myViewPager = getView(R.id.viewpager);
    }

    private int sss;

    @Override
    public void initData() {

        MyAdapter adapter = new MyAdapter();
        myViewPager.setOnTouchListener(this);
        myViewPager.setAdapter(adapter);
        myViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Debug.e("----" + position);
                sss = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //手指按下的点为(x1, y1)手指离开屏幕的点为(x2, y2)
    float x1 = 0;
    float x2 = 0;
    float y1 = 0;
    float y2 = 0;

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//    }

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
    public boolean onTouch(View view, MotionEvent event) {
        //继承了Activity的onTouchEvent方法，直接监听点击事件
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //当手指按下的时候
            x1 = event.getX();
            y1 = event.getY();
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            //当手指离开的时候
            x2 = event.getX();
            y2 = event.getY();
            if (x1 - x2 > 50 && sss == 2) {
                startActClear(Act_Login.class);
            }
        }
        return super.onTouchEvent(event);
    }

    /**
     * 自定义类实现PagerAdapter，填充显示数据
     */
    class MyAdapter extends PagerAdapter {

        // 显示多少个页面
        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        // 初始化显示的条目对象
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = LayoutInflater.from(Act_Welcome.this).inflate(R.layout.item_welcome, null);
            ImageView iv = (ImageView) view.findViewById(R.id.welcome_iv);
            switch (position) {
                case 0:
                    iv.setImageResource(R.mipmap.icon_w1);
                    break;
                case 1:
                    iv.setImageResource(R.mipmap.icon_w2);
                    break;
                case 2:
                    iv.setImageResource(R.mipmap.icon_w3);
                    break;
            }
            container.addView(view);
            return view;
        }

        // 销毁条目对象
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }
}
