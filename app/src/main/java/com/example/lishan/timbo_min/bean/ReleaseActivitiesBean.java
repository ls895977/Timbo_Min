package com.example.lishan.timbo_min.bean;

/**
 * Created by Administrator on 2018/4/22 0022.
 */

public class ReleaseActivitiesBean {

    /**
     * error_code : 200
     * error_message : 保存成功！
     * data : {"id":"16"}
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
         * id : 16
         */

        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
