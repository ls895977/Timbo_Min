package com.example.lishan.timbo_min.ui.home.growth;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;

/**
 * Created by lishan on 2018/1/7.
 */

public class Act_Picture_Browsing extends BaseAct {
    private EditText myEd;
    private ImageView myWrite;
    private TextView myOvver;

    @Override
    public int initLayoutId() {
        return R.layout.act_picture_browsing;
    }

    @Override
    public void initView() {
        hideHeader();
        myEd = getView(R.id.piture_browsing_et);
        setOnClickListener(R.id.itempictureBrowsingMessage);
        myWrite = getViewAndClick(R.id.picture_write);
        myOvver = getViewAndClick(R.id.picture_ovver);


        myEd.setFocusable(false);
        myEd.setFocusableInTouchMode(false);

    }

    @Override
    public void initData() {

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
            case R.id.itempictureBrowsingMessage:
                startAct(Act_Comment_Details.class);
                break;
            case R.id.picture_write://写图标
                myWrite.setVisibility(View.GONE);
                myEd.setFocusable(true);
                myOvver.setVisibility(View.VISIBLE);
                myEd.setFocusableInTouchMode(true);
                myEd.setFocusable(true);
                myEd.setPressed(true);
                myEd.requestFocus();
                break;
            case R.id.picture_ovver://完成
                myWrite.setVisibility(View.VISIBLE);
                myEd.setFocusable(false);
                myOvver.setVisibility(View.GONE);
                myEd.setFocusable(false);
                myEd.setPressed(false);
                myEd.setFocusableInTouchMode(false);
                break;

        }
    }
}
