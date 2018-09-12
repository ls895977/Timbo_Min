package com.example.lishan.timbo_min.bean;

/**
 * Created by Administrator on 2018/6/6 0006.
 */

public class ZanBean {
    /**
     * error_code : 400
     * error_message : 您已经点赞过了，不能再参与了
     */

    private int error_code;
    private String error_message;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }
}
