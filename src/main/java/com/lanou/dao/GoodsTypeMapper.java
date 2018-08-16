package com.lanou.dao;

import com.lanou.entity.*;

import java.util.List;

public interface GoodsTypeMapper {
	public List<GoodsType> find9Goods3Type();
	public List<GoodsType> findGoods1Type();
	public List<Floor> findFloor();
	public List<Goods> find8Goods();
	public List<Goods> find5Goods();
	public List<GoodsType> findGoodsType(int aId);
	public List<Floor>  findFloorX();
	//楼层数据
	public List<FloorImage> findFloorImage();

	//商品详情页
	public List<Goods> findGoodsById(int id);
	public List<GoodsImage> findGoodsImage(int id);
	public List<Goods> findGoodsByAll_id(int All_id);
	public List<GoodsImage> findGoodsImage1(int id);
	public List<Comments> findComments(int gId);
	public List<User_Info> findUser_Info(int uId);
//	查询历史记录
	public boolean  insert1(String userName,String goodsName,String goodsImage,Double goodsPrice);
	public List<History> findHistory(String userName);
//	判断是否有重复
	public int findNull(String goodsName);
//
	//三级联动模块
	public DiZhi_Info findDiZhicityid(int cityid);
	public List<DiZhi_Info> selectDiZhiChildrenByParentId(int cityid);

	//	==========================================
	// 无限极查询
	public List<GoodsType> find1(Goods good1 ,Integer aId);
	//查询aId
	public List<GoodsType> findfenlei(Integer aId);
	//	==========================================
	//找到轮播图
	public List findLun();
	//	找到三张图
	public List findIndexSan(Integer aId);


	//购物车模块
	//跟新功能
	public void updateShopCar1(int cout,Double sum,int Goods_id);

	public ShopCar findShopCargoods_id(Integer goods_id);

	//添加功能
	public void updateShopCar(Integer gId,String gName,Double price,Integer count,Double sum,String goods_id);
	//删除功能
	public void deleteShopCar(int id);

	//点击购物车侧边栏
	public List<ShopCar> findShopCar();

	//添加订单模块
	public void addOrders(String order_time, int address_sId, double totalMoney, int user_id);
	public Integer findMaxOrders();
	public void addOrdersGoods(int goods_id,int goods_num,int orders_id);

	//查询订单模块
	public Orders findOrdersByMaxId(int maxId);

	public List<Orders_goods> findOrdersGoodsByorders_id(int orders_id);

	public void deleteShopCarAll();


	//查询当前用户的所有订单
	public List<Orders> findAllOrdersByUser_id(int user_id);

	//订单管理模块
	public List<Orders> findAllOrders();

	public List<Orders> findOrdersByPage(int count);

	public List<Orders> findOrdersByOrderId(String num);

	public int updateOrderState(int orderId);
	public int updateState(int state, int orderId);

	public void updatefloor(String fName,Integer id);
	public void insertLun(String url);
	public String upload();
	public void deletefloor(Integer id);
	public void insertFloor(String fName);
	public void deleteLun(String url);


	public void insertFloorImage(String url,Integer floorId);
	public Integer findFloorFid(String fName);
	public String findFloorfName(Integer fId);
	public List<FloorImage> findFloorImageForfId(Integer floor_id);


	public List<Floor> findNewFloor();
}
