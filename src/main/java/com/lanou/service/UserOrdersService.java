package com.lanou.service;

import com.lanou.entity.DiZhi;
import com.lanou.entity.Orders;

import java.util.List;

public interface UserOrdersService {

	public List<Orders> findUserOrders(Integer user_id);
	public boolean deleteUserOrders(Integer user_id,Integer order_id);
}
