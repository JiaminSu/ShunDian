package com.lanou.dao;

import com.lanou.entity.DiZhi;
import com.lanou.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionMapper {

	public List<Goods> findCollection(Integer user_id);
	public  Integer finduser_id(Integer goods_id,Integer user_id);
	public  boolean addCollGoods(Integer goods_id,Integer user_id);
	public  boolean deleteCollection(@Param("goods_id") Integer[] goods_id,@Param("user_id") Integer user_id);
	public void deleteCollection1(Integer goods_id ,Integer user_id);
}
