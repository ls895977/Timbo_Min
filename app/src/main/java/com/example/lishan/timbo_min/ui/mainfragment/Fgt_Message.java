package com.example.lishan.timbo_min.ui.mainfragment;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.lishan.timbo_min.R;
import com.example.lishan.timbo_min.common.BaseFgt;

/**
 * Created by lishan on 2017/12/10.
 */

public class Fgt_Message extends BaseFgt {
    private WebView myWebView;

    @Override
    public void sendMsg(int flag, Object obj) {

    }

    @Override
    public int initLayoutId() {
        return R.layout.fgt_message;
    }

    @Override
    public void initView() {
        hideHeader();
        myWebView = getView(R.id.message_webview);
        myWebView.loadUrl("http://wz.kulehu.com/h5/my_message.html");
        WebSettings  //获取Webview的设置对象
                webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //声明WebSettings子类
//如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
////设置自适应屏幕，两者合用、
        webSettings.setUseWideViewPort(true); //将图片调整到适合webvie w的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
////缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
//        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
////其他细节操作、
//        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件、
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        myWebView.setWebChromeClient(new WebChromeClient());
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
}
