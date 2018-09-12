package com.example.lishan.timbo_min.bean;

/**
 * Created by Administrator on 2018/4/16 0016.
 */

public class AddClassBean {

    /**
     * error_code : 200
     * error_message :
     * data : {"class_id":35,"school_id":34,"grade_name":"1","class_name":"1"}
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
         * class_id : 35
         * school_id : 34
         * grade_name : 1
         * class_name : 1
         */

        private int class_id;
        private int school_id;
        private String grade_name;
        private String class_name;

        public int getClass_id() {
            return class_id;
        }

        public void setClass_id(int class_id) {
            this.class_id = class_id;
        }

        public int getSchool_id() {
            return school_id;
        }

        public void setSchool_id(int school_id) {
            this.school_id = school_id;
        }

        public String getGrade_name() {
            return grade_name;
        }

        public void setGrade_name(String grade_name) {
            this.grade_name = grade_name;
        }

        public String getClass_name() {
            return class_name;
        }

        public void setClass_name(String class_name) {
            this.class_name = class_name;
        }
    }
}
