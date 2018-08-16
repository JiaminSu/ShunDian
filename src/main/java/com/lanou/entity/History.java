package com.lanou.entity;

/**
 * Created by lanou on 2017/12/8.
 */
public class History {
    private int hId;
    private String goodsName;
    private Double goodsPrice;
    private String goodsImage;
    private String user_name;

    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public History() {
        super();
    }

    @Override
    public String toString() {
        return "History{" +
                "hId=" + hId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsImage='" + goodsImage + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }

    public History(int hId, String goodsName, Double goodsPrice, String goodsImage, String user_name) {
        this.hId = hId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsImage = goodsImage;
        this.user_name = user_name;
    }
}
