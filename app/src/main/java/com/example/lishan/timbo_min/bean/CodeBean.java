package com.example.lishan.timbo_min.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/5 0005.
 */

public class CodeBean {

    /**
     * error_code : 200
     * error_message :
     * data : []
     * session_id : 6c239317eb9f74989a9cf62006fc8ccb
     */

    private String error_code;
    private String error_message;
    private String session_id;
    private List<Object> data;

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
