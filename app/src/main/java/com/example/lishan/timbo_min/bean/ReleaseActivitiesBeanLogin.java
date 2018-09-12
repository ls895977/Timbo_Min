package com.example.lishan.timbo_min.bean;

/**
 * Created by Administrator on 2018/4/21 0021.
 */

public class ReleaseActivitiesBeanLogin {

    /**
     * error_code : 200
     * error_message : 请求成功！
     * data : {"headimg":"","name":"来来"}
     */

    private int error_code;
    private String error_message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * headimg :
         * name : 来来
         */

        private String headimg;
        private String name;

        public String getHeadimg() {
            return headimg;
        }

        public void setHeadimg(String headimg) {
            this.headimg = headimg;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
