package com.example.lishan.timbo_min.bean;

import java.util.List;

/**
 * Created by lishan on 2018/4/14.
 */

public class Dlg_RegisterChoseBean {

    /**
     * error_code : 200
     * error_message :
     * data : [{"school_id":1,"school_name":"沈阳市第二中学1"},{"school_id":2,"school_name":"沈阳市实验中学"},{"school_id":4,"school_name":"沈阳市第一二七中学"},{"school_id":8,"school_name":"沈阳市第一二七中学附小"},{"school_id":9,"school_name":"沈阳市第一中学"}]
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
         * school_id : 1
         * school_name : 沈阳市第二中学1
         */
        private boolean status;

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

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
