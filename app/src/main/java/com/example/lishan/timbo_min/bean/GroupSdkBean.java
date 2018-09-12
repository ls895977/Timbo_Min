package com.example.lishan.timbo_min.bean;

/**
 * Created by lishan on 2018/4/26.
 */

public class GroupSdkBean {

    /**
     * error_code : 200
     * error_message :
     * data : {"version_name":"1.2","version_code":"1.2","usable_code":"1.2","content":"安卓内容","android_url":"http://wz.kulehu.com/uploads/version/2018-04-26/46d085ec9d1854da7a673e.apk","ios_url":""}
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
         * version_name : 1.2
         * version_code : 1.2
         * usable_code : 1.2
         * content : 安卓内容
         * android_url : http://wz.kulehu.com/uploads/version/2018-04-26/46d085ec9d1854da7a673e.apk
         * ios_url :
         */

        private String version_name;
        private String version_code;
        private String usable_code;
        private String content;
        private String android_url;
        private String ios_url;

        public String getVersion_name() {
            return version_name;
        }

        public void setVersion_name(String version_name) {
            this.version_name = version_name;
        }

        public String getVersion_code() {
            return version_code;
        }

        public void setVersion_code(String version_code) {
            this.version_code = version_code;
        }

        public String getUsable_code() {
            return usable_code;
        }

        public void setUsable_code(String usable_code) {
            this.usable_code = usable_code;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAndroid_url() {
            return android_url;
        }

        public void setAndroid_url(String android_url) {
            this.android_url = android_url;
        }

        public String getIos_url() {
            return ios_url;
        }

        public void setIos_url(String ios_url) {
            this.ios_url = ios_url;
        }
    }
}
