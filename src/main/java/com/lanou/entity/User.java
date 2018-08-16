package com.lanou.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by lanou on 2017/12/1.
 */
public class User {

    private Integer uId;
    private  String uName;
    private  String uPassword;
    private  String uPhone;
    private  String xName;
    private  String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String QQ;
    private String email;
    private String  address;

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

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getxName() {
        return xName;
    }

    public void setxName(String xName) {
        this.xName = xName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonFormat(pattern = "yyyy-MM-dd ",timezone = "GMT+8")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uPhone='" + uPhone + '\'' +
                ", xName='" + xName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", QQ='" + QQ + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public User(Integer uId, String uName, String uPassword, String uPhone, String xName, String gender, Date birthday, String QQ, String email, String address) {
        this.uId = uId;
        this.uName = uName;
        this.uPassword = uPassword;
        this.uPhone = uPhone;
        this.xName = xName;
        this.gender = gender;
        this.birthday = birthday;
        this.QQ = QQ;
        this.email = email;
        this.address = address;
    }

    //    public String getuPassword() {
//        return uPassword;
//    }
//
//    public void setuPassword(String uPassword) {
//        this.uPassword = uPassword;
//    }
//
//    public Integer getuId() {
//        return uId;
//    }
//
//    public void setuId(Integer uId) {
//        this.uId = uId;
//    }
//
//    public String getuName() {
//        return uName;
//    }
//
//    public void setuName(String uName) {
//        this.uName = uName;
//    }
//
//    public String getuPhone() {
//        return uPhone;
//    }
//
//    public void setuPhone(String uPhone) {
//        this.uPhone = uPhone;
//    }
//
//    public User(String uName, String uPassword, String uPhone) {
//        this.uName = uName;
//        this.uPassword = uPassword;
//        this.uPhone = uPhone;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "uId=" + uId +
//                ", uName='" + uName + '\'' +
//                ", uPassword='" + uPassword + '\'' +
//                ", uPhone='" + uPhone + '\'' +
//                '}';
//    }

    public User() {
        super();
    }


}
