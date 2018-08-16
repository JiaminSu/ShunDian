package com.lanou.entity;

/**
 * Created by lanou on 2017/12/11.
 */
public class Orders_goods {

    private Integer orderGoodsId;//订单商品的主键
    private Integer goods_id;//商品的id
    private Integer goods_num;//商品的数量
    private Integer orders_id;//订单的外键

    public Orders_goods() {
        super();
    }

    public Integer getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(Integer orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(Integer goods_num) {
        this.goods_num = goods_num;
    }

    public Integer getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(Integer orders_id) {
        this.orders_id = orders_id;
    }

    @Override
    public String toString() {
        return "Orders_goods{" +
                "orderGoodsId=" + orderGoodsId +
                ", goods_id=" + goods_id +
                ", goods_num=" + goods_num +
                ", orders_id=" + orders_id +
                '}';
    }
}
