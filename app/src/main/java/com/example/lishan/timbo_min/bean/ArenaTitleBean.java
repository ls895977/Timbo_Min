package com.example.lishan.timbo_min.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class ArenaTitleBean {

    /**
     * error_code : 200
     * error_message : 获取成功！
     * data : [{"id":"1","title":"阿斯蒂芬"},{"id":"2","title":"喝水"},{"id":"4","title":"节奏大师"}]
     */

    private int error_code;
    private String error_message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * title : 阿斯蒂芬
         */

        private String id;
        private String title;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
