package com.lanou.entity;

/**
 * Created by lanou on 2017/12/8.
 */
public class GoodSmallImage {
    private  int gsId;
    private  String smallUrl1;
    private  String smallUrl2;
    private  String smallUrl3;
    private  String smallUrl4;
    private  String smallUrl5;
    private int gs_id;

    public int getGsId() {
        return gsId;
    }

    public void setGsId(int gsId) {
        this.gsId = gsId;
    }

    public String getSmallUrl1() {
        return smallUrl1;
    }

    public void setSmallUrl1(String smallUrl1) {
        this.smallUrl1 = smallUrl1;
    }

    public String getSmallUrl2() {
        return smallUrl2;
    }

    public void setSmallUrl2(String smallUrl2) {
        this.smallUrl2 = smallUrl2;
    }

    public String getSmallUrl3() {
        return smallUrl3;
    }

    public void setSmallUrl3(String smallUrl3) {
        this.smallUrl3 = smallUrl3;
    }

    public String getSmallUrl4() {
        return smallUrl4;
    }

    public void setSmallUrl4(String smallUrl4) {
        this.smallUrl4 = smallUrl4;
    }

    public String getSmallUrl5() {
        return smallUrl5;
    }

    public void setSmallUrl5(String smallUrl5) {
        this.smallUrl5 = smallUrl5;
    }

    public int getGs_id() {
        return gs_id;
    }

    public void setGs_id(int gs_id) {
        this.gs_id = gs_id;
    }

    @Override
    public String toString() {
        return "GoodSmallImage{" +
                "gsId=" + gsId +
                ", smallUrl1='" + smallUrl1 + '\'' +
                ", smallUrl2='" + smallUrl2 + '\'' +
                ", smallUrl3='" + smallUrl3 + '\'' +
                ", smallUrl4='" + smallUrl4 + '\'' +
                ", smallUrl5='" + smallUrl5 + '\'' +
                ", gs_id=" + gs_id +
                '}';
    }

    public GoodSmallImage() {
        super();
    }

    public GoodSmallImage(int gsId) {
        this.gsId = gsId;
    }
}
