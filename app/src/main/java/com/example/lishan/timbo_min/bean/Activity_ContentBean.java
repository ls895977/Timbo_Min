package com.example.lishan.timbo_min.bean;

import java.util.List;

/**
 * Created by lishan on 2018/4/20.
 */

public class Activity_ContentBean {

    /**
     * error_code : 200
     * error_message : 请求成功
     * main_data : {"id":"10","uid_type":"0","com_name":"小杜","com_headimg":"http://pic3.qiyipic.com/common/lego/20180206/134ad87b2fff4995ac4e5c12888c68f8.jpg","com_address":"沈阳市和平区","org_level":"0","un_age":"8","title":"这是活动标题","des":"活动描述","ctime":"2018-03-04","collect_num":"2","see_num":"49","city":"上海","region":"宝山区","address":"上海淞南逸仙路3088","sex":"0","age_start":"10","age_end":"18","enroll_status":"1","enroll_start":"1520647380","enroll_end":"1520820180","enroll_address":"上海市淞南镇","act_start":"1522807380","act_end":"1522893780","act_address":"上海逸仙路3088","enroll_contact":"杜先生","enroll_phone":"17521015201","enroll_wx":"du123456","enroll_qq":"985049741","enroll_email":"123456@qq.com","enroll_money":"55.00","img":[{"id":"1","img_url":"http://"}]}
     */

    private int error_code;
    private String error_message;
    private MainDataBean main_data;

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

    public MainDataBean getMain_data() {
        return main_data;
    }

    public void setMain_data(MainDataBean main_data) {
        this.main_data = main_data;
    }

    public static class MainDataBean {
        /**
         * id : 10
         * uid_type : 0
         * com_name : 小杜
         * com_headimg : http://pic3.qiyipic.com/common/lego/20180206/134ad87b2fff4995ac4e5c12888c68f8.jpg
         * com_address : 沈阳市和平区
         * org_level : 0
         * un_age : 8
         * title : 这是活动标题
         * des : 活动描述
         * ctime : 2018-03-04
         * collect_num : 2
         * see_num : 49
         * city : 上海
         * region : 宝山区
         * address : 上海淞南逸仙路3088
         * sex : 0
         * age_start : 10
         * age_end : 18
         * enroll_status : 1
         * enroll_start : 1520647380
         * enroll_end : 1520820180
         * enroll_address : 上海市淞南镇
         * act_start : 1522807380
         * act_end : 1522893780
         * act_address : 上海逸仙路3088
         * enroll_contact : 杜先生
         * enroll_phone : 17521015201
         * enroll_wx : du123456
         * enroll_qq : 985049741
         * enroll_email : 123456@qq.com
         * enroll_money : 55.00
         * img : [{"id":"1","img_url":"http://"}]
         */

        private String id;
        private String uid_type;
        private String com_name;
        private String com_headimg;
        private String com_address;
        private String org_level;
        private String un_age;
        private String title;
        private String des;
        private String ctime;
        private String collect_num;
        private String see_num;
        private String city;
        private String region;
        private String address;
        private String sex;
        private String age_start;
        private String age_end;
        private String enroll_status;
        private String enroll_start;
        private String enroll_end;
        private String enroll_address;
        private String act_start;
        private String act_end;
        private String act_address;
        private String enroll_contact;
        private String enroll_phone;
        private String enroll_wx;
        private String enroll_qq;
        private String enroll_email;
        private String enroll_money;
        private List<ImgBean> img;

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

        public String getCom_address() {
            return com_address;
        }

        public void setCom_address(String com_address) {
            this.com_address = com_address;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getCollect_num() {
            return collect_num;
        }

        public void setCollect_num(String collect_num) {
            this.collect_num = collect_num;
        }

        public String getSee_num() {
            return see_num;
        }

        public void setSee_num(String see_num) {
            this.see_num = see_num;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAge_start() {
            return age_start;
        }

        public void setAge_start(String age_start) {
            this.age_start = age_start;
        }

        public String getAge_end() {
            return age_end;
        }

        public void setAge_end(String age_end) {
            this.age_end = age_end;
        }

        public String getEnroll_status() {
            return enroll_status;
        }

        public void setEnroll_status(String enroll_status) {
            this.enroll_status = enroll_status;
        }

        public String getEnroll_start() {
            return enroll_start;
        }

        public void setEnroll_start(String enroll_start) {
            this.enroll_start = enroll_start;
        }

        public String getEnroll_end() {
            return enroll_end;
        }

        public void setEnroll_end(String enroll_end) {
            this.enroll_end = enroll_end;
        }

        public String getEnroll_address() {
            return enroll_address;
        }

        public void setEnroll_address(String enroll_address) {
            this.enroll_address = enroll_address;
        }

        public String getAct_start() {
            return act_start;
        }

        public void setAct_start(String act_start) {
            this.act_start = act_start;
        }

        public String getAct_end() {
            return act_end;
        }

        public void setAct_end(String act_end) {
            this.act_end = act_end;
        }

        public String getAct_address() {
            return act_address;
        }

        public void setAct_address(String act_address) {
            this.act_address = act_address;
        }

        public String getEnroll_contact() {
            return enroll_contact;
        }

        public void setEnroll_contact(String enroll_contact) {
            this.enroll_contact = enroll_contact;
        }

        public String getEnroll_phone() {
            return enroll_phone;
        }

        public void setEnroll_phone(String enroll_phone) {
            this.enroll_phone = enroll_phone;
        }

        public String getEnroll_wx() {
            return enroll_wx;
        }

        public void setEnroll_wx(String enroll_wx) {
            this.enroll_wx = enroll_wx;
        }

        public String getEnroll_qq() {
            return enroll_qq;
        }

        public void setEnroll_qq(String enroll_qq) {
            this.enroll_qq = enroll_qq;
        }

        public String getEnroll_email() {
            return enroll_email;
        }

        public void setEnroll_email(String enroll_email) {
            this.enroll_email = enroll_email;
        }

        public String getEnroll_money() {
            return enroll_money;
        }

        public void setEnroll_money(String enroll_money) {
            this.enroll_money = enroll_money;
        }

        public List<ImgBean> getImg() {
            return img;
        }

        public void setImg(List<ImgBean> img) {
            this.img = img;
        }

        public static class ImgBean {
            /**
             * id : 1
             * img_url : http://
             */

            private String id;
            private String img_url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }
        }
    }
}
