package com.example.lishan.timbo_min.dialog;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.Dlg_RegisterChoseAdapter;
import com.example.lishan.timbo_min.bean.Dlg_RegisterChoseBean;
import com.lykj.aextreme.afinal.common.BaseDialog;
import com.lykj.aextreme.afinal.utils.Debug;

/**
 * 选择学校
 * Created by lishan on 2018/4/14.
 */
public class Dlg_RegisterChose extends BaseDialog implements Dlg_RegisterChoseAdapter.onBackItem {
    private onBackChose onBackChose;
    private RecyclerView myRecyclerView;
    public Dlg_RegisterChoseBean bean;

    public Dlg_RegisterChoseBean getBean() {
        return bean;
    }

    public void setBean(Dlg_RegisterChoseBean bean, onBackChose onBackChose1) {
        this.bean = bean;
        onBackChose = onBackChose1;
    }

    public Dlg_RegisterChose(Context context) {
        super(context);
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dlg_registerchose;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM);
    }

    @Override
    protected void initView() {
        myRecyclerView = getView(R.id.registerchose_recyclerview);
        setOnClickListener(R.id.register_new);
        setOnClickListener(R.id.register_shutdown);
    }

    @Override
    protected void initData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        //设置布局管理器
        myRecyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        for (int i = 0; i < bean.getData().size(); i++) {
            bean.getData().get(i).setStatus(false);
        }
        Adapter = new Dlg_RegisterChoseAdapter(bean.getData(), this);
        myRecyclerView.setAdapter(Adapter);
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.register_new:
                dismiss();
                onBackChose.onClick();
                break;
            case R.id.register_shutdown:
                 dismiss();
                break;
        }
    }

    private Dlg_RegisterChoseAdapter Adapter;
    private static int indext;

    @Override
    public void onBackType(int position) {
        bean.getData().get(indext).setStatus(false);
        bean.getData().get(position).setStatus(true);
        indext = position;
        Adapter.notifyDataSetChanged();
    }

    @Override
    public void onClickChose(int position) {//选择成功
        onBackChose.onBackItem(position);
        dismiss();
    }

    public interface onBackChose {
        /**
         * 返回选择的内容
         */
        void onBackItem(int position);

        /**
         * 我要创建
         */
        void onClick();
    }

}
