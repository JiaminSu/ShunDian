package com.lanou.entity;

/**
 * Created by lanou on 2017/12/6.
 */
public class indexFandL {
    private Integer  ppId ;
    private Integer  TypeId ;
    private String url;


    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public Integer getTypeId() {
        return TypeId;
    }

    public void setTypeId(Integer typeId) {
        TypeId = typeId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public indexFandL() {
        super();
    }

    @Override
    public String toString() {
        return "findLandF{" +
                "ppId=" + ppId +
                ", TypeId=" + TypeId +
                ", url='" + url + '\'' +
                '}';
    }

    public indexFandL(Integer typeId, String url) {
        TypeId = typeId;
        this.url = url;
    }
}
