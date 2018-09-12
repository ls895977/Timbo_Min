package com.example.lishan.timbo_min.dialog;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.Dlg_RegisterChoseAdapter;
import com.example.lishan.timbo_min.bean.AddClassBean;
import com.example.lishan.timbo_min.bean.CodeBean;
import com.example.lishan.timbo_min.bean.Dlg_RegisterChoseBean;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.common.BaseDialog;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

/**
 * 我的班级
 * Created by lishan on 2018/4/14.
 */
public class Dlg_RegisterClass extends BaseDialog implements TextWatcher {

    private TextView register_query, register_add, jiaru, xuexiao, btregister_new;
    private String addr;
    String stnianji, stbanji, stschool_id;
    private OnClassBack onClassBack;
    private EditText nianji, banji;

    public Dlg_RegisterClass(Context context) {
        super(context);
    }

    public void setData(String addr1, String nianji, String banji, String school_id, OnClassBack onClassBack1) {
        addr = addr1;
        stnianji = nianji;
        stbanji = banji;
        stschool_id = school_id;
        onClassBack = onClassBack1;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dlg_registerclass;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM);
    }

    @Override
    protected void initView() {
        register_query = getViewAndClick(R.id.register_query);
        register_add = getViewAndClick(R.id.register_add);
        jiaru = getView(R.id.registertv);
        jiaru.setVisibility(View.GONE);
        xuexiao = getView(R.id.xuexiao);
        nianji = getView(R.id.registerclass_nianji);
        banji = getView(R.id.registerclass_banji);
        register_query.setSelected(true);
        btregister_new = getViewAndClick(R.id.btregister_new);
        nianji.addTextChangedListener(this);
        banji.addTextChangedListener(this);
        setOnClickListener(R.id.register_shutdown);
    }

    @Override
    protected void initData() {
        btregister_new.setVisibility(View.GONE);
//        if (stnianji == "" && stbanji == "") {
//            stnianji = "1";
//            stbanji = "1";
//        }
        xuexiao.setText(addr);
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.register_new:
                dismiss();
                break;
            case R.id.register_query://查询班级
                PostClass();
                break;
            case R.id.register_add://添加班级
                onClassBack.onBackData(nianji.getText().toString(), banji.getText().toString());
                break;
            case R.id.btregister_new://创建班级
                PostBan();
                break;
            case R.id.register_shutdown://关闭
                onClassBack.onShutDown();
                break;
        }
    }

    /**
     * 查询班级
     */
    public void PostClass() {
        HttpReqest httpReqest = new HttpReqest();
        HashMap hashMap = new HashMap();
        hashMap.put("grade_name", nianji.getText().toString());
        Debug.e("查询班级---grade_name--" +  nianji.getText().toString());
        hashMap.put("class_name", banji.getText().toString());
        Debug.e("查询班级---class_name--" + banji.getText().toString());
        hashMap.put("school_id", stschool_id);
        Debug.e("查询班级---school_id--" + stschool_id);
        httpReqest.HttpPost("i=1&c=entry&do=search_class&m=ted_users", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e("-----------" + response.body());
                if (response.body().contains("400") || response.body().contains("204")) {
                    btregister_new.setVisibility(View.VISIBLE);
                    btregister_new.setSelected(true);
                    register_query.setSelected(false);
                    register_query.setOnClickListener(null);
                    register_add.setVisibility(View.GONE);
                } else {
                    btregister_new.setVisibility(View.GONE);
                    btregister_new.setSelected(false);
                    register_add.setVisibility(View.VISIBLE);
                    register_query.setSelected(false);
                    register_query.setOnClickListener(null);
                    register_add.setSelected(true);
                }
            }

            @Override
            public void onError(Response<String> response) {

            }
        });
    }

    /**
     * 创建班级
     */
    public void PostBan() {
        HttpReqest httpReqest = new HttpReqest();
        HashMap hashMap = new HashMap();
        hashMap.put("grade_name", nianji.getText().toString());
        Debug.e("年纪========"+nianji.getText().toString());
        hashMap.put("class_name", banji.getText().toString());
        Debug.e("班级========"+banji.getText().toString());
        hashMap.put("school_id", stschool_id);
        httpReqest.HttpPost("i=1&c=entry&do=add_class&m=ted_users", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e("-------创建班级----" + response.body());
                if (response.body().contains("200")) {
                    AddClassBean bean;
                    Gson gson = new Gson();
                    bean = gson.fromJson(response.body(), AddClassBean.class);
                    ACache aCache = ACache.get(getContext());
                    aCache.put("class_id", bean.getData().getClass_id());
                    aCache.put("school_id", bean.getData().getSchool_id());
                    aCache.put("grade_name", bean.getData().getGrade_name());
                    aCache.put("class_name", bean.getData().getClass_name());
                    onClassBack.onBackData(nianji.getText().toString(), banji.getText().toString());
                }
                dismiss();
            }

            @Override
            public void onError(Response<String> response) {
                dismiss();
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        register_query.setSelected(true);
        register_query.setOnClickListener(this);
    }

    public interface OnClassBack {
        void onBackData(String nianji, String banji);

        void onShutDown();
    }
}
