package com.lanou.entity;

/**
 * Created by lanou on 2017/12/6.
 */
public class User_Info {

    private Integer uId;
    private String uName;

    public User_Info() {
        super();
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Override
    public String toString() {
        return "User_Info{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                '}';
    }
}
