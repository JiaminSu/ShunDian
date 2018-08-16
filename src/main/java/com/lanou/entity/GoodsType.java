package com.lanou.entity;

import java.util.List;

/**
 * Created by lanou on 2017/12/2.
 */
public class GoodsType {

    private Integer aId;
    private String aName;
    private Integer parentId;
    private Integer type;

    private List<GoodsType> goodsTypes;

    public List<GoodsType> getGoodsTypes() {
        return goodsTypes;
    }

    public void setGoodsTypes(List<GoodsType> goodsTypes) {
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

    public GoodsType() {
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
