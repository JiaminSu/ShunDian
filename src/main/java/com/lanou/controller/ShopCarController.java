package com.lanou.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lanou.Util.FastJson_All;
import com.lanou.entity.*;
import com.lanou.service.GoodsTypeService;
import com.lanou.service.ShouDiZhiService;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lanou on 2017/12/7.
 */
@Controller
@RequestMapping("/")
public class ShopCarController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @Autowired
    private ShouDiZhiService shouDiZhiService;

    //=====================加入购物车功能模块================
    /*
    * 每次点击加入购物车就发送一个ajax请求，将当前商品的goods_id和数量传过来
    * 根据goods_id找到当前商品，再将当前商品的GoodsId,GoodsName,GoodsPrice,GoodsImageUrl找到
    *
    * */
    @RequestMapping("/addCar")
    public void addShop(Integer id, Integer count, HttpServletResponse response, HttpSession session) {

        Map<String, Object> map = new HashMap<String, Object>();

        //当前用户加入购物车，如果是在未登录的状态下，先需要让用户在右边栏登录
        User user = (User) session.getAttribute("users");
        System.out.println("当前User中的值为：" + user);
        if (user == null) {
            map.put("data", "ERROR");
        } else {
            //根据商品的id查找到当前商品
            Goods goods = goodsTypeService.findGoodsById(id).get(0);
            //将当前查找到的商品的信息整合
            //在根据商品的goods_id,查找当前ShopCar表中是否有当前goods_id
            int goods_id = goods.getgId();
            ShopCar shopCar1 = goodsTypeService.findShopCargoods_id(goods_id);
            if (shopCar1 != null) {
                //1、当前商品存在ShopCar表中
                shopCar1.setGoods_count(shopCar1.getGoods_count() + count);
                shopCar1.setGoods_sum(shopCar1.getGoods_count() * shopCar1.getGoods_price());
                goodsTypeService.updateShopCar1(shopCar1.getGoods_count(), shopCar1.getGoods_sum(), shopCar1.getGoods_id());
            } else {
                //2、当前商品不存在于ShopCar表中
                ShopCar shopCar = new ShopCar();
                shopCar.setGoods_id(goods.getgId());
                shopCar.setGoods_name(goods.getgName());
                shopCar.setGoods_price(goods.getgPrice());
                shopCar.setGoods_count(count);
                shopCar.setGoods_sum(goods.getgPrice() * count);
                shopCar.setGoods_url(goods.getgUrl());
                goodsTypeService.updateShopCar
                        (shopCar.getGoods_id(), shopCar.getGoods_name(), shopCar.getGoods_price(),
                                shopCar.getGoods_count(), shopCar.getGoods_sum(), shopCar.getGoods_url());
            }
            map.put("data", "SUCCESS");
        }

        FastJson_All.toJson(map, response);

    }
    //============================================================================================

    @RequestMapping("/subCar")
    public void subShop(Integer id, Integer count, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();
        //根据商品的id查找到当前商品
        Goods goods = goodsTypeService.findGoodsById(id).get(0);

        ShopCar shopCar1 = goodsTypeService.findShopCargoods_id(goods.getgId());
        shopCar1.setGoods_count(shopCar1.getGoods_count() - count);
        shopCar1.setGoods_sum(shopCar1.getGoods_count() * shopCar1.getGoods_price());
        goodsTypeService.updateShopCar1(shopCar1.getGoods_count(), shopCar1.getGoods_sum(), shopCar1.getGoods_id());

        map.put("data", "SUCCESS");
        FastJson_All.toJson(map, response);

    }

    @RequestMapping("/delCar")
    public void delShop(Integer id, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();
        goodsTypeService.deleteShopCar(id);
        map.put("data", "SUCCESS");
        FastJson_All.toJson(map, response);

    }

    //====================侧边栏点击购物车模块=====================
    /*
    * 点击侧边栏购物车模块的时候，查找ShopCar表中的数据，把所有的数据给前端
    * */
    @RequestMapping("/lookShopCar")
    public void lookShopCar(HttpServletResponse response, HttpSession session) {

        Map<String, Object> map = new HashMap<String, Object>();

        User user = (User) session.getAttribute("users");
        if (user == null) {
            map.put("data", "ERROR");
        } else {
            //将ShopCar表中所有的数据查找出来
            List<ShopCar> shopCars = goodsTypeService.findShopCar();
            int count = 0;
            double price = 0;
            for (int i = 0; i < shopCars.size(); i++) {
                count += shopCars.get(i).getGoods_count();
                price += shopCars.get(i).getGoods_sum();
            }
            map.put("data", shopCars);
            map.put("count", count);
            map.put("price", price);
        }
        FastJson_All.toJson(map, response);

    }
    //============================================================

    //====================侧边栏点击结算功能模块==================
    /*
    *  传过来的是商品的Goods_id
    * {"aId":1-2-5}
    * */
    @RequestMapping("/account")
    public void account(String aId, HttpServletResponse response, HttpSession session, HttpServletRequest request) {

        //先接收到session中用户的id
        User user = (User) session.getAttribute("users");
        int uId = user.getuId();
        List<ShouDiZhi> shouDiZhi = shouDiZhiService.findShouDiZhi(uId);

        String[] ss = aId.split("\\-");

        List<ShopCar> shopCars = new ArrayList<ShopCar>();
        for (int i = 0; i < ss.length; i++) {
            ShopCar shopCar = goodsTypeService.findShopCargoods_id(Integer.parseInt(ss[i]));
            shopCars.add(shopCar);
        }

        Map<String, Object> map = new HashMap<String, Object>();
        //把他们返回给前端
        int count = 0;
        double price = 0;
        String Goods_name = "";
        String Goods_name1 = "";
        for (int i = 0; i < shopCars.size(); i++) {
            count += shopCars.get(i).getGoods_count();
            price += shopCars.get(i).getGoods_sum();
//            Goods_name1 += shopCars.get(i).getGoods_name();
//            Goods_name1 += "\\";
//
//            Goods_name += shopCars.get(i).getGoods_name();
//            Goods_name += "/";
        }

        map.put("count", count);
        map.put("price", price);
        map.put("data", shopCars);
        map.put("address", shouDiZhi);
        request.getSession().setAttribute("count", count);
        request.getSession().setAttribute("price", price);
//        request.getSession().setAttribute("address",address);
//        request.getSession().setAttribute("address1",address1);
        request.getSession().setAttribute("shopList",shopCars);
        FastJson_All.toJson(map, response);
    }


    //====================生成订单界面==================
    @RequestMapping("/order")
    public void orders(Integer sId, HttpServletResponse response, HttpSession session) {

        //先接收到session中用户的id
        User user = (User) session.getAttribute("users");

        int uId = user.getuId();
        int count = (Integer) session.getAttribute("count");
        double price = (Double) session.getAttribute("price");

        //ShouDiZhi shouDiZhi = shouDiZhiService.findShouDiZhiBysId(sId,uId);

        //获取当前时间
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String order_time = dateFormat.format(date);
        //获取收货地址sId
        //获取totalMoney

        //将数据插入order表中
        goodsTypeService.addOrders(order_time, sId, price, uId);

        //查找当前orderId表中最大的主键
        Integer maxId = goodsTypeService.findMaxOrders();
        System.out.println("当前最大主键为："+maxId);

        //先获取所有商品的goods_id
        List<ShopCar> shopCars = (List<ShopCar>) session.getAttribute("shopList");
        for (int i = 0; i < shopCars.size(); i++) {
            //获取商品的goods_id
            int goods_id = shopCars.get(i).getGoods_id();
            int goods_num = shopCars.get(i).getGoods_count();
            goodsTypeService.addOrdersGoods(goods_id, goods_num, maxId);
        }


        //查询当前的订单表，根据maxId
        Orders orders = goodsTypeService.findOrdersByMaxId(maxId);
        //取到当前订单的地址id
        int address_id = orders.getAddress_sId();
        ShouDiZhi address = shouDiZhiService.findAddressBysId(address_id);
        //根据订单的主键maxId，查找Orders_goods表中的记录
        List<Orders_goods> orders_goodss = goodsTypeService.findOrdersGoodsByorders_id(maxId);
        List<Goods> goodsList = new ArrayList<Goods>();
        String[] goodsName = new String[orders_goodss.size()];
        for(int i=0;i<orders_goodss.size();i++){

            //得到当前商品id
            int goods_id = orders_goodss.get(i).getGoods_id();
            //得到当前商品的数量
            int goods_num = orders_goodss.get(i).getGoods_num();
            //根据商品的id查找到当前商品的名字
            Goods goods = goodsTypeService.findGoodsById(goods_id).get(0);
            goodsList.add(goods);
            goodsName[i]=goods.getgName();
        }

        order_info order_info = new order_info();
        order_info.setCount(count);
        order_info.setGoodsName(goodsName);
        order_info.setOrder_id(maxId);
        order_info.setShouDiZhi(address);
        order_info.setPrice(price);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data",order_info);

//        map.put("address",address);
//        map.put("count", count);
//        map.put("price", price);
//        map.put("goods_name",goodsList);
//        map.put("orderId",maxId);

        //删除购物车中的内容
        goodsTypeService.deleteShopCarAll();
        FastJson_All.toJson(map, response);

    }

    //====================展示订单界面==================
    @RequestMapping("/views.do")
    public void lookOrders(HttpServletResponse response, HttpSession session) {

        //先接收到session中用户的id
        User user = (User) session.getAttribute("users");

        int uId = user.getuId();

        //查询当前用户的所有订单
        List<Orders> ordersList = goodsTypeService.findAllOrdersByUser_id(uId);
        //先根据当前用户的所有订单的主键跟Order_goods表中的外键匹配，查找到所有的Order_goods集合
        List<lookOrder> lookOrders = new ArrayList<lookOrder>();
        for(int i=0;i<ordersList.size();i++){
            lookOrder lookOrder = new lookOrder();
            //先取到当前订单的主键
            int orders_id = ordersList.get(i).getOrderId();
            List<Orders_goods> orders_goodss = goodsTypeService.findOrdersGoodsByorders_id(orders_id);
            List<Goods_info> goods_infos = new ArrayList<Goods_info>();
            for(int j=0;j<orders_goodss.size();j++){
                //得到当前商品id
                int goods_id = orders_goodss.get(j).getGoods_id();
                //得到当前商品的数量
                int goods_num = orders_goodss.get(j).getGoods_num();
                Goods goods = goodsTypeService.findGoodsById(goods_id).get(0);
                //得到当前商品的单价
                Double price = goods.getgPrice();
                Goods_info goods_info = new Goods_info();
                goods_info.setGoodsId(goods.getgId());
                goods_info.setGoodsName(goods.getgName());
                goods_info.setImageUrl(goods.getgUrl());
                goods_info.setNum(goods_num);
                goods_info.setPrice(price);
                goods_infos.add(goods_info);
            }
            lookOrder.setState(ordersList.get(i).getState());
            lookOrder.setOrder_id(orders_id);
            lookOrder.setPrice(ordersList.get(i).getTotalMoney());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String order_time = dateFormat.format(ordersList.get(i).getOrder_time());
            lookOrder.setOrder_time(order_time);
            lookOrder.setGoods_infos(goods_infos);
            lookOrders.add(lookOrder);
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data",lookOrders);

        FastJson_All.toJson(map, response);

    }

    //点击支付界面
    @RequestMapping("/pay")
    public void pays(Integer orderId,HttpServletResponse response, HttpSession session) {

        Map<String,Object> map = new HashMap<String,Object>();
        //先接收到session中用户的id
        User user = (User) session.getAttribute("users");

        int uId = user.getuId();

        //获取当前时间
        Date date = new Date();
        long a = date.getTime();
        Orders orders = goodsTypeService.findOrdersByMaxId(orderId);
        Date date1 = orders.getOrder_time();
        long b = date1.getTime();
        System.out.println("当前时间减去下单时间等于："+ (a-b));
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm");
        String time = dateFormat.format(new Date(Long.parseLong(String.valueOf(a-b))));
        System.out.println("当前订单时间为："+time);
        int p = 0;
        if(Integer.parseInt(time)>15){
            //将当前订单的状态改为1：表示订单已作废
           goodsTypeService.updateState(1,orderId);
        }else{
            //将当前订单的状态改为2：表示订单已完成
           p =  goodsTypeService.updateState(2,orderId);
        }
        if(p==1){
            map.put("data","SUCCESS");
        }else{
            map.put("data","ERROR");
        }
        FastJson_All.toJson(map,response);
    }
}
