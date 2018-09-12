package com.example.lishan.timbo_min.dialog;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.MyTooL;
import com.lykj.aextreme.afinal.common.BaseDialog;
import com.lykj.aextreme.afinal.utils.Debug;

import java.text.DecimalFormat;

/**
 * Created by lishan on 2017/12/22.
 */

public class Dlg_CreateAPlan extends BaseDialog {
    public OnClick1 onClick;
    private TextView tv_daka;
    private EditText project, time, gongjin, gongli, name;
    private TextView[] tv = new TextView[3];
    private double k;
    public  void SetData(String name1,String gongjin1,String time1){
            name.setText(name1);
            gongjin.setText(gongjin1);
            time.setText(time1);
    }
    public Dlg_CreateAPlan(Context context, OnClick1 click) {
        super(context);
        this.onClick = click;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dlg_createaplan;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM);
    }

    @Override
    protected void initView() {
        project = getView(R.id.dlgCre_project);
        gongjin = getView(R.id.dlgCre_gongjin);
        gongli = getView(R.id.dlgCre_gongli);
        name = getView(R.id.dlgCre_project);
        time = getView(R.id.dlgCre_time);
        tv_daka = getView(R.id.createaplan_data);
        setOnClickListener(R.id.dlgCre_click1s);
        tv[0] = getViewAndClick(R.id.tv_b1);
        tv[1] = getViewAndClick(R.id.tv_b2);
        tv[2] = getViewAndClick(R.id.tv_b3);
    }

    @Override
    protected void initData() {
        k = 0.1355;
        swche(0);
        gongjin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                showDaka();
            }
        });
        time.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                showDaka();
            }
        });
    }

    private double daka;

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.dlgCre_click1s:
                onClick.BakcOn(name.getText().toString(), gongli.getText().toString(), gongjin.getText().toString(), String.valueOf(daka),time.getText().toString());
                dismiss();
                break;
            case R.id.tv_b1:
                k = 0.1355;
                swche(0);
                break;
            case R.id.tv_b2:
                k = 0.1797;
                swche(1);
                break;
            case R.id.tv_b3:
                k = 0.1875;
                swche(2);
                break;
        }
    }

    public interface OnClick1 {
        void BakcOn(String name, String gongjin, String gongli, String daka,String time);
    }

    int posion = 0;

    public void swche(int indext) {
        tv[posion].setSelected(false);
        tv[indext].setSelected(true);
        posion = indext;
        showDaka();
    }

    public void showDaka() {
        if (TextUtils.isEmpty(gongjin.getText().toString())) {
            return;
        }
        if (TextUtils.isEmpty(time.getText().toString())) {
            return;
        }
        daka = Double.valueOf(gongjin.getText().toString()) * Double.valueOf(time.getText().toString()) * k;
        tv_daka.setText(new DecimalFormat("0.00").format(daka));
    }
}
