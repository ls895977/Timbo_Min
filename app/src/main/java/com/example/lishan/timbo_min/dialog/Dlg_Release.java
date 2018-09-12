package com.example.lishan.timbo_min.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.example.lishan.timbo_min.R;
import com.lykj.aextreme.afinal.common.BaseDialog;
import com.lykj.aextreme.afinal.utils.Debug;

/**
 * Created by lishan on 2018/1/28.
 */

public class Dlg_Release extends BaseDialog {
    private OnClick onClick;

    public Dlg_Release(Context context, OnClick onClick1) {
        super(context);
        this.onClick = onClick1;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dlg_release;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM);

    }

    @Override
    protected void initView() {
        setOnClickListener(R.id.myhuodong);
        setOnClickListener(R.id.myjineng);
        setOnClickListener(R.id.mytiwen);
        setOnClickListener(R.id.mychengzhang);
        setOnClickListener(R.id.release);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.myhuodong://发布活动
                onClick.OnBackClick(1);
                break;
            case R.id.myjineng://晒技能
                onClick.OnBackClick(2);
                break;
            case R.id.mytiwen://我要提问
                onClick.OnBackClick(3);
                break;
            case R.id.mychengzhang://成长资讯
                onClick.OnBackClick(4);
                break;
            case R.id.release:
                dismiss();
                break;
        }


    }

    public interface OnClick {
        void OnBackClick(int p);
    }
}
