package com.lanou.service;

import com.lanou.entity.*;

import java.util.List;

public interface ShopGoodsService {
//	遍历所有的商品 分页
	public Double AllfindShopGoodss();
	public List<ShopGoods> findShopGoodss(Integer page);
	public void insertShopGoodss(String GoodsName,Integer ShopCard,double GoodsPrice,String  GoodsImageUrl );
	public void updateShopGoodss(String GoodsName,Integer ShopCard,double GoodsPrice,Integer GoodsId);
	public void deleteShopGoodss(Integer GoodsId);
	public List<ShopGoods> huishou(Integer page);
	public void huanyuan2(Integer GoodsId);
}
