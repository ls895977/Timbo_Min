package com.example.lishan.timbo_min.ui;

import android.gesture.GestureLibraries;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseAct;
import com.lykj.aextreme.afinal.utils.ACache;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/5/17 0017.
 */

public class MyWebView extends BaseAct {
    private WebView webView;
    private ACache aCache;

    @Override
    public int initLayoutId() {
        return R.layout.act_mywebview;
    }

    @Override
    public void initView() {
        hideHeader();
        webView = getView(R.id.my_web);
        setOnClickListener(R.id.mywebview_back);
    }

    HashMap<String, String> hashMap = new HashMap<>();

    @Override
    public void initData() {
        aCache = ACache.get(context);
        hashMap.put("app_token", aCache.getAsString("User_token"));
        swiche(getIntent().getIntExtra("indext", 100));
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
            case R.id.mywebview_back:
                finish();
                break;

        }
    }

    public void swiche(int chose) {
        switch (chose) {
            case 0:
                //积分
                webView.loadUrl("http://wz.kulehu.com/app/index.php?i=6&c=entry&eid=2412",hashMap);
                break;
            case 1:
                //成长记录
                webView.loadUrl("http://wz.kulehu.com/app/index.php?i=6&c=entry&eid=2436",hashMap);
                break;
            case 2:
                //我的评论
                webView.loadUrl("http://wz.kulehu.com/app/index.php?i=6&c=entry&op=ucomment&mb=1&do=write&m=dxf_skill",hashMap);
                break;
            case 3:
                //活动记录
                webView.loadUrl("http://wz.kulehu.com/app/index.php?i=6&c=entry&op=uactenroll&mb=1&do=activity&m=dxf_act",hashMap);
                break;
            case 4:
                //我的技能
                webView.loadUrl("http://wz.kulehu.com/app/index.php?i=6&c=entry&op=uskill&mb=1&do=write&m=dxf_skill",hashMap);
                break;
            case 5:
                //报名管理
                webView.loadUrl("http://wz.kulehu.com/app/index.php?i=6&c=entry&op=uenroll&mb=1&do=activity&m=dxf_act&module=1",hashMap);
                break;
            case 6:
                //备忘录
                webView.loadUrl("http://wz.kulehu.com/app/index.php?i=6&c=entry&do=remember&m=tp_remember",hashMap);
                break;
            case 7://成长咨询
                webView.loadUrl("http://wz.kulehu.com/app/index.php?i=6&c=entry&m=ted_grow_news&mb=1&do=list",hashMap);
                break;
            case 8://亲子活动
                webView.loadUrl("http://wz.kulehu.com/app/index.php?i=6&c=entry&op=actlist&mb=1&do=activity&m=dxf_act",hashMap);
                break;
            case 9://我的班级
                webView.loadUrl("http://wz.kulehu.com/four/wap/page/digitalClass/classDetails.html",hashMap);
                break;
            case 10://成长轨迹
                webView.loadUrl("http://wz.kulehu.com/app/index.php?i=6&c=entry&op=gweight&mb=1&do=index&m=dxf_grow",hashMap);
                break;
            case 11://我要运动
                webView.loadUrl("http://wz.kulehu.com/sport/index.html",hashMap);
                break;
            case 12://素质课堂
                webView.loadUrl("http://wz.kulehu.com/app/index.php?i=6&c=entry&do=edu_video_index&m=ted_edu&mb=1",hashMap);
                break;
            case 13://培训机构
                webView.loadUrl("http://wz.kulehu.com/app/index.php?i=6&c=entry&m=ted_edu&do=list&mb=1",hashMap);
                break;
            case 14://晒技能
                webView.loadUrl("http://wz.kulehu.com/app/index.php?i=6&c=entry&op=display&mb=1&do=index&m=dxf_skill",hashMap);
                break;
            case 15://pk竞技
                webView.loadUrl("http://wz.kulehu.com/app/index.php?i=6&c=entry&do=index&m=pk_arena",hashMap);
                break;
            case 16://投票
                webView.loadUrl("http://wz.kulehu.com/app/index.php?i=6&c=entry&rid=107&do=index&m=tyzm_diamondvote",hashMap);
                break;
            case 17://备忘录
                webView.loadUrl("http://wz.kulehu.com/app/index.php?i=6&c=entry&m=tp_remember&do=remember",hashMap);
                break;
            case 18://积分商城
                webView.loadUrl("http://wz.kulehu.com/app/index.php?i=6&c=entry&m=superman_creditmall&do=profile",hashMap);
                break;
            case 19://优惠卷
                webView.loadUrl("http://wz.kulehu.com/app/index.php?i=6&c=entry&m=tp_coupon&do=index",hashMap);
                break;
        }
        WebSettings  //获取Webview的设置对象
                webSettings = webView.getSettings();
        //开启JavaScript调用
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setDomStorageEnabled(true);
        webView.setVerticalScrollBarEnabled(false); //垂直不显示
        webView.setWebChromeClient(new WebChromeClient());
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webvie w的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        //缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setAllowFileAccess(true); //设置可以访问文件、
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setSupportMultipleWindows(true);
    }
}
