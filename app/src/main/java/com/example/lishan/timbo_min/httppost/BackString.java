package com.example.lishan.timbo_min.httppost;


import com.lzy.okgo.model.Response;

/**
 * Created by lishan on 2018/2/27.
 */

public interface BackString {
    void onSuccess(Response<String> response);

    void onError(Response<String> response);
}
