package com.example.lishan.timbo_min.bean;

/**
 * Created by lishan on 2018/4/14.
 */

public class Dlg_RegisterNoChoseBean {

    /**
     * error_code : 200
     * error_message :
     * data : {"school_id":32,"school_name":"民主中学"}
     */

    private String error_code;
    private String error_message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * school_id : 32
         * school_name : 民主中学
         */

        private int school_id;
        private String school_name;

        public int getSchool_id() {
            return school_id;
        }

        public void setSchool_id(int school_id) {
            this.school_id = school_id;
        }

        public String getSchool_name() {
            return school_name;
        }

        public void setSchool_name(String school_name) {
            this.school_name = school_name;
        }
    }
}
