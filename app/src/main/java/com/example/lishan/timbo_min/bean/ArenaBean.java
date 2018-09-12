package com.example.lishan.timbo_min.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lishan on 2018/1/14.
 */

public class ArenaBean  {
    /**
     * error_code : 200
     * error_message : 获取成功！
     * data : [{"id":"9","weid":"1","type_id":"4","uid":"1","tid":"0","rid":"9","is_new":"0","is_hot":"0","u_delete":"1","status":"1","ord":"1","ctime":"2018-03-16 13:38","join_num":"2","see_num":"0","type_name":"节奏大师","user":{"uid":1,"name":"小杜","type":"0","address":"沈阳市和平区","headimg":"http://pic3.qiyipic.com/common/lego/20180206/134ad87b2fff4995ac4e5c12888c68f8.jpg","age":8,"grade":"3","ctime":"1521857434"},"lz":{"id":"9","lid":"9","uid":"1","join_url":"http://wz.kulehu.com/addons/dxf_act/icon.jpg","desc":"节奏大师3.0","lz_time":"1521178698","comment_num":"1","praise_num":"1","see_num":"0","status":"1","ctime":"1521178698"},"lz_user":{"uid":1,"name":"小杜","type":"0","address":"沈阳市和平区","headimg":"http://pic3.qiyipic.com/common/lego/20180206/134ad87b2fff4995ac4e5c12888c68f8.jpg","age":8,"grade":"3","ctime":"1521857434"}}]
     */

    private int error_code;
    private String error_message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 9
         * weid : 1
         * type_id : 4
         * uid : 1
         * tid : 0
         * rid : 9
         * is_new : 0
         * is_hot : 0
         * u_delete : 1
         * status : 1
         * ord : 1
         * ctime : 2018-03-16 13:38
         * join_num : 2
         * see_num : 0
         * type_name : 节奏大师
         * user : {"uid":1,"name":"小杜","type":"0","address":"沈阳市和平区","headimg":"http://pic3.qiyipic.com/common/lego/20180206/134ad87b2fff4995ac4e5c12888c68f8.jpg","age":8,"grade":"3","ctime":"1521857434"}
         * lz : {"id":"9","lid":"9","uid":"1","join_url":"http://wz.kulehu.com/addons/dxf_act/icon.jpg","desc":"节奏大师3.0","lz_time":"1521178698","comment_num":"1","praise_num":"1","see_num":"0","status":"1","ctime":"1521178698"}
         * lz_user : {"uid":1,"name":"小杜","type":"0","address":"沈阳市和平区","headimg":"http://pic3.qiyipic.com/common/lego/20180206/134ad87b2fff4995ac4e5c12888c68f8.jpg","age":8,"grade":"3","ctime":"1521857434"}
         */

        private String id;
        private String weid;
        private String type_id;
        private String uid;
        private String tid;
        private String rid;
        private String is_new;
        private String is_hot;
        private String u_delete;
        private String status;
        private String ord;
        private String ctime;
        private String join_num;
        private String see_num;
        private String type_name;
        private UserBean user;
        private LzBean lz;
        private LzUserBean lz_user;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getWeid() {
            return weid;
        }

        public void setWeid(String weid) {
            this.weid = weid;
        }

        public String getType_id() {
            return type_id;
        }

        public void setType_id(String type_id) {
            this.type_id = type_id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
        }

        public String getIs_new() {
            return is_new;
        }

        public void setIs_new(String is_new) {
            this.is_new = is_new;
        }

        public String getIs_hot() {
            return is_hot;
        }

        public void setIs_hot(String is_hot) {
            this.is_hot = is_hot;
        }

        public String getU_delete() {
            return u_delete;
        }

