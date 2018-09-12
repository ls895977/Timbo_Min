package com.example.lishan.timbo_min.bean;

/**
 * Created by lishan on 2018/5/8.
 */

public class DetectionResultBean {

    /**
     * error_code : 200
     * error_message : Success
     * personInfo : {"sex":"男","height":"1","weight":"1","age":"1"}
     * standard : {"sex":"男","height":120,"weight":30.5,"age":13}
     * recommandedPlan : {"planDistancePerDay":3.5,"totalCalory":3330,"description":"您的体型偏胖"}
     */

    private int error_code;
    private String error_message;
    private PersonInfoBean personInfo;
    private StandardBean standard;
    private RecommandedPlanBean recommandedPlan;

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

    public PersonInfoBean getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfoBean personInfo) {
        this.personInfo = personInfo;
    }

    public StandardBean getStandard() {
        return standard;
    }

    public void setStandard(StandardBean standard) {
        this.standard = standard;
    }

    public RecommandedPlanBean getRecommandedPlan() {
        return recommandedPlan;
    }

    public void setRecommandedPlan(RecommandedPlanBean recommandedPlan) {
        this.recommandedPlan = recommandedPlan;
    }

    public static class PersonInfoBean {
        /**
         * sex : 男
         * height : 1
         * weight : 1
         * age : 1
         */

        private String sex;
        private String height;
        private String weight;
        private String age;

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
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
    }

    public static class StandardBean {
        /**
         * sex : 男
         * height : 120
         * weight : 30.5
         * age : 13
         */

        private String sex;
        private int height;
        private double weight;
        private int age;

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static class RecommandedPlanBean {
        /**
         * planDistancePerDay : 3.5
         * totalCalory : 3330
         * description : 您的体型偏胖
         */

        private double planDistancePerDay;
        private int totalCalory;
        private String description;

        public double getPlanDistancePerDay() {
            return planDistancePerDay;
        }

        public void setPlanDistancePerDay(double planDistancePerDay) {
            this.planDistancePerDay = planDistancePerDay;
        }

        public int getTotalCalory() {
            return totalCalory;
        }

        public void setTotalCalory(int totalCalory) {
            this.totalCalory = totalCalory;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
