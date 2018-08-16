package com.lanou.entity;

import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
public class DiZhi_Info {
    private Integer cityid;   //主键
    private  String cityname;  //地址名字
    private  Integer parentid;  //外键

    private List<DiZhi_Info> diZhi_infos;

    public List<DiZhi_Info> getDiZhi_infos() {
        return diZhi_infos;
    }

    public void setDiZhi_infos(List<DiZhi_Info> diZhi_infos) {
        this.diZhi_infos = diZhi_infos;
    }

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

    public DiZhi_Info() {
        super();
    }

    @Override
    public String toString() {
        return "DiZhi_Info{" +
                "cityid=" + cityid +
                ", cityname='" + cityname + '\'' +
                ", parentid=" + parentid +
                ", diZhi_infos=" + diZhi_infos +
                '}';
    }


}
