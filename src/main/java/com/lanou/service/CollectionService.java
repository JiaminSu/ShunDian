package com.lanou.service;

import com.lanou.entity.Goods;
import com.lanou.entity.User;

import java.util.List;

public interface CollectionService {

	public List<Goods> findCollection(Integer user_id);
	public  Integer finduser_id(Integer goods_id,Integer user_id);
	public  boolean addCollGoods(Integer goods_id,Integer user_id);
	public  boolean deleteCollection(Integer[] goods_id,Integer user_id);
	public void deleteCollection1(Integer goods_id ,Integer user_id);
}
