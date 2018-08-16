package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.entity.*;
import com.lanou.service.GalleryService;
import com.lanou.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/")
public class GalleryController {
    @Autowired
    private GalleryService galleryService;

    // ==============================================================
    // gallery
    @RequestMapping("/gallery")
    //@ResponseBody
    public void findss(Integer id, HttpServletResponse response,Integer page) {

        Map<String, Object> map = new HashMap<String, Object>();
        int leftId = 0;
        //请求商品分类页部分数据
        String leftName = null;
        String rightName = null;
        int aId =0;
        int type = galleryService.Judge(id);
        List price = galleryService.rightPrice();
        if (type == 1) {
            //     找一级标题
            List<GoodsType> OneName = galleryService.chazhao1(id);
            // ==============================================
            List<GoodsType> allYiJi = galleryService.AllYiJi(id);
            List finder =  galleryService.finder();
            List finder1 = galleryService.finder1(id);
            List finder2 = galleryService.finder2(id);
            OneName.get(0).setGoodsTypes(allYiJi);
            if (page==null){
                page =1;
            }
            List<Gallery1> findgoodss = galleryService.findGoodss(26,page);
            Double All = galleryService.AllfindGoodss(26);
            Double page1 =  All/45;
            Double page2 = Math.ceil(page1);
            int page3 = (new   Double(page2)).intValue();
            for (int i = 0;i<findgoodss.size();i++){
               String gUrl =  findgoodss.get(i).getgUrl();
               List<String> AllUrl = new ArrayList();
               AllUrl.add(gUrl);
               int gs_id = findgoodss.get(i).getGs_id();
               List<GoodSmallImage> listgoodsmall =  galleryService.SmallImage(gs_id);
                   if(listgoodsmall.get(0).getSmallUrl1() != null){
                       AllUrl.add(listgoodsmall.get(0).getSmallUrl1());
                   }
                   if(listgoodsmall.get(0).getSmallUrl2() != null){
                       AllUrl.add(listgoodsmall.get(0).getSmallUrl2());
                   }
                   if(listgoodsmall.get(0).getSmallUrl3() != null){
                       AllUrl.add(listgoodsmall.get(0).getSmallUrl3());
                   }
                   findgoodss.get(i).setgImg(AllUrl);
            }

            for (int i = 0; i < finder.size(); i++) {
                List findleftandright = new ArrayList();
                if (i == 0) {
                    for (int j = 0; j < finder1.size(); j++) {
                        rightName = (String) finder1.get(j);
                        aId = (Integer) finder2.get(j);
                        List OneBiao00 =new ArrayList();
                        OneBiao00.add(rightName);
                        OneBiao00.add(aId);
                        findleftandright.add(OneBiao00);


                    }
                }
                if (i == 1) {
                    for (int j = 0; j < galleryService.findright(21).size(); j++) {
                        rightName = galleryService.findright(21).get(j).getRight_name();
                        findleftandright.add(rightName);
                    }
                }
                map.put("One" + i, findleftandright);

            }
            map.put("page",page3);
            map.put("OneBiao", OneName);
            map.put("goods", findgoodss);
            map.put("price", price);
        }
        if (type == 2) {
            //找二级标题以及它的一级标题
//            上一级的aId

            int pid = galleryService.chazhao2(id);
            List<GoodsType> AllYiJi = galleryService.AllYiJi(pid);
            List<GoodsType> AllErJi = galleryService.AllErJi(pid, id);
            List<GoodsType> names = galleryService.chazhao3(pid, id);
             List<GoodsType> list = new ArrayList<GoodsType>();
               names.get(0).setGoodsTypes(AllYiJi);
               names.get(1).setGoodsTypes(AllErJi);
            // ==============================================
            List findsan = galleryService.findsan();
            List findsan1 = galleryService.findsan1(id);
            List finder2 = galleryService.finder2(id);
            List findAllErJi = galleryService.findsan1(pid);
            if (page==null){
                page =1;
            }
            List<Gallery1> findgoodss = galleryService.findGoodss(26,page);
            Double All = galleryService.AllfindGoodss(26);
            Double page1 =  All/45;
            Double page2 = Math.ceil(page1);
            int page3 = (new   Double(page2)).intValue();
            for (int i = 0;i<findgoodss.size();i++){
                String gUrl =  findgoodss.get(i).getgUrl();
                List<String> AllUrl = new ArrayList();
                AllUrl.add(gUrl);
                int gs_id = findgoodss.get(i).getGs_id();
                List<GoodSmallImage> listgoodsmall =  galleryService.SmallImage(gs_id);
                if(listgoodsmall.get(0).getSmallUrl1() != null){
                    AllUrl.add(listgoodsmall.get(0).getSmallUrl1());
                }
                if(listgoodsmall.get(0).getSmallUrl2() != null){
                    AllUrl.add(listgoodsmall.get(0).getSmallUrl2());
                }
                if(listgoodsmall.get(0).getSmallUrl3() != null){
                    AllUrl.add(listgoodsmall.get(0).getSmallUrl3());
                }
                findgoodss.get(i).setgImg(AllUrl);
            }
            for (int i = 0; i < findsan.size(); i++) {
                List findleftandright = new ArrayList();
                if (i == 0) {
                    for (int j = 0; j < findsan1.size(); j++) {
                        rightName = (String) findsan1.get(j);
                        aId = (Integer) finder2.get(j);
                        List OneBiao00 =new ArrayList();
                        OneBiao00.add(rightName);
                        OneBiao00.add(aId);
                        findleftandright.add(OneBiao00);
                    }
                }
                if (i == 1) {
                    for (int j = 0; j < galleryService.findright(21).size(); j++) {
                        rightName = galleryService.findright(21).get(j).getRight_name();
                        findleftandright.add(rightName);
                    }
                }
                map.put("One" + i, findleftandright);
            }
            map.put("page",page3);
            map.put("OneBiao", names);
            map.put("goods", findgoodss);
            map.put("price", price);

        }
        if (type == 3) {
            //找三级标题以及它的一，二级标题
            //            上一级的aId
            int pid = galleryService.chazhao2(id);
            //            上上一级的aId
            int ppid = galleryService.chazhao2(pid);
            List<GoodsType> AllYiJi = galleryService.AllYiJi(ppid);
            List<GoodsType> AllErJi = galleryService.AllErJi(ppid, pid);
            List<GoodsType> AllSanJi = galleryService.AllSanJi(pid, id);
            List<GoodsType> namess = galleryService.chazhao4(ppid, pid, id);
            namess.get(0).setGoodsTypes(AllYiJi);
            namess.get(1).setGoodsTypes(AllErJi);
            namess.get(2).setGoodsTypes(AllSanJi);
            // ==============================================
            if (page==null){
                page =1;
            }
            List<Gallery1> findgoodss = new ArrayList();
            if(id!=6&&id!=26){
                findgoodss = galleryService.findGoodss(6,page);
            }else{
                findgoodss = galleryService.findGoodss(id,page);
            }
            Double All = galleryService.AllfindGoodss(id);
            Double page1 =  All/45;
            Double page2 = Math.ceil(page1);
            int page3 = (new   Double(page2)).intValue();
            for (int i = 0;i<findgoodss.size();i++){
                String gUrl =  findgoodss.get(i).getgUrl();
                List<String> AllUrl = new ArrayList();
                AllUrl.add(gUrl);
                int gs_id = findgoodss.get(i).getGs_id();
                List<GoodSmallImage> listgoodsmall =  galleryService.SmallImage(gs_id);
                if(listgoodsmall.get(0).getSmallUrl1() != null){
                    AllUrl.add(listgoodsmall.get(0).getSmallUrl1());
                }
                if(listgoodsmall.get(0).getSmallUrl2() != null){
                    AllUrl.add(listgoodsmall.get(0).getSmallUrl2());
                }
                if(listgoodsmall.get(0).getSmallUrl3() != null){
                    AllUrl.add(listgoodsmall.get(0).getSmallUrl3());
                }
                findgoodss.get(i).setgImg(AllUrl);
            }
//            for (int i = 0; i < findAllLeft.size(); i++) {
//                leftId = findAllLeft.get(i).getLeft_id();
//                for (int j = 0; j < galleryService.findright(leftId).size(); j++) {
//                    rightName = galleryService.findright(leftId).get(j).getRight_name();
//                    findleftandright.add(rightName);
//                    System.out.println(rightName);
//
//                }
//            }
            List finder2 = galleryService.finder2(2);
            int a = (int) (11+Math.random()*(16-10+1)) ;
            int b = (int) (11+Math.random()*(16-10+1));
            System.out.println(a);
            System.out.println(b);

            List random = galleryService.findFenLeiBiao(a, b);
            for (int i = 0; i < 2; i++) {
                List findleftandright = new ArrayList();
                if (i == 0) {
                    for (int j = 0; j < random.size(); j++) {
                        rightName = (String) random.get(j);
                        aId = (Integer) finder2.get(j);
                        List OneBiao00 =new ArrayList();
                        OneBiao00.add(rightName);
                        OneBiao00.add(aId);
                        findleftandright.add(OneBiao00);
                    }
                }
                if (i == 1) {
                    for (int j = 0; j < galleryService.findright(2).size(); j++) {
                        rightName = galleryService.findright(2).get(j).getRight_name();
                        findleftandright.add(rightName);
                    }
                }
                map.put("One" + i, findleftandright);

            }
            map.put("page",page3);
            map.put("OneBiao", namess);
            map.put("goods", findgoodss);
            map.put("price", price);

        }
        FastJson_All.toJson(map,response);
        //return map;
    }

