package com.example.lishan.timbo_min.bean;

import java.util.List;

/**
 * Created by lishan on 2018/1/19.
 */

public class CompetencEdducationBean {
    private String name;
    /**
     * error_code : 200
     * error_message :
     * data : [{"uid":"2","phone":"17555555551","portrait":"http://wz.kulehu.com/uploads/users/2018-04-10/31d67ad5a40b78036ccf92.png","province":210000,"city":210100,"district":210106,"company_name":"欣欣教育机构","fix_phone":"21222","education_type":11,"lng":"0.00000000000000000","lat":"0.00000000000000000","level":"1","level_text":"","wechat":"","logo_path":"","photo_path":"","slogen":"","years":"2"}]
     * page : 1
     * total_page : 1
     */

    private String error_code;
    private String error_message;
    private int page;
    private int total_page;
    private List<DataBean> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_page() {
        return total_page;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uid : 2
         * phone : 17555555551
         * portrait : http://wz.kulehu.com/uploads/users/2018-04-10/31d67ad5a40b78036ccf92.png
         * province : 210000
         * city : 210100
         * district : 210106
         * company_name : 欣欣教育机构
         * fix_phone : 21222
         * education_type : 11
         * lng : 0.00000000000000000
         * lat : 0.00000000000000000
         * level : 1
         * level_text :
         * wechat :
         * logo_path :
         * photo_path :
         * slogen :
         * years : 2
         */

        private String uid;
        private String phone;
        private String portrait;
        private int province;
        private int city;
        private int district;
        private String company_name;
        private String fix_phone;
        private int education_type;
        private String lng;
        private String lat;
        private String level;
        private String level_text;
        private String wechat;
        private String logo_path;
        private String photo_path;
        private String slogen;
        private String years;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public int getDistrict() {
            return district;
        }

        public void setDistrict(int district) {
            this.district = district;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getFix_phone() {
            return fix_phone;
        }

        public void setFix_phone(String fix_phone) {
            this.fix_phone = fix_phone;
        }

        public int getEducation_type() {
            return education_type;
        }

        public void setEducation_type(int education_type) {
            this.education_type = education_type;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getLevel_text() {
            return level_text;
        }

        public void setLevel_text(String level_text) {
            this.level_text = level_text;
        }

        public String getWechat() {
            return wechat;
        }

        public void setWechat(String wechat) {
            this.wechat = wechat;
        }

        public String getLogo_path() {
            return logo_path;
        }

        public void setLogo_path(String logo_path) {
            this.logo_path = logo_path;
        }

        public String getPhoto_path() {
            return photo_path;
        }

        public void setPhoto_path(String photo_path) {
            this.photo_path = photo_path;
        }

        public String getSlogen() {
            return slogen;
        }

        public void setSlogen(String slogen) {
            this.slogen = slogen;
        }

        public String getYears() {
            return years;
        }

        public void setYears(String years) {
            this.years = years;
        }
    }
}
