package com.example.lishan.timbo_min.dialog;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.Dlg_RegisterChoseAdapter;
import com.example.lishan.timbo_min.bean.CodeBean;
import com.example.lishan.timbo_min.bean.Dlg_RegisterChoseBean;
import com.example.lishan.timbo_min.bean.Dlg_RegisterNoChoseBean;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.common.BaseDialog;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

/**
 * 创建学校
 * Created by lishan on 2018/4/14.
 */
public class Dlg_RegisterNoChose extends BaseDialog {
    private EditText SchoolName, nianji, banji;
    private onSchoolBack onSchoolBack;

    public Dlg_RegisterNoChose(Context context, onSchoolBack onSchoolBack1) {
        super(context);
        this.onSchoolBack = onSchoolBack1;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.dlg_registernochose;
    }

    @Override
    protected void initWindow() {
        windowDeploy(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM);
    }

    @Override
    protected void initView() {
        SchoolName = getView(R.id.registernochose_SchoolName);
        nianji = getView(R.id.registernochose_nianji);
        banji = getView(R.id.registernochose_banji);
        setOnClickListener(R.id.register_new);
        setOnClickListener(R.id.register_shutdown);
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.register_new://创建
                PostBackCode();
                break;
            case R.id.register_shutdown:
                dismiss();
                break;
        }
    }

    /**
     * 创建学校
     */
    Dlg_RegisterNoChoseBean NoChoseBean;
    public void PostBackCode() {
        if (TextUtils.isEmpty(SchoolName.getText().toString())) {
            MyToast.show(getContext(), "请输学校名称！");
            return;
        }
        if (TextUtils.isEmpty(nianji.getText().toString())) {
            MyToast.show(getContext(), "请输入年纪！");
            return;
        }
        if (TextUtils.isEmpty(banji.getText().toString())) {
            MyToast.show(getContext(), "请输入年纪！");
            return;
        }
        HttpReqest httpReqest = new HttpReqest();
        HashMap hashMap = new HashMap();
        hashMap.put("school_name", SchoolName.getText().toString());
        httpReqest.HttpPost("i=1&c=entry&do=add_school&m=ted_users", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gosn = new Gson();
                NoChoseBean = gosn.fromJson(response.body(), Dlg_RegisterNoChoseBean.class);
                if (NoChoseBean.getError_code().equals("200")) {
                    onSchoolBack.onBackSchoolId(NoChoseBean.getData().getSchool_id(), NoChoseBean.getData().getSchool_name(),
                            nianji.getText().toString(), banji.getText().toString()
                    );
                }
                MyToast.show(getContext(), "创建成功！");
                dismiss();
            }

            @Override
            public void onError(Response<String> response) {
            }
        });
    }

    public interface onSchoolBack {
        void onBackSchoolId(int school_id, String school_name, String nianji, String banji);
    }
}
