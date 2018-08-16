package com.lanou.entity;

import java.util.List;

/**
 * Created by lanou on 2017/12/7.
 */
public class ShouDiZhi {
    private Integer sId;
    private  String sName;
    private  String sArea;
    private  String sAddress;
    private  String sZip;
    private  String sPhone;
    private  Integer user_id;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsArea() {
        return sArea;
    }

    public void setsArea(String sArea) {
        this.sArea = sArea;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsZip() {
        return sZip;
    }

    public void setsZip(String sZip) {
        this.sZip = sZip;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    public ShouDiZhi() {
    }

    @Override
    public String toString() {
        return "ShouDiZhi{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sArea='" + sArea + '\'' +
                ", sAddress='" + sAddress + '\'' +
                ", sZip='" + sZip + '\'' +
                ", sPhone='" + sPhone + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
