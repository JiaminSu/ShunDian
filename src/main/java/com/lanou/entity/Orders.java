package com.lanou.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by lanou on 2017/12/7.
 */
public class Orders {

    private Integer orderId;//订单主键
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date order_time;//下单时间
    private int order_state;//订单逻辑删除，默认0:订单存在 1：订单已逻辑删除
    private int address_sId;//订单的收货地址
    private Double totalMoney;//订单的总价
    private Integer user_id;//用户的id
    private Integer state;//当前订单的状态，默认0：订单未完成，1：订单已作废，2：订单已完成


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")


    public int getOrder_state() {
        return order_state;
    }

    public void setOrder_state(int order_state) {
        this.order_state = order_state;
    }

    public int getAddress_sId() {
        return address_sId;
    }

    public void setAddress_sId(int address_sId) {
        this.address_sId = address_sId;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Orders() {
        super();
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", order_time='" + order_time + '\'' +
                ", order_state=" + order_state +
                ", address_sId=" + address_sId +
                ", totalMoney=" + totalMoney +
                ", user_id=" + user_id +
                ", state=" + state +
                '}';
    }
}
