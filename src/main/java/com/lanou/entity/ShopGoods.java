package com.lanou.entity;

/**
 * Created by lanou on 2017/12/12.
 */
public class ShopGoods {
    private Integer GoodsId;
    private String GoodsName;
    private Integer ShopCard;
    private double GoodsPrice;
    private String   GoodsImageUrl;

    public Integer getGoodsId() {
        return GoodsId;
    }

    public void setGoodsId(Integer goodsId) {
        GoodsId = goodsId;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public Integer getShopCard() {
        return ShopCard;
    }

    public void setShopCard(Integer shopCard) {
        ShopCard = shopCard;
    }

    public double getGoodsPrice() {
        return GoodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        GoodsPrice = goodsPrice;
    }

    public String getGoodsImageUrl() {
        return GoodsImageUrl;
    }

    public void setGoodsImageUrl(String goodsImageUrl) {
        GoodsImageUrl = goodsImageUrl;
    }

    @Override
    public String toString() {
        return "ShopGoods{" +
                "GoodsId=" + GoodsId +
                ", GoodsName='" + GoodsName + '\'' +
                ", ShopCard=" + ShopCard +
                ", GoodsPrice=" + GoodsPrice +
                ", GoodsImageUrl='" + GoodsImageUrl + '\'' +
                '}';
    }

    public ShopGoods() {
        super();
    }
}
