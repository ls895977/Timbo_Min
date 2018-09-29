package com.example.lishan.timbo_min.bean;

public class ProblemFileBean {

    /**
     * error_code : 200
     * error_message :
     * data : {"url":"http://wz.kulehu.com/uploads/attachment/2018-09-26/1bf7c4db3478b0b63d8798.jpeg","f_id":153,"f_path":"/attachment/2018-09-26/1bf7c4db3478b0b63d8798.jpeg","f_name":"1537975344255811.jpeg"}
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
         * url : http://wz.kulehu.com/uploads/attachment/2018-09-26/1bf7c4db3478b0b63d8798.jpeg
         * f_id : 153
         * f_path : /attachment/2018-09-26/1bf7c4db3478b0b63d8798.jpeg
         * f_name : 1537975344255811.jpeg
         */

        private String url;
        private int f_id;
        private String f_path;
        private String f_name;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getF_id() {
            return f_id;
        }

        public void setF_id(int f_id) {
            this.f_id = f_id;
        }

        public String getF_path() {
            return f_path;
        }

        public void setF_path(String f_path) {
            this.f_path = f_path;
        }

        public String getF_name() {
            return f_name;
        }

        public void setF_name(String f_name) {
            this.f_name = f_name;
        }
    }
}
