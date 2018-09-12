package com.example.lishan.timbo_min.ui.home.arena;

import android.view.View;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.adapter.ArenaListAdapter;
import com.example.lishan.timbo_min.bean.ArenaBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.example.lishan.timbo_min.view.MyGridLayoutManager;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

/**
 * Created by lishan on 2018/1/14.
 */

public class Act_MyEssay extends BaseAct {
    private de.hdodenhof.circleimageview.CircleImageView hader;
    private SVProgressHUD svProgressHUD;
    private ACache aCache;
    private String type_id;
    @Override
    public int initLayoutId() {
        return R.layout.act_myessay;
    }

    @Override
    public void initView() {
        hideHeader();
        setOnClickListener(R.id.myessay_back);
        hader = getView(R.id.myEssay_hader);
    }

    @Override
    public void initData() {
        aCache = ACache.get(context);
        svProgressHUD = new SVProgressHUD(context);
        type_id=getIntent().getStringExtra("type_id");
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
            case R.id.myessay_back:
                finish();
                break;
        }
    }

    public void postLeiTai() {
//        svProgressHUD.showWithStatus("数据请请中.....");
//        HttpReqest httpReqest = new HttpReqest();
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("user_token", aCache.getAsString("User_token"));
//        hashMap.put("type_id", is_new);
//        hashMap.put("join_url", is_hot);
//        hashMap.put("desc", is_hot);
//        httpReqest.HttpGet("i=1&c=entry&do=app&m=pk_arena&op=add_leitai", hashMap, new BackString() {
//            @Override
//            public void onSuccess(Response<String> response) {
//                Debug.e("------------------" + response.body());
//                svProgressHUD.dismiss();
//            }
//
//            @Override
//            public void onError(Response<String> response) {
//                svProgressHUD.dismiss();
//                MyToast.show(context, "数据请求失败!");
//            }
//        });

    }
}
