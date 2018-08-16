package com.lanou.entity;

/**
 * Created by lanou on 2017/12/2.
 */
public class Goods {

    private Integer gId;
    private String gName;
    private Double gPrice;
    private String gDescribe;
    private String gUrl;
    private Integer all_id;
    private int gs_id;

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

    public String getgDescribe() {
        return gDescribe;
    }

    public void setgDescribe(String gDescribe) {
        this.gDescribe = gDescribe;
    }

    public String getgUrl() {
        return gUrl;
    }

    public void setgUrl(String gUrl) {
        this.gUrl = gUrl;
    }

    public Integer getAll_id() {
        return all_id;
    }

    public void setAll_id(Integer all_id) {
        this.all_id = all_id;
    }

    public Goods() {
        super();
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gId=" + gId +
                ", gName='" + gName + '\'' +
                ", gPrice=" + gPrice +
                ", gDescribe='" + gDescribe + '\'' +
                ", gUrl='" + gUrl + '\'' +
                ", all_id=" + all_id +
                ", gs_id=" + gs_id +
                '}';
    }
}
