package com.example.lishan.timbo_min.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.example.lishan.timbo_min.MainActivity;
import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.bean.GroupSdkBean;
import com.example.lishan.timbo_min.common.BaseAct;
import com.example.lishan.timbo_min.common.MyTooL;
import com.example.lishan.timbo_min.common.UpdateManage;
import com.example.lishan.timbo_min.httppost.BackString;
import com.example.lishan.timbo_min.httppost.HttpReqest;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lzy.okgo.model.Response;

import java.util.HashMap;

/**
 * 启动页
 * Created by lishan on 2018/1/28.
 */

public class Act_Loding extends BaseAct {
    Handler handler1 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (aCache.getAsString("huanyin") == null) {
                startAct(Act_Welcome.class);
            } else {
                startActClear(Act_Login.class);
            }
        }
    };

    @Override
    public int initLayoutId() {
        return R.layout.act_loding;
    }

   public ACache aCache;

    @Override
    public void initView() {
        hideHeader();
        PostGroupSdk();
        aCache = ACache.get(this);
    }

    @Override
    public void initData() {

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

    public GroupSdkBean sdkBean;
    public void PostGroupSdk() {
        HttpReqest httpReqest = new HttpReqest();
        HashMap<String, String> body = new HashMap<>();
        httpReqest.HttpPost("i=1&c=entry&do=version_android&m=ted_version", body, new BackString() {
            @Override
            public void onSuccess(Response<String> response) {
                Debug.e(MyTooL.getVersionName(context) + "------" + response.body());
                Gson gson = new Gson();
                sdkBean = gson.fromJson(response.body(), GroupSdkBean.class);
                Debug.e("====" + Double.valueOf(sdkBean.getData().getVersion_name()) + "---------" + Double.valueOf(MyTooL.getVersionName(context)));
                if (Double.valueOf(sdkBean.getData().getVersion_name()) > Double.valueOf(MyTooL.getVersionName(context))) {
                    Debug.e("---下载-----" + sdkBean.getData().getAndroid_url());
                    showUpdateDialog();
                }else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Message message = new Message();
                            message.what = 1;
                            handler1.sendMessage(message);

                        }
                    }).start();
                }
            }

            @Override
            public void onError(Response<String> response) {


            }
        });
    }
    private void showUpdateDialog() {
        //弹出对话框提示更新
        AlertDialog.Builder adb = new AlertDialog.Builder(context);
        adb.setTitle("发现新版本");
        adb.setMessage("已发现新版本，请您更新！");

        adb.setCancelable(false);//要么点击确定，要么点击取消。否则不会关闭dialog

        adb.setNegativeButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //下载更新的APK
                downUpdateAPK();
            }
        });
        adb.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //点击取消进入主页面
                handler.sendEmptyMessage(GO_HOME);
            }
        });
        adb.show();
    }

    private final int GO_HOME=100;
    /**
     * 下载新的APK
     */
    private void downUpdateAPK() {
        UpdateManage updateManage = new UpdateManage(context, sdkBean.getData().getAndroid_url());
        updateManage.showDownloadDialog();
        isDown=true;
    }
    private final int SHOW_DIALOG=101;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_HOME:
                    //去主页面
                    if (aCache.getAsString("huanyin") == null) {
                        startAct(Act_Welcome.class);
                        finish();
                    } else {
                        startActClear(Act_Login.class);
                    }
                    break;

                case SHOW_DIALOG:
                    showUpdateDialog();
                    break;
            }
        }
    };
    private boolean isDown=false;

    @Override
    protected void onResume() {
        super.onResume();
        if(isDown==true){
            handler.sendEmptyMessageDelayed(GO_HOME,2500);
        }
    }
}
