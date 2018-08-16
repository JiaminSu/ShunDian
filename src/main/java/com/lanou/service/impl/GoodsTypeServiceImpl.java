package com.lanou.service.impl;

import com.lanou.dao.GoodsTypeMapper;
import com.lanou.entity.*;
import com.lanou.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsTypeService")
public class GoodsTypeServiceImpl implements GoodsTypeService{

	@Autowired
	private GoodsTypeMapper goodsTypeMapper;

	public List<GoodsType> find9Goods3Type() {
		return goodsTypeMapper.find9Goods3Type();
	}

	public List<GoodsType> findGoods1Type() {
		return goodsTypeMapper.findGoods1Type();
	}

	public List<Floor> findFloor() {
		return goodsTypeMapper.findFloor();
	}

	public List<Goods> find8Goods() {
		return goodsTypeMapper.find8Goods();
	}

	public List<Goods> find5Goods(){
		return  goodsTypeMapper.find5Goods();
	}

	public List<GoodsType> findGoodsType(int aId) {
		return goodsTypeMapper.findGoodsType(aId);
	}

	public List<Floor>  findFloorX(){
		return  goodsTypeMapper.findFloorX();
	}

	//对应楼层的实现方法
	public List<FloorImage> findFloorImage() {
		return goodsTypeMapper.findFloorImage();
	}

	//商品详情页

	public List<Goods> findGoodsById(int id) {
		return goodsTypeMapper.findGoodsById(id);
	}

	public List<GoodsImage> findGoodsImage(int id) {
		return goodsTypeMapper.findGoodsImage(id);
	}

	public List<Goods> findGoodsByAll_id(int All_id) {
		return goodsTypeMapper.findGoodsByAll_id(All_id);
	}

	public List<GoodsImage> findGoodsImage1(int id) {
		return goodsTypeMapper.findGoodsImage1(id);
	}

	public List<Comments> findComments(int gId) {
		return goodsTypeMapper.findComments(gId);
	}

	public List<User_Info> findUser_Info(int uId) {
		return goodsTypeMapper.findUser_Info(uId);
	}
	//	添加历史记录
	public boolean  insert1(String userName,String goodsName,String goodsImage,Double goodsPrice){
		return  goodsTypeMapper.insert1(userName,goodsName,goodsImage,goodsPrice);
	}
//	调出历史记录
      public List<History> findHistory(String userName){
		return  goodsTypeMapper.findHistory(userName);
	  }
//    判断有无
	  public int findNull(String goodsName){
      	return  goodsTypeMapper.findNull(goodsName);
	  }

	//地址三级联动模块
	public DiZhi_Info findDiZhicityid(int cityid) {
		return goodsTypeMapper.findDiZhicityid(cityid);
	}

	public List<DiZhi_Info> selectDiZhiChildrenByParentId(int cityid) {
		return goodsTypeMapper.selectDiZhiChildrenByParentId(cityid);
	}


	public List<GoodsType> find1(Goods good1 ,Integer aId){
		return goodsTypeMapper.find1(good1,aId);
	}
	//查询aId
	public List<GoodsType> findfenlei(Integer aId){
		return  goodsTypeMapper.findfenlei(aId);
	}

	//	=====
	public List findLun(){
		return  goodsTypeMapper.findLun();
	}
	//	找到三张图
	public List findIndexSan(Integer aId){
		return  goodsTypeMapper.findIndexSan(aId);
	}


	//购物车模块
	public void updateShopCar1(int cout,Double sum,int goods_id){
		goodsTypeMapper.updateShopCar1(cout,sum,goods_id);
	}

	public ShopCar findShopCargoods_id(Integer goods_id) {
		return goodsTypeMapper.findShopCargoods_id(goods_id);
	}

	//添加商品
	public void updateShopCar(int gId, String gName, Double price, int count, Double sum,String goods_url) {
		goodsTypeMapper.updateShopCar(gId,gName,price,count,sum,goods_url);
	}

	//删除商品
	public void deleteShopCar(int id) {
		goodsTypeMapper.deleteShopCar(id);
	}

	//点击侧边栏模块
	public List<ShopCar> findShopCar(){

		return goodsTypeMapper.findShopCar();
	}

	//添加订单模块


	public void addOrders(String order_time, int address_sId, double totalMoney, int user_id) {
		goodsTypeMapper.addOrders(order_time,address_sId,totalMoney,user_id);
	}

	public Integer findMaxOrders() {
		return goodsTypeMapper.findMaxOrders();
	}

	public void addOrdersGoods(int goods_id, int goods_num, int orders_id) {
		goodsTypeMapper.addOrdersGoods(goods_id,goods_num,orders_id);
	}

	//查询订单模块


	public Orders findOrdersByMaxId(int maxId) {
		return goodsTypeMapper.findOrdersByMaxId(maxId);
	}

	public List<Orders_goods> findOrdersGoodsByorders_id(int orders_id) {
		return goodsTypeMapper.findOrdersGoodsByorders_id(orders_id);
	}

	public void deleteShopCarAll(){
		goodsTypeMapper.deleteShopCarAll();
	}

	//查询当前用户的所有订单

	public List<Orders> findAllOrdersByUser_id(int user_id) {
		return goodsTypeMapper.findAllOrdersByUser_id(user_id);
	}


	//订单管理模块

	public List<Orders> findAllOrders() {
		return goodsTypeMapper.findAllOrders();
	}

	public List<Orders> findOrdersByPage(int count) {
		return goodsTypeMapper.findOrdersByPage(count);
	}

	public List<Orders> findOrdersByOrderId(int number) {
		String num = "%"+number+"%";
		return goodsTypeMapper.findOrdersByOrderId(num);
	}

	public int updateOrderState(int orderId) {
		return goodsTypeMapper.updateOrderState(orderId);
	}

	public int updateState(int state, int orderId) {
		return goodsTypeMapper.updateState(state,orderId);
	}

	public void updatefloor(String fName , Integer id){
		goodsTypeMapper.updatefloor(fName,id);
	}
	public void insertLun(String url){
		goodsTypeMapper.insertLun(url);
	}
	public String upload(){
		return  goodsTypeMapper.upload();
	}
	public void deletefloor(Integer id){
		goodsTypeMapper.deletefloor(id);
	}
	public void insertFloor(String fName){
		goodsTypeMapper.insertFloor(fName);
	}
	public void deleteLun(String url){
		goodsTypeMapper.deleteLun(url);
	}


	public void insertFloorImage(String url,Integer floorId){
		goodsTypeMapper.insertFloorImage(url,floorId);
	}
	public Integer findFloorFid(String fName){
		return  goodsTypeMapper.findFloorFid(fName);
	}
	public String findFloorfName(Integer fId){
		return  goodsTypeMapper.findFloorfName(fId);
	}
	public List<FloorImage> findFloorImageForfId(Integer floor_id){
		return  goodsTypeMapper.findFloorImageForfId(floor_id);
	}


	public List<Floor> findNewFloor(){
		return  goodsTypeMapper.findNewFloor();
	}
}
