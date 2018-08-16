package com.lanou.entity;

/**
 * Created by lanou on 2017/12/5.
 */
public class DiZhi {
    private Integer cityid;   //主键
    private  String cityname;  //地址名字
    private  Integer parentid;  //外键

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

    public DiZhi() {
    }

    @Override
    public String toString() {
        return "DiZhi{" +
                "cityid=" + cityid +
                ", cityname='" + cityname + '\'' +
                ", parentid=" + parentid +
                '}';
    }

    public DiZhi(Integer cityid, String cityname, Integer parentid) {
        this.cityid = cityid;
        this.cityname = cityname;
        this.parentid = parentid;
    }
}
