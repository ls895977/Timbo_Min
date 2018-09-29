package com.example.lishan.timbo_min.bean;

public class ProblemImgBean {
    private String f_id;
    private String f_path;

    public String getF_id() {
        return f_id;
    }

    public void setF_id(String f_id) {
        this.f_id = f_id;
    }

    public String getF_path() {
        return f_path;
    }

    public void setF_path(String f_path) {
        this.f_path = f_path;
    }

    public ProblemImgBean(String f_id, String f_path) {
        this.f_id = f_id;
        this.f_path = f_path;
    }
}
