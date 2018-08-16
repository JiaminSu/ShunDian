package com.lanou.entity;

import java.util.List;

/**
 * Created by lanou on 2017/12/2.
 */
public class Gallery {

    private Integer aId;
    private String aName;
    private Integer parentId;
    private Integer type;

    private List<Gallery> goodsTypes;

    public List<Gallery> getGoodsTypes() {
        return goodsTypes;
    }

    public void setGoodsTypes(List<Gallery> goodsTypes) {
        this.goodsTypes = goodsTypes;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Gallery() {
        super();
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", parentId=" + parentId +
                ", type=" + type +
                ", goodsTypes=" + goodsTypes +
                '}';
    }
}
