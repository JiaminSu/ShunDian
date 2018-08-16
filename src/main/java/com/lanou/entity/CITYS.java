package com.lanou.entity;

/**
 * Created by lanou on 2017/12/4.
 */
public class CITYS {
    //地址
    private  Integer cityid;
    private  String cityname;
    private  Integer parentid;

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public CITYS() {
    }

    @Override
    public String toString() {
        return "CITYS{" +
                "cityid=" + cityid +
                ", cityname='" + cityname + '\'' +
                ", parentid=" + parentid +
                '}';
    }
}
