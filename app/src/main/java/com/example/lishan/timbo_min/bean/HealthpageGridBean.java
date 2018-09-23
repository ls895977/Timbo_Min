package com.example.lishan.timbo_min.bean;

import java.util.List;

public class HealthpageGridBean {


    /**
     * error_code : 200
     * error_message :
     * data : [{"cate_id":"2","cate_name":"营养菜肴","img":"http://wz.kulehu.com/uploads/category/2018-05-22/543d55b2a85e2af2018faf.png"},{"cate_id":"3","cate_name":"身体健康","img":"http://wz.kulehu.com/uploads/category/2018-03-27/6be76c05b498453ecfd4f8.png"},{"cate_id":"4","cate_name":"育儿心得","img":""},{"cate_id":"5","cate_name":"疾病防治","img":""},{"cate_id":"6","cate_name":"学习成长","img":""},{"cate_id":"7","cate_name":"家长杂文","img":""}]
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
         * cate_id : 2
         * cate_name : 营养菜肴
         * img : http://wz.kulehu.com/uploads/category/2018-05-22/543d55b2a85e2af2018faf.png
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
