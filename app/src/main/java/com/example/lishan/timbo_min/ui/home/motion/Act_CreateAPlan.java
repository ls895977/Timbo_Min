package com.example.lishan.timbo_min.ui.home.motion;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.CreateaplaListAdapter;
import com.example.lishan.timbo_min.bean.CreateAplanDeltingPlanBean;
import com.example.lishan.timbo_min.bean.CreateaplaBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.common.MyTooL;
import com.example.lishan.timbo_min.dialog.Dlg_CreateAPlan;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.example.lishan.timbo_min.view.FullyLinearLayoutManager;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lishan on 2018/1/11.
 */

public class Act_CreateAPlan extends BaseAct implements CreateaplaListAdapter.BackButtonClick, Dlg_CreateAPlan.OnClick1 {
    private RecyclerView myRecyclerView;
    private List<CreateaplaBean.PlansBean> datas;
    private Dlg_CreateAPlan dlg;
    private SVProgressHUD mSVProgressHUD;

    @Override
    public int initLayoutId() {
        return R.layout.act_createaplan;
    }

    @Override
    public void initView() {
        hideHeader();
        myRecyclerView = getView(R.id.myCreateaplan_RecyclerVIew);
        setOnClickListener(R.id.mycreateaplanback);
    }

    private CreateaplaListAdapter adapter;

