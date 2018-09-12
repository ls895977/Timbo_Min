package com.example.lishan.timbo_min.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lishan.timbo_min.MainActivity;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.callback.PageHelperListener;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.tool.NormalIndicator;
import com.example.lishan.timbo_min.view.GlideViewPager;
import com.example.lishan.timbo_min.view.PageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishan on 2017/12/8.
 */

public class Act_WelcomePage extends BaseAct {
    private LayoutInflater inflate;
    @Override
    public int initLayoutId() {
        return R.layout.act_welcomepager;
    }

    @Override
    public void initView() {
        hideHeader();


    }
    private static final int[] RES = {R.mipmap.banner_1,R.mipmap.banner_2,R.mipmap.banner_3};
    private int indext;

    @TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
    @Override
    public void initData() {
        GlideViewPager viewPager = (GlideViewPager) findViewById(R.id.splase_viewpager);
        NormalIndicator linearLayout = (NormalIndicator) findViewById(R.id.splase_bottom_layout);
        Button button = (Button) findViewById(R.id.splase_start_btn);


        //先把本地的图片 id 装进 list 容器中
        List<Integer> images = new ArrayList<>();
        for (int i = 0; i < RES.length; i++) {
            images.add(RES[i]);

        }
        //配置pagerbean，这里主要是为了viewpager的指示器的作用，注意记得写上泛型
        PageBean bean = new PageBean.Builder<Integer>()
                .setDataObjects(images)
                .setIndicator(linearLayout)
                .setOpenView(button)
                .builder();

        // 把数据添加到 viewpager中，并把view提供出来，这样除了方便调试，也不会出现一个view，多个
        // parent的问题，这里在轮播图比较明显
        viewPager.setPageListener(bean, R.layout.image_layout, new PageHelperListener() {
            @Override
            public void getItemView(View view, Object data) {
                ImageView imageView = getView(view,R.id.icon);
                imageView.setImageResource((Integer) data);
            }
        });


        //点击实现跳转功能
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Act_WelcomePage.this,MainActivity.class));
                finish();
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

    }

}
