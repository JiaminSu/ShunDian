package com.lanou.entity;

/**
 * Created by lanou on 2017/12/6.
 */
public class Comments_Info {

    private String uName;
    private String cContent;

    public Comments_Info() {
        super();
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent;
    }

    @Override
    public String toString() {
        return "Comments_Info{" +
                "uName='" + uName + '\'' +
                ", cContent='" + cContent + '\'' +
                '}';
    }
}
