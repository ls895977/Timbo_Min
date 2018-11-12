package com.example.lishan.timbo_min.bean;

import java.util.List;

public class ItemCommentsBean {


    /**
     * error_code : 200
     * error_message : 请求成功！
     * data : {"id":"46","module":"2"}
     * comment_data : {"comment":[{"id":"73","uid":"38","name":"你好","age":"0","grade":"","headimg":"","content":"测试内容2","ctime":"1539785852","praise_num":"0","more":[{"id":"74","pid":"73","uid":"38","name":"你好","age":"0","grade":"","headimg":"","content":"回复测试1，哈哈","reply_name":"你好","reply_age":"0","reply_grade":"","reply_headimg":"","praise_num":"0","ctime":"1539876164"}]},{"id":"72","uid":"38","name":"你好","age":"0","grade":"","headimg":"","content":"测试回答1","ctime":"1539783733","praise_num":"0","more":[]}],"page":""}
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
         * id : 46
         * module : 2
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
         * comment : [{"id":"73","uid":"38","name":"你好","age":"0","grade":"","headimg":"","content":"测试内容2","ctime":"1539785852","praise_num":"0","more":[{"id":"74","pid":"73","uid":"38","name":"你好","age":"0","grade":"","headimg":"","content":"回复测试1，哈哈","reply_name":"你好","reply_age":"0","reply_grade":"","reply_headimg":"","praise_num":"0","ctime":"1539876164"}]},{"id":"72","uid":"38","name":"你好","age":"0","grade":"","headimg":"","content":"测试回答1","ctime":"1539783733","praise_num":"0","more":[]}]
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
             * id : 73
             * uid : 38
             * name : 你好
             * age : 0
             * grade :
             * headimg :
             * content : 测试内容2
             * ctime : 1539785852
             * praise_num : 0
             * more : [{"id":"74","pid":"73","uid":"38","name":"你好","age":"0","grade":"","headimg":"","content":"回复测试1，哈哈","reply_name":"你好","reply_age":"0","reply_grade":"","reply_headimg":"","praise_num":"0","ctime":"1539876164"}]
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
            private List<MoreBean> more;

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

            public List<MoreBean> getMore() {
                return more;
            }

            public void setMore(List<MoreBean> more) {
                this.more = more;
            }

            public static class MoreBean {
                /**
                 * id : 74
                 * pid : 73
                 * uid : 38
                 * name : 你好
                 * age : 0
                 * grade :
                 * headimg :
                 * content : 回复测试1，哈哈
                 * reply_name : 你好
                 * reply_age : 0
                 * reply_grade :
                 * reply_headimg :
                 * praise_num : 0
                 * ctime : 1539876164
                 */

                private String id;
                private String pid;
                private String uid;
                private String name;
                private String age;
                private String grade;
                private String headimg;
                private String content;
                private String reply_name;
                private String reply_age;
                private String reply_grade;
                private String reply_headimg;
                private String praise_num;
                private String ctime;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getPid() {
                    return pid;
                }

                public void setPid(String pid) {
                    this.pid = pid;
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

                public String getReply_name() {
                    return reply_name;
                }

                public void setReply_name(String reply_name) {
                    this.reply_name = reply_name;
                }

                public String getReply_age() {
                    return reply_age;
                }

                public void setReply_age(String reply_age) {
                    this.reply_age = reply_age;
                }

                public String getReply_grade() {
                    return reply_grade;
                }

                public void setReply_grade(String reply_grade) {
                    this.reply_grade = reply_grade;
                }

                public String getReply_headimg() {
                    return reply_headimg;
                }

                public void setReply_headimg(String reply_headimg) {
                    this.reply_headimg = reply_headimg;
                }

                public String getPraise_num() {
                    return praise_num;
                }

                public void setPraise_num(String praise_num) {
                    this.praise_num = praise_num;
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
}
