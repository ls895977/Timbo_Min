package com.example.lishan.timbo_min.bean;

import java.util.List;

/**
 * Created by lishan on 2018/1/11.
 */

public class CreateaplaBean {

    /**
     * error_code : 200
     * error_message : Success
     * uid : 1000
     * plans : [{"id":"2","name":"计划2","weight":"40.10","age":"11","userID":"1000","height":"120.60","sex":"女","planDistancePerDay":"0.50","planCalory":"1100.70","totalDone":"0.00","createtime":"1521582966","status":"1","use_time":null},{"id":"3","name":"计划3","weight":"50.50","age":"12","userID":"1000","height":"110.40","sex":"女","planDistancePerDay":"5.50","planCalory":"1100.30","totalDone":"0.20","createtime":"1521582966","status":"0","use_time":null}]
     */

    private int error_code;
    private String error_message;
    private String uid;
    private List<PlansBean> plans;

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<PlansBean> getPlans() {
        return plans;
    }

    public void setPlans(List<PlansBean> plans) {
        this.plans = plans;
    }

    public static class PlansBean {
        /**
         * id : 2
         * name : 计划2
         * weight : 40.10
         * age : 11
         * userID : 1000
         * height : 120.60
         * sex : 女
         * planDistancePerDay : 0.50
         * planCalory : 1100.70
         * totalDone : 0.00
         * createtime : 1521582966
         * status : 1
         * use_time : “”
         */

        private String id;
        private String name;
        private String weight;
        private String age;
        private String userID;
        private String height;
        private String sex;
        private String planDistancePerDay;
        private String planCalory;
        private String totalDone;
        private String createtime;
        private String status;

        public boolean isQiyong() {
            return qiyong;
        }

        public void setQiyong(boolean qiyong) {
            this.qiyong = qiyong;
        }

        private String  use_time;
        private boolean qiyong;
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getPlanDistancePerDay() {
            return planDistancePerDay;
        }

        public void setPlanDistancePerDay(String planDistancePerDay) {
            this.planDistancePerDay = planDistancePerDay;
        }

        public String getPlanCalory() {
            return planCalory;
        }

        public void setPlanCalory(String planCalory) {
            this.planCalory = planCalory;
        }

        public String getTotalDone() {
            return totalDone;
        }

        public void setTotalDone(String totalDone) {
            this.totalDone = totalDone;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUse_time() {
            return use_time;
        }

        public void setUse_time(String use_time) {
            this.use_time = use_time;
        }
    }
}

