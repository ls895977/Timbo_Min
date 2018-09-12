package com.example.lishan.timbo_min.bean;

import java.util.List;

/**
 * Created by lishan on 2018/6/9.
 */

public class Comment_DetailsBean {

    /**
     * error_code : 200
     * error_message : 请求成功！
     * data : {"id":"6","module":"7"}
     * comment_data : {"comment":[{"id":"67","uid":"32","name":"阿卡丽","age":"0","grade":"","headimg":"","content":"哈哈","ctime":"1530271269","praise_num":"0","more":[]}],"page":""}
     */

    private int error_code;
    private String error_message;
    private DataBean data;
    private CommentDataBean comment_data;

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

    public CommentDataBean getComment_data() {
        return comment_data;
    }

    public void setComment_data(CommentDataBean comment_data) {
        this.comment_data = comment_data;
    }

    public static class DataBean {
        /**
         * id : 6
         * module : 7
         */

        private String id;
        private String module;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getModule() {
            return module;
        }

        public void setModule(String module) {
            this.module = module;
        }
    }

    public static class CommentDataBean {
        /**
         * comment : [{"id":"67","uid":"32","name":"阿卡丽","age":"0","grade":"","headimg":"","content":"哈哈","ctime":"1530271269","praise_num":"0","more":[]}]
         * page :
         */

        private String page;
        private List<CommentBean> comment;

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public List<CommentBean> getComment() {
            return comment;
        }

        public void setComment(List<CommentBean> comment) {
            this.comment = comment;
        }

        public static class CommentBean {
            /**
             * id : 67
             * uid : 32
             * name : 阿卡丽
             * age : 0
             * grade :
             * headimg :
             * content : 哈哈
             * ctime : 1530271269
             * praise_num : 0
             * more : []
             */

            private String id;
            private String uid;
            private String name;
            private String age;
            private String grade;
            private String headimg;
            private String content;
            private String ctime;
            private String praise_num;
            private List<?> more;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            public String getGrade() {
                return grade;
            }

            public void setGrade(String grade) {
                this.grade = grade;
            }

            public String getHeadimg() {
                return headimg;
            }

            public void setHeadimg(String headimg) {
                this.headimg = headimg;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCtime() {
                return ctime;
            }

            public void setCtime(String ctime) {
                this.ctime = ctime;
            }

            public String getPraise_num() {
                return praise_num;
            }

            public void setPraise_num(String praise_num) {
                this.praise_num = praise_num;
            }

            public List<?> getMore() {
                return more;
            }

            public void setMore(List<?> more) {
                this.more = more;
            }
        }
    }
}
