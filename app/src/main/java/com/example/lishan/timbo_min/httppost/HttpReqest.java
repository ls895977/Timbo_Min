package com.example.lishan.timbo_min.httppost;

import com.example.lishan.timbo_min.common.ComantUtils;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;

import org.json.JSONObject;

import java.io.File;
import java.util.Map;

import static com.example.lishan.timbo_min.common.ComantUtils.MyUrl;

/**
 * Created by lishan on 2018/2/24.
 */

public class HttpReqest {
    private BackString onBack;

    public void HttpPost(String url, Map<String, String> params, BackString onBack1) {
        this.onBack = onBack1;
        JSONObject jsonObject = new JSONObject(params);
        OkGo.<String>post(ComantUtils.MyUrl + url).params(params, true).tag(this).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                onBack.onSuccess(response);
            }

            @Override
            public void onError(Response<String> response) {
                onBack.onError(response);
            }
        });
    }

    public void HttpPost(String url, Map<String, String> params, String session_id, BackString onBack1) {
        this.onBack = onBack1;
        JSONObject jsonObject = new JSONObject(params);
        OkGo.<String>post(ComantUtils.MyUrl + url).headers("session_id", session_id).params(params, true).tag(this).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                onBack.onSuccess(response);
            }

            @Override
            public void onError(Response<String> response) {
                onBack.onError(response);
            }
        });
    }

    public void HttpGet(String url, BackString onBack1) {
        this.onBack = onBack1;
        OkGo.<String>get(ComantUtils.MyUrl + url).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                onBack.onSuccess(response);
            }

            @Override
            public void onError(Response<String> response) {

                onBack.onSuccess(response);
            }
        });

    }

    public void HttpGet(String url, Map<String, String> params, BackString onBack1) {
        this.onBack = onBack1;
        Debug.e("url----" + ComantUtils.MyUrl + url);
        OkGo.<String>get(ComantUtils.MyUrl + url).params(params, true).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                onBack.onSuccess(response);
            }

            @Override
            public void onError(Response<String> response) {

                onBack.onSuccess(response);
            }
        });

    }

    public void GetFile(String url) {
        OkGo.<File>get(url)
                .tag(this)
                .execute(new FileCallback() {
                    @Override
                    public void onSuccess(Response<File> response) {

                    }

                    @Override
                    public void downloadProgress(Progress progress) {
                        super.downloadProgress(progress);
                        Debug.e("--------" + progress);
                    }
                });
    }
}
