package com.lanou.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by lanou on 2017/12/7.
 */
public class OrdersInfo {

    private Integer orderId;//订单主键

    private String order_time;//下单时间
    private Double totalMoney;//订单的总价
    private String AddressName;//收货人
    private Integer state;//订单状态

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAddressName() {
        return AddressName;
    }

    public void setAddressName(String addressName) {
        AddressName = addressName;
    }


    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }



    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public OrdersInfo() {
        super();
    }

    @Override
    public String toString() {
        return "OrdersInfo{" +
                "orderId=" + orderId +
                ", order_time='" + order_time + '\'' +
                ", totalMoney=" + totalMoney +
                ", AddressName='" + AddressName + '\'' +
                ", state=" + state +
                '}';
    }
}
