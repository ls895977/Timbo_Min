package com.example.lishan.timbo_min.bean;

import java.io.Serializable;

public class HealthPageDetailsBean implements Serializable{

    /**
     * error_code : 200
     * error_message :
     * data : {"aid":"46","cate_id":"2","article_title":"测试2","content":"好的","img":"http://wz.kulehu.com/uploads/attachment/2018-09-27/fda1d154ead651f8c62fbe.jpeg","hits":"5","comments":"0","create_date":"2018-09-27","province":"0","city":"0","district":"0","userinfo":{"uid":"38","username":"u_153675084743","phone":"15708319320","user_token":"3ea5e2e0399e36e483106c11d9a3f3a2d50aef1d","type":"0","points":"1000","points1":"0","points2":"0","points_rank_text":"老队长","real_name":"你好","nickname":"","portrait":"","gender":127,"birthday":"2018-09-12","province":0,"city":0,"district":0,"province_text":"","city_text":"","district_text":"","address":"中国","relation_type_1":"0","relation_name_1":"哈哈","relation_type_2":"0","relation_name_2":"筠连","school_id":0,"class_id":0,"id_card_front":"","id_card_back":"","company_name":"","credit_code":"","fix_phone":"","education_type":0,"license":"","lng":"0.00000000000000000","lat":"0.00000000000000000","level":"0","level_text":"普通","wechat":"","logo_path":"","photo_path":"","slogen":"","years":"0","company_img":"","company_info":"","company_contact":"","is_signed":0,"last_login_time_txt":"13 秒前","last_message":{"module_id":0,"item_id":0,"description":"暂无动态","url":"javascript:;"}}}
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

    public static class DataBean implements Serializable{
        /**
         * aid : 46
         * cate_id : 2
         * article_title : 测试2
         * content : 好的
         * img : http://wz.kulehu.com/uploads/attachment/2018-09-27/fda1d154ead651f8c62fbe.jpeg
         * hits : 5
         * comments : 0
         * create_date : 2018-09-27
         * province : 0
         * city : 0
         * district : 0
         * userinfo : {"uid":"38","username":"u_153675084743","phone":"15708319320","user_token":"3ea5e2e0399e36e483106c11d9a3f3a2d50aef1d","type":"0","points":"1000","points1":"0","points2":"0","points_rank_text":"老队长","real_name":"你好","nickname":"","portrait":"","gender":127,"birthday":"2018-09-12","province":0,"city":0,"district":0,"province_text":"","city_text":"","district_text":"","address":"中国","relation_type_1":"0","relation_name_1":"哈哈","relation_type_2":"0","relation_name_2":"筠连","school_id":0,"class_id":0,"id_card_front":"","id_card_back":"","company_name":"","credit_code":"","fix_phone":"","education_type":0,"license":"","lng":"0.00000000000000000","lat":"0.00000000000000000","level":"0","level_text":"普通","wechat":"","logo_path":"","photo_path":"","slogen":"","years":"0","company_img":"","company_info":"","company_contact":"","is_signed":0,"last_login_time_txt":"13 秒前","last_message":{"module_id":0,"item_id":0,"description":"暂无动态","url":"javascript:;"}}
         */

        private String aid;
        private String cate_id;
        private String article_title;
        private String content;
        private String img;
        private String hits;
        private String comments;
        private String create_date;
        private String province;
        private String city;
        private String district;
        private UserinfoBean userinfo;

        public String getAid() {
            return aid;
        }

        public void setAid(String aid) {
            this.aid = aid;
        }

        public String getCate_id() {
            return cate_id;
        }

        public void setCate_id(String cate_id) {
            this.cate_id = cate_id;
        }

        public String getArticle_title() {
            return article_title;
        }

        public void setArticle_title(String article_title) {
            this.article_title = article_title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getHits() {
            return hits;
        }

        public void setHits(String hits) {
            this.hits = hits;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public String getCreate_date() {
            return create_date;
        }

        public void setCreate_date(String create_date) {
            this.create_date = create_date;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public UserinfoBean getUserinfo() {
            return userinfo;
        }

        public void setUserinfo(UserinfoBean userinfo) {
            this.userinfo = userinfo;
        }

        public static class UserinfoBean implements Serializable{
            /**
             * uid : 38
             * username : u_153675084743
             * phone : 15708319320
             * user_token : 3ea5e2e0399e36e483106c11d9a3f3a2d50aef1d
             * type : 0
             * points : 1000
             * points1 : 0
             * points2 : 0
             * points_rank_text : 老队长
             * real_name : 你好
             * nickname :
             * portrait :
             * gender : 127
             * birthday : 2018-09-12
             * province : 0
             * city : 0
             * district : 0
             * province_text :
             * city_text :
             * district_text :
             * address : 中国
             * relation_type_1 : 0
             * relation_name_1 : 哈哈
             * relation_type_2 : 0
             * relation_name_2 : 筠连
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
             * is_signed : 0
             * last_login_time_txt : 13 秒前
             * last_message : {"module_id":0,"item_id":0,"description":"暂无动态","url":"javascript:;"}
             */

            private String uid;
            private String username;
            private String phone;
            private String user_token;
            private String type;
            private String points;
            private String points1;
            private String points2;
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
            private int is_signed;
            private String last_login_time_txt;
            private LastMessageBean last_message;

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

            public String getPoints1() {
                return points1;
            }

            public void setPoints1(String points1) {
                this.points1 = points1;
            }

            public String getPoints2() {
                return points2;
            }

            public void setPoints2(String points2) {
                this.points2 = points2;
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

            public int getIs_signed() {
                return is_signed;
            }

            public void setIs_signed(int is_signed) {
                this.is_signed = is_signed;
            }

            public String getLast_login_time_txt() {
                return last_login_time_txt;
            }

            public void setLast_login_time_txt(String last_login_time_txt) {
                this.last_login_time_txt = last_login_time_txt;
            }

            public LastMessageBean getLast_message() {
                return last_message;
            }

            public void setLast_message(LastMessageBean last_message) {
                this.last_message = last_message;
            }

            public static class LastMessageBean implements Serializable{
                /**
                 * module_id : 0
                 * item_id : 0
                 * description : 暂无动态
                 * url : javascript:;
                 */

                private int module_id;
                private int item_id;
                private String description;
                private String url;

                public int getModule_id() {
                    return module_id;
                }

                public void setModule_id(int module_id) {
                    this.module_id = module_id;
                }

                public int getItem_id() {
                    return item_id;
                }

                public void setItem_id(int item_id) {
                    this.item_id = item_id;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
