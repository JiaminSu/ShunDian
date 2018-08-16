package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.entity.Orders;
import com.lanou.entity.User;
import com.lanou.service.GoodsTypeService;
import com.lanou.service.UserOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
/**
 * Created by lanou on 2017/12/11.
 */
@Controller
@RequestMapping("/")
public class OrdersController {
    //根据用户的id查找属于用户的订单
    @Autowired
    private UserOrdersService userOrdersService;
    @RequestMapping("findUserOrders.do")
    public void findOrders(HttpSession session, HttpServletResponse response){
        Map<String,Object> map=new HashMap<String, Object>();
      User user=(User)session.getAttribute("users");
      Integer user_id= user.getuId();
       List<Orders> orders= userOrdersService.findUserOrders(user_id);


       map.put("orderList",orders);
        FastJson_All.toJson(map,response);
    }

    //删除用户的订单
    @RequestMapping("delereUsersOrders.do")
    public void delereUserOrders(Integer order_id,HttpSession session,HttpServletResponse response){

        User user=(User)session.getAttribute("users");
        Integer user_id= user.getuId();
        System.out.println(user_id);
        boolean result=false;
        if (userOrdersService.deleteUserOrders(user_id,order_id)){
            result=true;
        }
        FastJson_All.toJson(result,response);
    }
}
