package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.entity.Orders;
import com.lanou.entity.OrdersInfo;
import com.lanou.entity.ShouDiZhi;
import com.lanou.service.GoodsTypeService;
import com.lanou.service.ShouDiZhiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lanou on 2017/12/11.
 */
@Controller
@RequestMapping("/")
public class OrdersManageController {

    @Autowired
    private GoodsTypeService goodsTypeService;


    @Autowired
    private ShouDiZhiService shouDiZhiService;

    /*
    * 订单管理模块
    *       订单列表（订单号，收货人,总金额）
    *       查询功能（订单号、收货人（用户的id））
    *       增删改查功能
    * */

    //订单列表分页展示
    @RequestMapping("/finds")
    public void findGoods(int pages,HttpServletResponse response){

        Map<String,Object> maps = new HashMap<String,Object>();
        //订单列表的展示
        List<Orders> ordersList = goodsTypeService.findAllOrders();
        //一共获取到几页
        int page =  (int)Math.ceil((double)ordersList.size()/6) ;

        List<Orders> ordersList1 = goodsTypeService.findOrdersByPage((pages-1)*6);

        List<OrdersInfo> ordersInfos = new ArrayList<OrdersInfo>();
        for(int i=0;i<ordersList.size();i++){

            ShouDiZhi shouDiZhi = shouDiZhiService.findAddressBysId(ordersList.get(i).getAddress_sId());
            String name = "";
            if(shouDiZhi!=null){
                name = shouDiZhi.getsName();
            }
            OrdersInfo ordersInfo = new OrdersInfo();
            ordersInfo.setState(ordersList.get(i).getOrder_state());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String order_time = dateFormat.format(ordersList.get(i).getOrder_time());
            ordersInfo.setOrder_time(order_time);
            ordersInfo.setOrderId(ordersList.get(i).getOrderId());
            ordersInfo.setTotalMoney(ordersList.get(i).getTotalMoney());
            ordersInfo.setAddressName(name);
            ordersInfos.add(ordersInfo);
        }

        maps.put("ordersList",ordersInfos);
        maps.put("page",page);
        FastJson_All.toJson(maps,response);
    }

    //根据订单号实现模糊查询
    @RequestMapping("/findLike")
    public void findlikes(int number,HttpServletResponse response){

        Map<String,Object> maps = new HashMap<String,Object>();
        List<Orders> ordersList = goodsTypeService.findOrdersByOrderId(number);

        List<OrdersInfo> ordersInfos = new ArrayList<OrdersInfo>();
        for(int i=0;i<ordersList.size();i++){

            ShouDiZhi shouDiZhi = shouDiZhiService.findAddressBysId(ordersList.get(i).getAddress_sId());
            String name = "";
            if(shouDiZhi!=null){
                name = shouDiZhi.getsName();
            }

            OrdersInfo ordersInfo = new OrdersInfo();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String order_time = dateFormat.format(ordersList.get(i).getOrder_time());
            ordersInfo.setOrder_time(order_time);
            ordersInfo.setOrderId(ordersList.get(i).getOrderId());
            ordersInfo.setTotalMoney(ordersList.get(i).getTotalMoney());
            ordersInfo.setAddressName(name);
            ordersInfos.add(ordersInfo);

        }

        maps.put("ordersList",ordersInfos);
        FastJson_All.toJson(maps,response);

    }

    //完成逻辑删除功能
    @RequestMapping("/delOrder")
    public void delOrder(int orderId,HttpServletResponse response){

        Map<String,Object> maps = new HashMap<String,Object>();
        int count = goodsTypeService.updateOrderState(orderId);
        if(count==1){
            maps.put("data","SUCCESS");
        }else{
            maps.put("data","ERROR");
        }

        FastJson_All.toJson(maps,response);

    }

}
