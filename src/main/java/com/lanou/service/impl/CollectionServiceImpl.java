package com.lanou.service.impl;

import com.lanou.dao.CollectionMapper;
import com.lanou.dao.DiZhiMapper;
import com.lanou.entity.DiZhi;
import com.lanou.entity.Goods;
import com.lanou.service.CollectionService;
import com.lanou.service.DiZhiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.java2d.opengl.GLXSurfaceData;

import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
@Service("collectionService")
public class CollectionServiceImpl implements CollectionService{
    @Autowired
    private CollectionMapper collectionMapper;
    public List<Goods> findCollection(Integer user_id){
        return collectionMapper.findCollection(user_id);
    }
    public  Integer finduser_id(Integer goods_id,Integer user_id){
        return collectionMapper.finduser_id(goods_id,user_id);
    }

    public  boolean addCollGoods(Integer goods_id,Integer user_id){
        return collectionMapper.addCollGoods(goods_id,user_id);
    }
    public  boolean deleteCollection(Integer[] goods_id,Integer user_id){
         boolean result = collectionMapper.deleteCollection(goods_id,user_id);

         return result;
    }
    public void deleteCollection1(Integer goods_id ,Integer user_id){
        collectionMapper.deleteCollection1(goods_id,user_id);
    }
}