        //    ==============================================================
//    查找价格区间 1
        @RequestMapping("/price")
       // @ResponseBody
        public void findPrice (Integer firstPrice, Integer secondPrice,HttpServletResponse response,Integer page){
            Map<String, Object> map = new HashMap<String, Object>();
            if (page==null){
                page =1;
            }
            Double All = galleryService.AllfindByPrice(firstPrice, secondPrice);
            Double page1 =  All/45;
            Double page2 = Math.ceil(page1);
            int page3 = (new   Double(page2)).intValue();
            List<Gallery1> findByPrice = galleryService.findByPrice(firstPrice, secondPrice,page);
            for (int i = 0;i<findByPrice.size();i++){
                String gUrl =  findByPrice.get(i).getgUrl();
                List<String> AllUrl = new ArrayList();
                AllUrl.add(gUrl);
                int gs_id = findByPrice.get(i).getGs_id();
                List<GoodSmallImage> listgoodsmall =  galleryService.SmallImage(gs_id);
                if(listgoodsmall.get(0).getSmallUrl1() != null){
                    AllUrl.add(listgoodsmall.get(0).getSmallUrl1());
                }
                if(listgoodsmall.get(0).getSmallUrl2() != null){
                    AllUrl.add(listgoodsmall.get(0).getSmallUrl2());
                }
                if(listgoodsmall.get(0).getSmallUrl3() != null){
                    AllUrl.add(listgoodsmall.get(0).getSmallUrl3());
                }
                findByPrice.get(i).setgImg(AllUrl);
            }
            map.put("page",page3);
            map.put("ByPrice", findByPrice);

            FastJson_All.toJson(map,response);
            //return map;

    }
        // ==============================================================
        //综合查询 1
        @RequestMapping("/zonhe")
        // @ResponseBody
        public void ByZonHe(HttpServletResponse response,Integer page){
            Map<String, Object> map = new HashMap<String, Object>();
            if (page==null){
                page =1;
            }
            Double All = galleryService.AllByZonHe();
            Double page1 =  All/45;
            Double page2 = Math.ceil(page1);
            int page3 = (new   Double(page2)).intValue();
            List<Gallery1> ZongHe = galleryService.ByZonHe(page);
            for (int i = 0;i<ZongHe.size();i++){
                String gUrl =  ZongHe.get(i).getgUrl();
                List<String> AllUrl = new ArrayList();
                AllUrl.add(gUrl);
                int gs_id = ZongHe.get(i).getGs_id();
                List<GoodSmallImage> listgoodsmall =  galleryService.SmallImage(gs_id);
                if(listgoodsmall.get(0).getSmallUrl1() != null){
                    AllUrl.add(listgoodsmall.get(0).getSmallUrl1());
                }
                if(listgoodsmall.get(0).getSmallUrl2() != null){
                    AllUrl.add(listgoodsmall.get(0).getSmallUrl2());
                }
                if(listgoodsmall.get(0).getSmallUrl3() != null){
                    AllUrl.add(listgoodsmall.get(0).getSmallUrl3());
                }
                ZongHe.get(i).setgImg(AllUrl);
            }
            map.put("page",page3);
            map.put("ZonHe", ZongHe);
            FastJson_All.toJson(map,response);

        }
        // ==============================================================
        //价格降序 1
        @RequestMapping("/jiagejiang")
        // @ResponseBody
        public void ByJiaGeJiang (HttpServletResponse response,Integer page){
            Map<String, Object> map = new HashMap<String, Object>();
            if (page==null){
                page =1;
            }
            Double All = galleryService.AllByJiaGeJiang();
            Double page1 =  All/45;
            Double page2 = Math.ceil(page1);
            int page3 = (new   Double(page2)).intValue();
            List<Gallery1> JiaGeJiang = galleryService.ByJiaGeJiang(page);
            System.out.println(JiaGeJiang.get(0));
            for (int i = 0;i<JiaGeJiang.size();i++){
                String gUrl =  JiaGeJiang.get(i).getgUrl();
                List<String> AllUrl = new ArrayList();
                AllUrl.add(gUrl);
                int gs_id = JiaGeJiang.get(i).getGs_id();
                System.out.println();
                List<GoodSmallImage> listgoodsmall =  galleryService.SmallImage(gs_id);
                System.out.println("dasdasdasdasdsadasd"+listgoodsmall);
                if(listgoodsmall.get(0).getSmallUrl1() != null){
                    AllUrl.add(listgoodsmall.get(0).getSmallUrl1());
                }
                if(listgoodsmall.get(0).getSmallUrl2() != null){
                    AllUrl.add(listgoodsmall.get(0).getSmallUrl2());
                }
                if(listgoodsmall.get(0).getSmallUrl3() != null){
                    AllUrl.add(listgoodsmall.get(0).getSmallUrl3());
                }
                JiaGeJiang.get(i).setgImg(AllUrl);
            }
            map.put("page",page3);
            map.put("JiaGeJiang", JiaGeJiang);
            FastJson_All.toJson(map,response);
        }
    // ==============================================================
    //价格升序 1
    @RequestMapping("/jiagesheng")
    // @ResponseBody
    public void ByJiaGeSheng (HttpServletResponse response,Integer page){
        Map<String, Object> map = new HashMap<String, Object>();
        if (page==null){
            page =1;
        }
        Double All = galleryService.AllByJiaGeSheng();
        Double page1 =  All/45;
        Double page2 = Math.ceil(page1);
        int page3 = (new   Double(page2)).intValue();
        List<Gallery1> JiaGeSheng = galleryService.ByJiaGeSheng(page);
        for (int i = 0;i<JiaGeSheng.size();i++){
            String gUrl =  JiaGeSheng.get(i).getgUrl();
            List<String> AllUrl = new ArrayList();
            AllUrl.add(gUrl);
            int gs_id = JiaGeSheng.get(i).getGs_id();
            List<GoodSmallImage> listgoodsmall =  galleryService.SmallImage(gs_id);

            if(listgoodsmall.get(0).getSmallUrl1() != null){
                AllUrl.add(listgoodsmall.get(0).getSmallUrl1());
            }
            if(listgoodsmall.get(0).getSmallUrl2() != null){
                AllUrl.add(listgoodsmall.get(0).getSmallUrl2());
            }
            if(listgoodsmall.get(0).getSmallUrl3() != null){
                AllUrl.add(listgoodsmall.get(0).getSmallUrl3());
            }
            JiaGeSheng.get(i).setgImg(AllUrl);
        }
        map.put("page",page3);
        map.put("JiaGeSheng", JiaGeSheng);
        FastJson_All.toJson(map,response);

    }
    // ==============================================================
    //销量查询 1
    @RequestMapping("/xiaoliang")
    // @ResponseBody
    public void ByXiaoLiang (HttpServletResponse response,Integer page){
        Map<String, Object> map = new HashMap<String, Object>();
        if (page==null){
            page =1;
        }
        Double All = galleryService.AllByXiaoLiang();
        Double page1 =  All/45;
        Double page2 = Math.ceil(page1);
        int page3 = (new   Double(page2)).intValue();
        List<Gallery1> XiaoLiang = galleryService.ByXiaoLiang(page);
        for (int i = 0;i<XiaoLiang.size();i++){
            String gUrl =  XiaoLiang.get(i).getgUrl();
            List<String> AllUrl = new ArrayList();
            AllUrl.add(gUrl);
            int gs_id = XiaoLiang.get(i).getGs_id();
            List<GoodSmallImage> listgoodsmall =  galleryService.SmallImage(gs_id);
            if(listgoodsmall.get(0).getSmallUrl1() != null){
                AllUrl.add(listgoodsmall.get(0).getSmallUrl1());
            }
            if(listgoodsmall.get(0).getSmallUrl2() != null){
                AllUrl.add(listgoodsmall.get(0).getSmallUrl2());
            }
            if(listgoodsmall.get(0).getSmallUrl3() != null){
                AllUrl.add(listgoodsmall.get(0).getSmallUrl3());
            }
            XiaoLiang.get(i).setgImg(AllUrl);
        }
        map.put("page",page3);
        map.put("XiaoLiang", XiaoLiang);
        FastJson_All.toJson(map,response);
    }
    // ==============================================================
    //xinpin查询 1
    @RequestMapping("/xinpin")
    // @ResponseBody
    public void ByXinPin (HttpServletResponse response,Integer page){
        Map<String, Object> map = new HashMap<String, Object>();
        if (page==null){
            page =1;
        }
        Double All = galleryService.AllByXinPin();
        Double page1 =  All/45;
        Double page2 = Math.ceil(page1);
        int page3 = (new   Double(page2)).intValue();
        List<Gallery1> XinPin = galleryService.ByXinPin(page);
        for (int i = 0;i<XinPin.size();i++){
            String gUrl =  XinPin.get(i).getgUrl();
            List<String> AllUrl = new ArrayList();
            AllUrl.add(gUrl);
            int gs_id = XinPin.get(i).getGs_id();
            List<GoodSmallImage> listgoodsmall =  galleryService.SmallImage(gs_id);
            if(listgoodsmall.get(0).getSmallUrl1() != null){
                AllUrl.add(listgoodsmall.get(0).getSmallUrl1());
            }
            if(listgoodsmall.get(0).getSmallUrl2() != null){
                AllUrl.add(listgoodsmall.get(0).getSmallUrl2());
            }
            if(listgoodsmall.get(0).getSmallUrl3() != null){
                AllUrl.add(listgoodsmall.get(0).getSmallUrl3());
            }
            XinPin.get(i).setgImg(AllUrl);
        }
        map.put("page",page3);
        map.put("XinPin", XinPin);
        FastJson_All.toJson(map,response);
    }
    // ==============================================================
//    @RequestMapping("/LikeSearch")
//    // @ResponseBody
//    public void ByLike (HttpServletResponse response,String like,Integer page){
//        Map<String, Object> map = new HashMap<String, Object>();
//        if (page==null){
//            page =1;
//        }
//        Double All = galleryService.AllByLike();
//        Double page1 =  All/45;
//        Double page2 = Math.ceil(page1);
//        int page3 = (new   Double(page2)).intValue();
//        if (page3==0){
//            page3=1;
//        }
//        List<Gallery1> SelectByLike = galleryService.ByLike(like,page);
//        for (int i = 0;i<SelectByLike.size();i++){
//            String gUrl = SelectByLike.get(i).getgUrl();
//            List<String> AllUrl = new ArrayList();
//            AllUrl.add(gUrl);
//            int gs_id = SelectByLike.get(i).getGs_id();
//            List<GoodSmallImage> listgoodsmall =  galleryService.SmallImage(gs_id);
//            if(listgoodsmall.get(0).getSmallUrl1() != null){
//                AllUrl.add(listgoodsmall.get(0).getSmallUrl1());
//            }
//            if(listgoodsmall.get(0).getSmallUrl2() != null){
//                AllUrl.add(listgoodsmall.get(0).getSmallUrl2());
//            }
//            if(listgoodsmall.get(0).getSmallUrl3() != null){
//                AllUrl.add(listgoodsmall.get(0).getSmallUrl3());
//            }
//            SelectByLike.get(i).setgImg(AllUrl);
//        }
//        map.put("page",page3);
//        map.put("ByLike", SelectByLike);
//        FastJson_All.toJson(map,response);
//    }
    // ==============================================================
    @RequestMapping("/LikeSearch")
    // @ResponseBody
    public void ByLike (HttpServletResponse response,String like,Integer page){
        Map<String, Object> map = new HashMap<String, Object>();
        if (page==null){
            page =1;
        }
        Double All = galleryService.AllByLike();
        Double page1 =  All/45;
        Double page2 = Math.ceil(page1);
        int page3 = (new   Double(page2)).intValue();
        if (page3==0){
            page3=1;
        }
        List<Gallery1> SelectByLike = galleryService.ByLike(like,page);
        for (int i = 0;i<SelectByLike.size();i++){
            String gUrl = SelectByLike.get(i).getgUrl();
            List<String> AllUrl = new ArrayList();
            AllUrl.add(gUrl);
            int gs_id = SelectByLike.get(i).getGs_id();
            List<GoodSmallImage> listgoodsmall =  galleryService.SmallImage(gs_id);
            if(listgoodsmall.get(0).getSmallUrl1() != null){
                AllUrl.add(listgoodsmall.get(0).getSmallUrl1());
            }
            if(listgoodsmall.get(0).getSmallUrl2() != null){
                AllUrl.add(listgoodsmall.get(0).getSmallUrl2());
            }
            if(listgoodsmall.get(0).getSmallUrl3() != null){
                AllUrl.add(listgoodsmall.get(0).getSmallUrl3());
            }
            SelectByLike.get(i).setgImg(AllUrl);
        }
        List<GoodsType> list1 = new ArrayList<GoodsType>();
        for (int i=0;i<SelectByLike.size();i++){
            list1  = galleryService.chazhao3(SelectByLike.get(i).getAll_id(),1);
        }
        System.out.println(list1);
        map.put("Like",list1);
        FastJson_All.toJson(map,response);
    }
}

