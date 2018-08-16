package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.entity.*;
import com.lanou.service.CommentService;
import com.lanou.service.GalleryService;
import com.lanou.service.GoodsTypeService;
import com.lanou.service.ShopGoodsService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class ShopGoodsController {
    @Autowired
    private ShopGoodsService shopGoodsService;
    @Autowired
    private GoodsTypeService goodsTypeService;
    @Autowired
    private CommentService commentService;
//     ==============================================================
    @RequestMapping("goodsList")
    //@ResponseBody
    public void ListGoods(HttpServletResponse response,Integer page) {
        Map<String, Object> map = new HashMap<String, Object>();
        //遍历出所有的商品
//        准备做根据其放进来的Num数来保证每一页多少个
//        if (num==null||num<=6){
//            num=6;
//        }
        if (page==null){
            page =1;
        }
        Double All = shopGoodsService.AllfindShopGoodss();
        Double page1 =  All/20;
        Double page2 = Math.ceil(page1);
        int page3 = (new   Double(page2)).intValue();
        if (page3==0){
            page3=1;
        }
        List<ShopGoods> ListGoods = shopGoodsService.findShopGoodss(page);
        for (int i=0;i<ListGoods.size();i++){
            if ( ListGoods.get(i).getShopCard()==null){
                Integer id =  ListGoods.get(i).getGoodsId();
                id=id+60022000;
                ListGoods.get(i).setShopCard(id);
            }

        }

            map.put("Allpage",page3);
            map.put("ListGoods", ListGoods);
          FastJson_All.toJson(map,response);
        }
//            ==============================================================
//    商品的增
        @RequestMapping("insertshopgoods")
        //@ResponseBody
        public void insertshopgoods(@RequestParam("myFile") MultipartFile file,HttpServletResponse response, String GoodsName, Integer ShopCard, double GoodsPrice) {
            Map<String, Object> map = new HashMap<String, Object>();
            String url = goodsTypeService.upload();
            String[] ss = url.split("\\/");
            String[] ss1 = ss[1].split("\\.");
            System.out.println(ss1);
            Integer i = Integer.parseInt(ss1[0]);
            i=i+1;
            File files = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/Goods"+i+".jpg");
            String GoodsImageUrl= "GoodsLunbotu/"+i+".jpg";
            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(),files);
            } catch (IOException e) {
                e.printStackTrace();
            }
           shopGoodsService.insertShopGoodss(GoodsName,ShopCard,GoodsPrice,GoodsImageUrl);
            map.put("result","true");
            FastJson_All.toJson(map,response);
        }
    //    ==============================================================
    //    商品的改
    @RequestMapping("updateshopgoods")
    //@ResponseBody
    public void updateshopgoods(@RequestParam("myFile") MultipartFile file,HttpServletResponse response, String GoodsName, Integer ShopCard, double GoodsPrice,Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (file!=null){
            File files = new File("/usr/local/apache-tomcat-7.0.77/webapps/ShunDian/resource/views/lunbotu/Goods"+id+".jpg");
            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(),files);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        shopGoodsService.updateShopGoodss(GoodsName,ShopCard,GoodsPrice,id);
        map.put("result","true");
        FastJson_All.toJson(map,response);
    }
    //    ==============================================================
    //    商品的删
    @RequestMapping("deleteshopgoods")
    //@ResponseBody
    public void deleteshopgoods(HttpServletResponse response,Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        shopGoodsService.deleteShopGoodss(id);
        map.put("result","true");
        FastJson_All.toJson(map,response);
    }
    //    ==============================================================
    //  回收站
    @RequestMapping("huishou")
    //@ResponseBody
    public void huishou(HttpServletResponse response,Integer page) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (page==null){
            page =1;
        }
        Double All = shopGoodsService.AllfindShopGoodss();
        Double page1 =  All/20;
        Double page2 = Math.ceil(page1);
        int page3 = (new   Double(page2)).intValue();
        if (page3==0){
            page3=1;
        }
        List<ShopGoods> ListGood = shopGoodsService.huishou(page);
        for (int i=0;i<ListGood.size();i++){
            if ( ListGood.get(i).getShopCard()==null){
                Integer id =  ListGood.get(i).getGoodsId();
                id=id+60022000;
                ListGood.get(i).setShopCard(id);
            }

        }

        map.put("Allpage",page3);
        map.put("ListGood", ListGood);
        FastJson_All.toJson(map,response);
    }
    //    ==============================================================
    //  回收站还原
    @RequestMapping("huanyuan2")
    //@ResponseBody
    public void huanyuan2(HttpServletResponse response,Integer GoodsId) {
        Map<String, Object> map = new HashMap<String, Object>();
        shopGoodsService.huanyuan2(GoodsId);
        map.put("result", true);
        FastJson_All.toJson(map,response);
        }



    //    评论
    @RequestMapping("pinglun")
    //@ResponseBody
    public void pinglun(HttpServletResponse response,Integer page) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (page==null){
            page =1;
        }
        Double All = shopGoodsService.AllfindShopGoodss();
        Double page1 =  All/20;
        Double page2 = Math.ceil(page1);
        int page3 = (new   Double(page2)).intValue();
        if (page3==0){
            page3=1;
        }
        List  AllPinglun = new ArrayList();
        List<Comments> Listping = commentService.pinglun(page);
        for (int i=0;i<Listping.size();i++){
            List pinglun = new ArrayList();
            List<User_Info>  user =  goodsTypeService.findUser_Info(Listping.get(i).getUser_id());
            String uname = user.get(0).getuName();
            pinglun.add(Listping.get(i).getcId());
            pinglun.add(uname);
            pinglun.add(Listping.get(i).getContent());
            AllPinglun.add(pinglun);
        }
        map.put("Allpage",page3);
        map.put("AllPinglun",AllPinglun);
        FastJson_All.toJson(map,response);

    }
    //    ==============================================================
//    //  评论删除
    @RequestMapping("PLdelete")
    //@ResponseBody
    public void PLdelete(HttpServletResponse response,Integer cId) {
        Map<String, Object> map = new HashMap<String, Object>();
        commentService.PLdelete(cId);
        map.put("result", true);
        FastJson_All.toJson(map,response);
    }
//    //    评论




}

