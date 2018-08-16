package com.lanou.service.impl;

import com.lanou.dao.GalleryMapper;
import com.lanou.dao.GoodsTypeMapper;
import com.lanou.entity.*;
import com.lanou.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("galleryService")
public class galleryServiceImpl implements GalleryService{
    @Autowired
    private GalleryMapper galleryMapper;

    public int  Judge(int all_id){
        return  galleryMapper.Judge(all_id);
    }
    public List finder(){
        return  galleryMapper.finder();
    }
    public List<GoodsType> finder1(Integer all_id){
        return galleryMapper.finder1(all_id);
    }
    public List<GoodsType> finder2(Integer all_id){
        return  galleryMapper.finder2(all_id);
    }
    public List findsan(){
        return  galleryMapper.findsan();
    }
    public List findsan1(Integer all_id){
        return  galleryMapper.findsan1(all_id);
    }


    public  List<GoodsType> AllYiJi(Integer id){
        return  galleryMapper.AllYiJi(id);
    }
    public  List<GoodsType> AllErJi(Integer id,Integer pid){
        return  galleryMapper.AllErJi(id,pid);
    }
    public  List<GoodsType> AllSanJi(Integer pid,Integer id){
          return  galleryMapper.AllSanJi(pid,id);
    }
    public List<All_Left> findleft1(Integer all_id){
        return galleryMapper.findleft1(all_id);
    }
    public List<Lefts> findleft2(Integer leftId){
        return galleryMapper.findleft2(leftId);
    }
    public List<Rights> findright(Integer leftId){
        return galleryMapper.findright(leftId);
    }
    public Double AllfindGoodss(Integer all_id){
        return galleryMapper.AllfindGoodss(all_id);
    }
    public List<Gallery1> findGoodss(Integer all_id,Integer page){
        page=(page-1)*45;
        return  galleryMapper.findGoodss(all_id,page);
    }
    public List findFenLeiBiao (Integer a ,Integer b){
        return  galleryMapper.findFenLeiBiao(a , b);
    }

    //    查找小图片
    public List<GoodSmallImage> SmallImage(Integer gs_id){
        return  galleryMapper.SmallImage(gs_id);
    }
    //商品分类
    public List<GoodsType> chazhao1(Integer all_id){
        return  galleryMapper.chazhao1(all_id);
    }

    public int chazhao2(Integer all_id){
        return  galleryMapper.chazhao2(all_id);
    }

    public List<GoodsType> chazhao3(Integer pid , Integer id){
        return galleryMapper.chazhao3(pid,id);
    }

    public List<GoodsType> chazhao4(Integer pid,Integer ppid,Integer id){
        return galleryMapper.chazhao4(ppid, pid, id);
    }

    //	价格区间
    public List<String> rightPrice(){
        return galleryMapper.rightPrice();
    }
    public Double AllfindByPrice(Integer firstPrice , Integer secondPrice){ return  galleryMapper.AllfindByPrice(firstPrice , secondPrice);}
    public List<Gallery1> findByPrice(Integer firstPrice , Integer secondPrice,Integer page){
        page=(page-1)*45;
        return  galleryMapper.findByPrice(firstPrice , secondPrice,page);
    }
    //    综合查询
    public  Double AllByZonHe(){
        return  galleryMapper.AllByZonHe();
    }
    public  List<Gallery1> ByZonHe(Integer page){
        page=(page-1)*45;
        return  galleryMapper.ByZonHe(page);
    }
    //    价格排序
    public  Double AllByJiaGeJiang(){
        return  galleryMapper.AllByJiaGeJiang();
    }
    public  List<Gallery1> ByJiaGeJiang(Integer page){
        return   galleryMapper.ByJiaGeJiang(page);
    }
    //    价格升序
    public  Double AllByJiaGeSheng(){
        return  galleryMapper.AllByJiaGeSheng();
    }
    public  List<Gallery1> ByJiaGeSheng(Integer page){
        return   galleryMapper.ByJiaGeSheng(page);
    }
    //    销量查询
    public  Double AllByXiaoLiang(){
        return  galleryMapper.AllByXiaoLiang();
    }
    public  List<Gallery1> ByXiaoLiang(Integer page){
        return  galleryMapper.ByXiaoLiang(page);
    }
    //    新品查询
    public  Double AllByXinPin(){
        return  galleryMapper.AllByXinPin();
    }
    public  List<Gallery1> ByXinPin(Integer page){
        return  galleryMapper.ByXinPin(page);
    }
    //   模糊查询
    public  Double AllByLike(){
        return galleryMapper.AllByLike();
    }
    public  List<Gallery1> ByLike(String like ,Integer page){
        like="%"+like+"%";
        page=(page-1)*45;
        return  galleryMapper.ByLike(like,page);
    }
}
