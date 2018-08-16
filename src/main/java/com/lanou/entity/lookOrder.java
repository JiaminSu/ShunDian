package com.lanou.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by lanou on 2017/12/12.
 */
public class lookOrder {

    private Integer order_id;
    private String order_time;
    private Double price;
    private Integer state;
    private List<Goods_info> goods_infos;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public lookOrder() {
        super();
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Goods_info> getGoods_infos() {
        return goods_infos;
    }

    public void setGoods_infos(List<Goods_info> goods_infos) {
        this.goods_infos = goods_infos;
    }

    @Override
    public String toString() {
        return "lookOrder{" +
                "order_id=" + order_id +
                ", order_time='" + order_time + '\'' +
                ", price=" + price +
                ", state=" + state +
                ", goods_infos=" + goods_infos +
                '}';
    }
}
