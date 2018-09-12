package com.example.lishan.timbo_min.ui.home.arena;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.bumptech.glide.Glide;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.ArenaDetalListAdapter;
import com.example.lishan.timbo_min.adapter.ArenaListAdapter;
import com.example.lishan.timbo_min.bean.ArenaBean;
import com.example.lishan.timbo_min.bean.ArenaDetalBean;
import com.example.lishan.timbo_min.bean.ZanBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.example.lishan.timbo_min.ui.home.growth.Act_Comment_Details;
import com.example.lishan.timbo_min.view.FullyLinearLayoutManager;
import com.example.lishan.timbo_min.view.MyGridLayoutManager;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lishan on 2018/1/15.
 */

public class Act_ArenaDetailPage extends BaseAct implements ArenaDetalListAdapter.BackButtonClick1 {
    private RecyclerView myRecyclerView;
    private List<ArenaDetalBean.DataBean.PkRecordDataBean> datas;
    private SVProgressHUD svProgressHUD;
    private Gson gson;
    private String type_id;
    private de.hdodenhof.circleimageview.CircleImageView hader;
    private ImageView join_url;
    private TextView name, addr, age, desc;
    private ACache aCache;

    @Override
    public int initLayoutId() {
        return R.layout.act_arenadetailpage;
    }

    @Override
    public void initView() {
        hideHeader();
        aCache = ACache.get(context);
        setOnClickListener(R.id.arenadetailpage_back);
        setOnClickListener(R.id.arenadetailpage_zan);
        setOnClickListener(R.id.arena_pl);
        myRecyclerView = getView(R.id.arenaDetaliRecyclerview);
        hader = getView(R.id.arenadetailpage_hader);
        join_url = getView(R.id.arenadetailpage_join_url);
        name = getView(R.id.arenadetailpage_name);
        addr = getView(R.id.arenadetailpage_addr);
        age = getView(R.id.arenadetailpage_age);
        desc = getView(R.id.arenadetailpage_join_desc);
    }

    @Override
    public void initData() {
        svProgressHUD = new SVProgressHUD(context);
        type_id = getIntent().getStringExtra("type_id");
        gson = new Gson();
        datas = new ArrayList<>();
        FullyLinearLayoutManager myGridLayoutManager = new FullyLinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myGridLayoutManager);
        showLoading();
        postBackData();

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
            case R.id.arenadetailpage_back:
                finish();
                break;
            case R.id.arenadetailpage_zan://赞
                postZan();
                break;
            case R.id.arena_pl:
                Intent intent = new Intent();
                intent.putExtra("type_id", type_id);
                startAct(intent, Act_Comment_Details.class);
                break;
        }
    }

    @Override
    public void backClcik(int indext) {
        Intent intent = new Intent();
        intent.putExtra("type_id", type_id);
        startAct(intent, Act_Comment_Details.class);
    }

    @Override
    public void arenabutton(int indext) {

    }

    private ArenaDetalListAdapter arenaDetalListAdapter = null;

    public void postBackData() {
//        svProgressHUD.showWithStatus("数据请请中.....");
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", type_id);
        httpReqest.HttpPost("i=1&c=entry&do=app&m=pk_arena&op=detail", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e("==========="+response.body());
                showCView();
                ArenaDetalBean bean = gson.fromJson(response.body(), ArenaDetalBean.class);
                if (bean.getError_code() == 200) {
                    datas.clear();
                    for (int i = 0; i < bean.getData().getPk_record_data().size(); i++) {
                        ArenaDetalBean.DataBean.PkRecordDataBean bean1 = bean.getData().getPk_record_data().get(i);
                        datas.add(bean1);
                    }
                    if (arenaDetalListAdapter == null) {
                        arenaDetalListAdapter = new ArenaDetalListAdapter(Act_ArenaDetailPage.this);
                        arenaDetalListAdapter.setContext(Act_ArenaDetailPage.this);
                        arenaDetalListAdapter.setDatas(datas);
                        myRecyclerView.setAdapter(arenaDetalListAdapter);
                    } else {
                        arenaDetalListAdapter.setDatas(datas);
                        arenaDetalListAdapter.notifyDataSetChanged();
                    }
                    svProgressHUD.dismiss();
                    Glide.with(context).load(bean.getData().getPk_lz_data().getUser().getHeadimg()).into(hader);
                    Glide.with(context).load(bean.getData().getPk_lz_data().getJoin_url()).into(join_url);
                    name.setText(bean.getData().getPk_lz_data().getUser().getName());
                    addr.setText(bean.getData().getPk_lz_data().getUser().getAddress());
                    age.setText(bean.getData().getPk_lz_data().getUser().getAge() + "岁 " + bean.getData().getPk_data().getWeid() + "年纪");
                    desc.setText("成绩说明：" + bean.getData().getPk_lz_data().getDesc());
                } else {
                    MyToast.show(context, bean.getError_message());
                }
            }

            @Override
            public void onError(Response<String> response) {
                svProgressHUD.dismiss();
                showCView();
                MyToast.show(context, "数据请求失败!");
            }
        });
    }

    public void postZan() {
//        svProgressHUD.showWithStatus("数据请请中.....");
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", type_id);
        Debug.e("--id-----" + type_id);
        hashMap.put("user_token", aCache.getAsString("User_token"));
        Debug.e("--user_token-----" + aCache.getAsString("User_token"));
        hashMap.put("type", "1");
        httpReqest.HttpPost("i=1&c=entry&do=app&m=pk_arena&op=praise", hashMap, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                ZanBean bean = gson.fromJson(response.body(), ZanBean.class);
                MyToast.show(context, bean.getError_message());
                showCView();
                svProgressHUD.dismiss();
            }

            @Override
            public void onError(Response<String> response) {
                svProgressHUD.dismiss();
                showCView();
                MyToast.show(context, "数据请求失败!");
            }
        });
    }

}
