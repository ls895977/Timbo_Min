package com.example.lishan.timbo_min.bean;

import java.util.List;

/**
 * Created by lishan on 2018/1/17.
 */

public class LatesActivitivitiesBean {

    /**
     * error_code : 200
     * error_message : 请求成功
     * act_data : [{"id":"10","uid_type":"0","org_level":"0","un_age":"8","com_name":"小杜","com_headimg":"http://pic3.qiyipic.com/common/lego/20180206/134ad87b2fff4995ac4e5c12888c68f8.jpg","title":"这是活动标题","act_address":"上海逸仙路3088","act_start":"1522807380","ctime":"2018-03-04"}]
     */

    private int error_code;
    private String error_message;
    private List<ActDataBean> act_data;

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

    public List<ActDataBean> getAct_data() {
        return act_data;
    }

    public void setAct_data(List<ActDataBean> act_data) {
        this.act_data = act_data;
    }

    public static class ActDataBean {
        /**
         * id : 10
         * uid_type : 0
         * org_level : 0
         * un_age : 8
         * com_name : 小杜
         * com_headimg : http://pic3.qiyipic.com/common/lego/20180206/134ad87b2fff4995ac4e5c12888c68f8.jpg
         * title : 这是活动标题
         * act_address : 上海逸仙路3088
         * act_start : 1522807380
         * ctime : 2018-03-04
         */

        private String id;
        private String uid_type;
        private String org_level;
        private String un_age;
        private String com_name;
        private String com_headimg;
        private String title;
        private String act_address;
        private String act_start;
        private String ctime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUid_type() {
            return uid_type;
        }

        public void setUid_type(String uid_type) {
            this.uid_type = uid_type;
        }

        public String getOrg_level() {
            return org_level;
        }

        public void setOrg_level(String org_level) {
            this.org_level = org_level;
        }

        public String getUn_age() {
            return un_age;
        }

        public void setUn_age(String un_age) {
            this.un_age = un_age;
        }

        public String getCom_name() {
            return com_name;
        }

        public void setCom_name(String com_name) {
            this.com_name = com_name;
        }

        public String getCom_headimg() {
            return com_headimg;
        }

        public void setCom_headimg(String com_headimg) {
            this.com_headimg = com_headimg;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAct_address() {
            return act_address;
        }

        public void setAct_address(String act_address) {
            this.act_address = act_address;
        }

        public String getAct_start() {
            return act_start;
        }

        public void setAct_start(String act_start) {
            this.act_start = act_start;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }
    }
}