        public void setU_delete(String u_delete) {
            this.u_delete = u_delete;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getOrd() {
            return ord;
        }

        public void setOrd(String ord) {
            this.ord = ord;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getJoin_num() {
            return join_num;
        }

        public void setJoin_num(String join_num) {
            this.join_num = join_num;
        }

        public String getSee_num() {
            return see_num;
        }

        public void setSee_num(String see_num) {
            this.see_num = see_num;
        }

        public String getType_name() {
            return type_name;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public LzBean getLz() {
            return lz;
        }

        public void setLz(LzBean lz) {
            this.lz = lz;
        }

        public LzUserBean getLz_user() {
            return lz_user;
        }

        public void setLz_user(LzUserBean lz_user) {
            this.lz_user = lz_user;
        }

        public static class UserBean {
            /**
             * uid : 1
             * name : 小杜
             * type : 0
             * address : 沈阳市和平区
             * headimg : http://pic3.qiyipic.com/common/lego/20180206/134ad87b2fff4995ac4e5c12888c68f8.jpg
             * age : 8
             * grade : 3
             * ctime : 1521857434
             */
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            private int uid;
            private String nameX;
            private String type;
            private String address;
            private String headimg;
            private int age;
            private String grade;
            private String ctime;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getNameX() {
                return nameX;
            }

            public void setNameX(String nameX) {
                this.nameX = nameX;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getHeadimg() {
                return headimg;
            }

            public void setHeadimg(String headimg) {
                this.headimg = headimg;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getGrade() {
                return grade;
            }

            public void setGrade(String grade) {
                this.grade = grade;
            }

            public String getCtime() {
                return ctime;
            }

            public void setCtime(String ctime) {
                this.ctime = ctime;
            }
        }

        public static class LzBean {
            /**
             * id : 9
             * lid : 9
             * uid : 1
             * join_url : http://wz.kulehu.com/addons/dxf_act/icon.jpg
             * desc : 节奏大师3.0
             * lz_time : 1521178698
             * comment_num : 1
             * praise_num : 1
             * see_num : 0
             * status : 1
             * ctime : 1521178698
             */

            private String id;
            private String lid;
            private String uid;
            private String join_url;
            private String desc;
            private String lz_time;
            private String comment_num;
            private String praise_num;
            private String see_num;
            private String status;
            private String ctime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLid() {
                return lid;
            }

            public void setLid(String lid) {
                this.lid = lid;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getJoin_url() {
                return join_url;
            }

            public void setJoin_url(String join_url) {
                this.join_url = join_url;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getLz_time() {
                return lz_time;
            }

            public void setLz_time(String lz_time) {
                this.lz_time = lz_time;
            }

            public String getComment_num() {
                return comment_num;
            }

            public void setComment_num(String comment_num) {
                this.comment_num = comment_num;
            }

            public String getPraise_num() {
                return praise_num;
            }

            public void setPraise_num(String praise_num) {
                this.praise_num = praise_num;
            }

            public String getSee_num() {
                return see_num;
            }

            public void setSee_num(String see_num) {
                this.see_num = see_num;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getCtime() {
                return ctime;
            }

            public void setCtime(String ctime) {
                this.ctime = ctime;
            }
        }

        public static class LzUserBean {
            /**
             * uid : 1
             * name : 小杜
             * type : 0
             * address : 沈阳市和平区
             * headimg : http://pic3.qiyipic.com/common/lego/20180206/134ad87b2fff4995ac4e5c12888c68f8.jpg
             * age : 8
             * grade : 3
             * ctime : 1521857434
             */

            private int uid;
            @SerializedName("name")
            private String nameX;
            private String type;
            private String address;
            private String headimg;
            private int age;
            private String grade;
            private String ctime;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getNameX() {
                return nameX;
            }

            public void setNameX(String nameX) {
                this.nameX = nameX;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getHeadimg() {
                return headimg;
            }

            public void setHeadimg(String headimg) {
                this.headimg = headimg;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getGrade() {
                return grade;
            }

            public void setGrade(String grade) {
                this.grade = grade;
            }

            public String getCtime() {
                return ctime;
            }

            public void setCtime(String ctime) {
                this.ctime = ctime;
            }
        }
    }
}
