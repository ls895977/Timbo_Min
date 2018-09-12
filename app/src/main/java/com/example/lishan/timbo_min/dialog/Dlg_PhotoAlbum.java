package com.example.lishan.timbo_min.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.example.lishan.timbo_min.R;
import com.lykj.aextreme.afinal.common.BaseDialog;

/**
 * Created by lishan on 2017/12/22.
 */

public class Dlg_PhotoAlbum extends BaseDialog {
    OnClick onClick;

    public Dlg_PhotoAlbum(Context context, OnClick click) {
        super(context);
        this.onClick = click;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dlg_photoalbum;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM);
    }

    @Override
    protected void initView() {
        setOnClickListener(R.id.phontalbum_cancel);
        setOnClickListener(R.id.photoalbum_carme);
        setOnClickListener(R.id.photoalbum_photo);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.phontalbum_cancel:
                dismiss();
                break;
            case R.id.photoalbum_carme://相机
                onClick.carmer();
                break;
            case R.id.photoalbum_photo://相册
                onClick.phonto();
                break;
        }
    }

    public interface OnClick {
        void carmer();

        void phonto();
    }
}
