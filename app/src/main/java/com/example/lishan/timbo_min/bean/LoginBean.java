package com.example.lishan.timbo_min.bean;

/**
 * Created by Administrator on 2018/4/16 0016.
 */

public class LoginBean {

    /**
     * error_code : 200
     * error_message :
     * data : {"uid":"8","username":"u_1523811568264","phone":"15708319320","user_token":"caff4330b2983cdf59b29db2cf4417d711147957","type":"0","points":"0","points_rank_text":"小队长","real_name":"来来","nickname":"","portrait":"","gender":127,"birthday":"2018-04-16","province":0,"city":0,"district":0,"province_text":"","city_text":"","district_text":"","address":"来来来","relation_type_1":"0","relation_name_1":"来来来","relation_type_2":"0","relation_name_2":"了解","school_id":0,"class_id":0,"id_card_front":"","id_card_back":"","company_name":"","credit_code":"","fix_phone":"","education_type":0,"license":"","lng":"0.00000000000000000","lat":"0.00000000000000000","level":"0","level_text":"普通","wechat":"","logo_path":"","photo_path":"","slogen":"","years":"0","company_img":"","company_info":"","company_contact":""}
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
         * uid : 8
         * username : u_1523811568264
         * phone : 15708319320
         * user_token : caff4330b2983cdf59b29db2cf4417d711147957
         * type : 0
         * points : 0
         * points_rank_text : 小队长
         * real_name : 来来
         * nickname :
         * portrait :
         * gender : 127
         * birthday : 2018-04-16
         * province : 0
         * city : 0
         * district : 0
         * province_text :
         * city_text :
         * district_text :
         * address : 来来来
         * relation_type_1 : 0
         * relation_name_1 : 来来来
         * relation_type_2 : 0
         * relation_name_2 : 了解
         * school_id : 0
         * class_id : 0
         * id_card_front :
         * id_card_back :
         * company_name :
         * credit_code :
         * fix_phone :
         * education_type : 0
         * license :
         * lng : 0.00000000000000000
         * lat : 0.00000000000000000
         * level : 0
         * level_text : 普通
         * wechat :
         * logo_path :
         * photo_path :
         * slogen :
         * years : 0
         * company_img :
         * company_info :
         * company_contact :
         */

        private String uid;
        private String username;
        private String phone;
        private String user_token;
        private String type;
        private String points;
        private String points_rank_text;
        private String real_name;
        private String nickname;
        private String portrait;
        private int gender;
        private String birthday;
        private int province;
        private int city;
        private int district;
        private String province_text;
        private String city_text;
        private String district_text;
        private String address;
        private String relation_type_1;
        private String relation_name_1;
        private String relation_type_2;
        private String relation_name_2;
        private int school_id;
        private int class_id;
        private String id_card_front;
        private String id_card_back;
        private String company_name;
        private String credit_code;
        private String fix_phone;
        private int education_type;
        private String license;
        private String lng;
        private String lat;
        private String level;
        private String level_text;
        private String wechat;
        private String logo_path;
        private String photo_path;
        private String slogen;
        private String years;
        private String company_img;
        private String company_info;
        private String company_contact;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getUser_token() {
            return user_token;
        }

        public void setUser_token(String user_token) {
            this.user_token = user_token;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPoints() {
            return points;
        }

        public void setPoints(String points) {
            this.points = points;
        }

        public String getPoints_rank_text() {
            return points_rank_text;
        }

        public void setPoints_rank_text(String points_rank_text) {
            this.points_rank_text = points_rank_text;
        }

        public String getReal_name() {
            return real_name;
        }

        public void setReal_name(String real_name) {
            this.real_name = real_name;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
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

        public String getProvince_text() {
            return province_text;
        }

        public void setProvince_text(String province_text) {
            this.province_text = province_text;
        }

        public String getCity_text() {
            return city_text;
        }

        public void setCity_text(String city_text) {
            this.city_text = city_text;
        }

        public String getDistrict_text() {
            return district_text;
        }

        public void setDistrict_text(String district_text) {
            this.district_text = district_text;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getRelation_type_1() {
            return relation_type_1;
        }

        public void setRelation_type_1(String relation_type_1) {
            this.relation_type_1 = relation_type_1;
        }

        public String getRelation_name_1() {
            return relation_name_1;
        }

        public void setRelation_name_1(String relation_name_1) {
            this.relation_name_1 = relation_name_1;
        }

        public String getRelation_type_2() {
            return relation_type_2;
        }

        public void setRelation_type_2(String relation_type_2) {
            this.relation_type_2 = relation_type_2;
        }

        public String getRelation_name_2() {
            return relation_name_2;
        }

        public void setRelation_name_2(String relation_name_2) {
            this.relation_name_2 = relation_name_2;
        }

        public int getSchool_id() {
            return school_id;
        }

        public void setSchool_id(int school_id) {
            this.school_id = school_id;
        }

        public int getClass_id() {
            return class_id;
        }

        public void setClass_id(int class_id) {
            this.class_id = class_id;
        }

        public String getId_card_front() {
            return id_card_front;
        }

        public void setId_card_front(String id_card_front) {
            this.id_card_front = id_card_front;
        }

        public String getId_card_back() {
            return id_card_back;
        }

        public void setId_card_back(String id_card_back) {
            this.id_card_back = id_card_back;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getCredit_code() {
            return credit_code;
        }

        public void setCredit_code(String credit_code) {
            this.credit_code = credit_code;
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

        public String getLicense() {
            return license;
        }

        public void setLicense(String license) {
            this.license = license;
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

        public String getCompany_img() {
            return company_img;
        }

        public void setCompany_img(String company_img) {
            this.company_img = company_img;
        }

        public String getCompany_info() {
            return company_info;
        }

        public void setCompany_info(String company_info) {
            this.company_info = company_info;
        }

        public String getCompany_contact() {
            return company_contact;
        }

        public void setCompany_contact(String company_contact) {
            this.company_contact = company_contact;
        }
    }
}
