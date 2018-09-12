package com.example.lishan.timbo_min.ui.mainfragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.EnterpriseAdapter;
import com.example.lishan.timbo_min.bean.EnterpriseBean;
import com.example.lishan.timbo_min.common.BaseFgt;
import com.example.lishan.timbo_min.ui.enterprise.Act_AdvertisingManagement;
import com.example.lishan.timbo_min.ui.enterprise.Act_EnterpriseInformation;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lykj.aextreme.afinal.utils.Debug;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的企业会员中心
 * Created by lishan on 2018/4/1.
 */
public class Fgt_Enterprise extends BaseFgt implements EnterpriseAdapter.BackButtonClick1 {
    private XRecyclerView mXrecyclerView;
    private List<EnterpriseBean> datas = new ArrayList<>();
    private int[] img = {R.mipmap.icon_qiye_hy, R.mipmap.icn_qiye_gg, R.mipmap.icn_qiye_bm, R.mipmap.icn_qiye_cw, R.mipmap.icn_qiye_xx,
            R.mipmap.icn_qiye_dp, R.mipmap.icn_qiye_, R.mipmap.icn_qiye_sa, R.mipmap.icn_qiye_ds, R.mipmap.icn_qiye_mm, R.mipmap.icn_qiye_xt,
            R.mipmap.icn_qiye_tui
    };
    private String[] str = {"会员资料", "广告管理", "报名管理", "财务管理", "消息中心", "店铺管理", "活动管理", "晒 学 员", "素质课堂",
            "密码修改", "系统设置", "退出系统",};

    @Override
    public int initLayoutId() {
        return R.layout.fgt_enterprise;
    }

    @Override
    public void initView() {
        hideHeader();
        mXrecyclerView = getView(R.id.Enterprise_Xrecyclerview);
    }

    @Override
    public void initData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mXrecyclerView.setLayoutManager(layoutManager);
        mXrecyclerView.setLoadingMoreEnabled(false);
        mXrecyclerView.setPullRefreshEnabled(false);
        for (int i = 0; i < img.length; i++) {
            EnterpriseBean bean = new EnterpriseBean();
            bean.setImgs(img[i]);
            bean.setName(str[i]);
            datas.add(bean);
        }
        EnterpriseAdapter adapter = new EnterpriseAdapter(this);
        adapter.setContext(context);
        adapter.setDatas(datas);
        mXrecyclerView.setAdapter(adapter);
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
    public void sendMsg(int flag, Object obj) {

    }

    @Override
    public void backClcik(int indext) {
        switch (indext) {
            case 0://会员资料
                startAct(Act_EnterpriseInformation.class);
                break;
            case 1://广告管理
                startAct(Act_AdvertisingManagement.class);
                break;
            case 2://报名管理

                break;
            case 3://财务管理

                break;
            case 4://消息中心

                break;
            case 5://店铺管理

                break;
            case 6://活动管理

                break;
            case 7://晒学员

                break;
            case 8://素质课堂

                break;
            case 9://密码修改

                break;
            case 10://系统设置

                break;
            case 11://退出系统

                break;
        }
    }
}
