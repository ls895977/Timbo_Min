package com.example.lishan.timbo_min;

import android.app.ProgressDialog;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.lishan.timbo_min.common.BaseAct;
import com.lykj.aextreme.afinal.utils.ACache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/24 0024.
 */

public class MyWeb extends BaseAct {
    private WebView mywebview;
    private ACache aCache;

    @Override
    public int initLayoutId() {
        return R.layout.my_web;
    }

    @Override
    public void initView() {
        hideHeader();
        mywebview = getView(R.id.android_web);
    }

    private ProgressDialog dialog;

    @Override
    public void initData() {
        aCache = ACache.get(this);
        String fileUrl = "file:///android_asset/index.html";
        mywebview.getSettings().setDefaultTextEncodingName("utf-8");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("app_token", aCache.getAsString("User_token"));
        mywebview.loadUrl(fileUrl, hashMap);
        //覆盖WebView默认通过第三方或者是系统浏览器打开网页的行为，使得网页可以在WebView中打开
        mywebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候是控制网页在WebView中去打开，如果为false调用系统浏览器或第三方浏览器打开
                view.loadUrl(url);
                return true;
            }
            //WebViewClient帮助WebView去处理一些页面控制和请求通知
        });
        //启用支持Javascript
        WebSettings settings = mywebview.getSettings();
        settings.setJavaScriptEnabled(true);
        //WebView加载页面优先使用缓存加载
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //页面加载
        mywebview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                //newProgress   1-100之间的整数
                if (newProgress == 100) {
                    //页面加载完成，关闭ProgressDialog
                    closeDialog();
                } else {
                    //网页正在加载，打开ProgressDialog
                    openDialog(newProgress);
                }
            }

            private void openDialog(int newProgress) {
                if (dialog == null) {
                    dialog = new ProgressDialog(MyWeb.this);
                    dialog.setTitle("正在加载");
                    dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    dialog.setProgress(newProgress);
                    dialog.setCancelable(true);
                    dialog.show();
                } else {
                    dialog.setProgress(newProgress);
                }
            }

            private void closeDialog() {
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                    dialog = null;
                }
            }
        });
        WebSettings  //获取Webview的设置对象
                webSettings = mywebview.getSettings();
        //开启JavaScript调用
        webSettings.setJavaScriptEnabled(true);
        mywebview.setWebViewClient(new WebViewClient());
        mywebview.getSettings().setDomStorageEnabled(true);
        mywebview.setVerticalScrollBarEnabled(false); //垂直不显示
        mywebview.setWebChromeClient(new WebChromeClient());
        mywebview.setWebViewClient(new WebViewClient());
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

    /**
     * mWebView.goBack(); //后退 mWebView.goForward();//前进 mWebView.reload(); //刷新
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (keyCode == KeyEvent.KEYCODE_BACK && mywebview.canGoBack()) { // 表示按返回键时的操作
                mywebview.goBack(); // 后退
                // webview.goForward();//前进
                return true; // 已处理
            } else {
                // 直接退出app
                System.exit(0);
            }
        }
        return false;
    }
}
