package com.lanou.service.impl;

import com.lanou.dao.GoodsTypeMapper;
import com.lanou.dao.ShopGoodsMapper;
import com.lanou.entity.*;
import com.lanou.service.GoodsTypeService;
import com.lanou.service.ShopGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shopGoodsService")
public class ShopGoodsServiceImpl implements ShopGoodsService{

	@Autowired
	private ShopGoodsMapper shopGoodsMapper;
	//	遍历所有的商品 分页
	public Double AllfindShopGoodss(){
		return  shopGoodsMapper.AllfindShopGoodss();
	}
	public List<ShopGoods> findShopGoodss(Integer page){
		page=(page-1)*20;
		return  shopGoodsMapper.findShopGoodss(page);
	}
	public void insertShopGoodss(String GoodsName,Integer ShopCard,double GoodsPrice,String  GoodsImageUrl ){
		 shopGoodsMapper.insertShopGoodss(GoodsName,ShopCard,GoodsPrice,GoodsImageUrl);
	}
	public void updateShopGoodss(String GoodsName,Integer ShopCard,double GoodsPrice,Integer GoodsId){
		shopGoodsMapper.updateShopGoodss(GoodsName,ShopCard,GoodsPrice,GoodsId);
	}
	public void deleteShopGoodss(Integer GoodsId){
		shopGoodsMapper.deleteShopGoodss(GoodsId);
	}
	public List<ShopGoods> huishou(Integer page){
		page=(page-1)*20;
		return  shopGoodsMapper.huishou(page);
	}
	public void huanyuan2(Integer GoodsId){
		shopGoodsMapper.huanyuan2(GoodsId);
	}

}
