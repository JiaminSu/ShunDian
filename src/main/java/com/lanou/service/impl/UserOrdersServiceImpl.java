package com.lanou.service.impl;

import com.lanou.dao.DiZhiMapper;
import com.lanou.dao.UserOrdersMapper;
import com.lanou.entity.DiZhi;
import com.lanou.entity.Orders;
import com.lanou.service.DiZhiService;
import com.lanou.service.UserOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
@Service("userOrdersService")
public class UserOrdersServiceImpl implements UserOrdersService{
    @Autowired
    private UserOrdersMapper userOrdersMapper;

    public List<Orders> findUserOrders(Integer user_id){
        return userOrdersMapper.findUserOrders(user_id);
    }
    public boolean deleteUserOrders(Integer user_id,Integer order_id){
       return userOrdersMapper.deleteUserOrders(user_id,order_id);
    }
}
