package com.example.lishan.timbo_min.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/7/14 0014.
 */

public class CED_PuPBean {

    /**
     * error_code : 200
     * error_message :
     * data : [{"cate_id":"9","cate_name":"英语","img":""},{"cate_id":"10","cate_name":"美术","img":""},{"cate_id":"11","cate_name":"国学","img":""},{"cate_id":"12","cate_name":"书法","img":""},{"cate_id":"19","cate_name":"其他","img":""}]
     */

    private String error_code;
    private String error_message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cate_id : 9
         * cate_name : 英语
         * img :
         */

        private String cate_id;
        private String cate_name;
        private String img;

        public String getCate_id() {
            return cate_id;
        }

        public void setCate_id(String cate_id) {
            this.cate_id = cate_id;
        }

        public String getCate_name() {
            return cate_name;
        }

        public void setCate_name(String cate_name) {
            this.cate_name = cate_name;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }
}