    @Override
    public void initData() {
        mSVProgressHUD = new SVProgressHUD(context);
        BackCreateAPlantData();
        dlg = new Dlg_CreateAPlan(this, this);
        datas = new ArrayList<>();
        FullyLinearLayoutManager manager = new FullyLinearLayoutManager(Act_CreateAPlan.this);
        myRecyclerView.setLayoutManager(manager);
        dlg.setCanceledOnTouchOutside(false);
        dlg.setCancelable(false);
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
            case R.id.mycreateaplanback:
                finish();
                break;
        }
    }

    /**
     * 删除
     *
     * @param position
     */
    @Override
    public void OnShutdow(int position) {
        Deleting_Plan(position);
    }

    /**
     * 修改
     *
     * @param position
     */
    boolean xiugai = false;
    int xiugaiindext = 0;

    @Override
    public void Onshezhi(int position) {
        xiugai = true;
        xiugaiindext = position;
        dlg.show();
        dlg.SetData(datas.get(position).getName(), datas.get(position).getWeight(), datas.get(position).getUse_time());
    }

    @Override
    public void Ondaka() {
        dlg.show();
    }

    /**
     * 选中的状态
     *
     * @param position
     */
    @Override
    public void OnChebox(int position) {
        for (int i = 0; i < datas.size(); i++) {
            datas.get(i).setQiyong(false);
        }
        datas.get(position).setQiyong(true);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void BakcOn(String name, String gongjin, String gongli, String daka,String time) {
        if (xiugai == false) {
            PostCreateAPlantData(name, gongjin, gongli, daka);
        } else {//修改
            Revision_Plan(xiugaiindext,gongjin,name,gongli,daka,time);
        }

    }

    /**
     * 获取当前列表数据
     */
    public void BackCreateAPlantData() {
        showLoading();
        ACache aCache = ACache.get(this);
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body = new HashMap<>();
        body.put("op", "getAllPlanByUid");
        body.put("uid", aCache.getAsString("id"));
        httpReqest.HttpPost("i=1&c=entry&do=enterPoint&m=b_isport", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Gson gson = new Gson();
                Debug.e("---数据获取--" + response.body());
                CreateaplaBean bean0 = gson.fromJson(response.body(), CreateaplaBean.class);
                if (bean0.getPlans() != null || bean0.getPlans().size() > 0) {
                    datas.clear();
                    Debug.e("-----------------"+ bean0.getPlans().size());
                    for (int i = 0; i < bean0.getPlans().size(); i++) {
                        CreateaplaBean.PlansBean planBean = new CreateaplaBean.PlansBean();
                        planBean.setAge(bean0.getPlans().get(i).getAge());
                        planBean.setCreatetime(bean0.getPlans().get(i).getCreatetime());
                        planBean.setHeight(bean0.getPlans().get(i).getHeight());
                        planBean.setId(bean0.getPlans().get(i).getId());
                        planBean.setName(bean0.getPlans().get(i).getName());
                        planBean.setPlanCalory(bean0.getPlans().get(i).getPlanCalory());
                        planBean.setPlanDistancePerDay(bean0.getPlans().get(i).getPlanDistancePerDay());
                        planBean.setSex(bean0.getPlans().get(i).getSex());
                        planBean.setQiyong(bean0.getPlans().get(i).isQiyong());
                        planBean.setStatus(bean0.getPlans().get(i).getStatus());
                        planBean.setUserID(bean0.getPlans().get(i).getUserID());
                        planBean.setTotalDone(bean0.getPlans().get(i).getTotalDone());
                        planBean.setWeight(bean0.getPlans().get(i).getWeight());
                        datas.add(planBean);
                    }
                    CreateaplaBean.PlansBean planBean = new CreateaplaBean.PlansBean();
                    datas.add(planBean);
                } else {
                    datas.clear();
                    CreateaplaBean.PlansBean bean = new CreateaplaBean.PlansBean();
                    datas.add(bean);
                }
                if (adapter == null) {
                    adapter = new CreateaplaListAdapter(Act_CreateAPlan.this);
                    adapter.setDatas(datas);
                    myRecyclerView.setAdapter(adapter);
                } else {
                    adapter.setDatas(datas);
                    adapter.notifyDataSetChanged();
                }
                adapter.setContext(Act_CreateAPlan.this);
                showCView();
            }

            @Override
            public void onError(Response<String> response) {
                showCView();
            }
        });
    }

    /**
     * 创建计划
     *
     * @param name
     * @param gongjin
     * @param gongli
     * @param daka
     */
    public void PostCreateAPlantData(final String name, String gongjin, String gongli, String daka) {
        mSVProgressHUD.showWithStatus("数据创建中...");
        ACache aCache = ACache.get(this);
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body = new HashMap<>();
        body.put("op", "createPlan");
        body.put("uid", aCache.getAsString("id"));
        body.put("weight", gongjin);//体重
        body.put("age", "18");//年龄
        body.put("height", "");//用户的身高
        body.put("name", name);// 计划名称
        body.put("sex", "男");// 用户性别
        body.put("planDistancePerDay", gongli);// 计划的每日完成公里数
        body.put("planCalory", daka);//  预计每天消耗的卡路里数
        httpReqest.HttpPost("i=1&c=entry&do=enterPoint&m=b_isport&", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e("---提交数据--" + response.body());
                Gson gosn = new Gson();
                CreateAplanDeltingPlanBean bean = gosn.fromJson(response.body(), CreateAplanDeltingPlanBean.class);
                if (bean.getError_code() == 200) {
                    BackCreateAPlantData();
                } else {
                    MyToast.show(context, bean.getError_message());
                }
                mSVProgressHUD.dismiss();
            }

            @Override
            public void onError(Response<String> response) {
                MyToast.show(getApplicationContext(), "提交失败！");
                mSVProgressHUD.dismiss();
            }
        });
    }

    /**
     * 删除计划
     */
    public void Deleting_Plan(final int position) {
        mSVProgressHUD.showWithStatus("计划删除中...");
        ACache aCache = ACache.get(this);
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body1 = new HashMap<>();
        body1.put("op","deletePlan");
        Debug.e("---uid------"+aCache.getAsString("id"));
        body1.put("uid", datas.get(position).getUserID());
        body1.put("planId", datas.get(position).getId());
        Debug.e("---planId------"+ datas.get(position).getId());
        httpReqest.HttpPost("i=1&c=entry&do=enterPoint&m=b_isport&", body1, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e("---删除--" + response.body());
                Gson gosn = new Gson();
                CreateAplanDeltingPlanBean bean = gosn.fromJson(response.body(), CreateAplanDeltingPlanBean.class);
                if (bean.getError_code() == 400) {
                    MyToast.show(context, bean.getError_message());
                } else {
                    datas.remove(position);
                    adapter.notifyDataSetChanged();
                }
                mSVProgressHUD.dismiss();

            }

            @Override
            public void onError(Response<String> response) {
                MyToast.show(getApplicationContext(), "提交失败！");
                mSVProgressHUD.dismiss();
            }
        });
    }

    /**
     * 修改计划
     */
    public void Revision_Plan(final int position,String weight,String name,String plandistanceperday,String plancalory,String usettime) {
        mSVProgressHUD.showWithStatus("计划修改中...");
        ACache aCache = ACache.get(this);
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body = new HashMap<>();
        body.put("op", "changeDefaultPlan");
        body.put("uid", datas.get(position).getUserID());
        Debug.e("---uid------" + aCache.getAsString("id"));
        body.put("planId", datas.get(position).getId());
        Debug.e("---planId------" + datas.get(position).getId());
        body.put("weight ",weight);//重量
        Debug.e("---weight------" +weight);
        body.put("name",name);// 计划名称
        Debug.e("---name------" +name);
        body.put("planDistancePerDay",plandistanceperday);// 计划的每日完成公里数
        Debug.e("---planDistancePerDay------" +plandistanceperday);
        body.put("planCalory", plancalory);// 预计每天消耗的卡路里数
        Debug.e("---planCalory------" +plancalory);
        body.put("usetTime", usettime);// 时长
        Debug.e("---usetTime------" +usettime);
        httpReqest.HttpPost("i=1&c=entry&do=enterPoint&m=b_isport", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                xiugai=false;
                Gson gosn = new Gson();
                CreateAplanDeltingPlanBean bean = gosn.fromJson(response.body(), CreateAplanDeltingPlanBean.class);
                if (bean.getError_code()==400) {
                    MyToast.show(context,bean.getError_message());
                } else {
                    BackCreateAPlantData();
                }
                mSVProgressHUD.dismiss();

            }

            @Override
            public void onError(Response<String> response) {
                MyToast.show(getApplicationContext(), "提交失败！");
                mSVProgressHUD.dismiss();
            }
        });
    }
}
