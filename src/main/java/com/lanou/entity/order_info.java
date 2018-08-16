package com.lanou.entity;

import java.util.Arrays;

/**
 * Created by lanou on 2017/12/12.
 */
public class order_info {

    private Integer order_id;
    private String[] goodsName;
    private ShouDiZhi shouDiZhi;
    private Double price;
    private Integer count;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String[] getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String[] goodsName) {
        this.goodsName = goodsName;
    }

    public ShouDiZhi getShouDiZhi() {
        return shouDiZhi;
    }

    public void setShouDiZhi(ShouDiZhi shouDiZhi) {
        this.shouDiZhi = shouDiZhi;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "order_info{" +
                "order_id=" + order_id +
                ", goodsName=" + Arrays.toString(goodsName) +
                ", shouDiZhi=" + shouDiZhi +
                ", price=" + price +
                ", count=" + count +
                '}';
    }

    public order_info() {
        super();
    }
}
