package com.lanou.entity;

import java.util.List;

/**
 * Created by lanou on 2017/12/2.
 */
public class Gallery1 {

    private Integer gId;
    private String gName;
    private Double gPrice;
    private String gUrl;
    private int gs_id;
    private List<String> gImg ;
    private Integer All_id;

    public Integer getAll_id() {
        return All_id;
    }

    public void setAll_id(Integer all_id) {
        All_id = all_id;
    }

    public List<String> getgImg() {
        return gImg;
    }

    public void setgImg(List<String> gImg) {
        this.gImg = gImg;
    }

    public int getGs_id() {
        return gs_id;
    }

    public void setGs_id(int gs_id) {
        this.gs_id = gs_id;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public Double getgPrice() {
        return gPrice;
    }

    public void setgPrice(Double gPrice) {
        this.gPrice = gPrice;
    }

    public String getgUrl() {
        return gUrl;
    }

    public void setgUrl(String gUrl) {
        this.gUrl = gUrl;
    }

    public Gallery1() {
        super();
    }

    @Override
    public String toString() {
        return "Gallery1{" +
                "gId=" + gId +
                ", gName='" + gName + '\'' +
                ", gPrice=" + gPrice +
                ", gUrl='" + gUrl + '\'' +
                ", gs_id=" + gs_id +
                ", gImg=" + gImg +
                ", All_id=" + All_id +
                '}';
    }
}
