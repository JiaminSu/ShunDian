package com.lanou.dao;

import com.lanou.entity.*;

import java.util.List;

public interface UserOrdersMapper {
	public List<Orders> findUserOrders( Integer user_id);
	public boolean deleteUserOrders(Integer user_id,Integer order_id);
}
