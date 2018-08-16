package com.lanou.entity;

/**
 * Created by lanou on 2017/12/7.
 */
public class ShopCar {

    private Integer shopId;
    private Integer goods_id;
    private String goods_name;
    private Double goods_price;
    private Integer goods_count;
    private Double goods_sum;
    private String goods_url;
    private Integer delete_id;

    public String getGoods_url() {
        return goods_url;
    }

    public void setGoods_url(String goods_url) {
        this.goods_url = goods_url;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(Double goods_price) {
        this.goods_price = goods_price;
    }

    public Integer getGoods_count() {
        return goods_count;
    }

    public void setGoods_count(Integer goods_count) {
        this.goods_count = goods_count;
    }

    public Double getGoods_sum() {
        return goods_sum;
    }

    public void setGoods_sum(Double goods_sum) {
        this.goods_sum = goods_sum;
    }

    public Integer getDelete_id() {
        return delete_id;
    }

    public void setDelete_id(Integer delete_id) {
        this.delete_id = delete_id;
    }

    public ShopCar() {
        super();
    }

    @Override
    public String toString() {
        return "ShopCar{" +
                "shopId=" + shopId +
                ", goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_price=" + goods_price +
                ", goods_count=" + goods_count +
                ", goods_sum=" + goods_sum +
                ", goods_url='" + goods_url + '\'' +
                ", delete_id=" + delete_id +
                '}';
    }
}
