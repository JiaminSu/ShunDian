package com.lanou.entity;

/**
 * Created by lanou on 2017/12/12.
 */
public class Goods_info {

    private Integer goodsId;
    private String goodsName;
    private String imageUrl;
    private Integer num;
    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Goods_info{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", num=" + num +
                ", price=" + price +
                '}';
    }

    public Goods_info() {
        super();
    }
}
