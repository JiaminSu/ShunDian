package com.lanou.service;

import com.lanou.entity.*;

import java.util.List;

public interface GoodsTypeService {

	public List<GoodsType> find9Goods3Type();
	public List<GoodsType> findGoods1Type();
	public List<Floor> findFloor();
	public List<Goods> find8Goods();
	public List<Goods> find5Goods();
	public List<GoodsType> findGoodsType(int aId);
	public List<Floor>  findFloorX();

	//对应楼层的id找到集合FloorImage
	public List<FloorImage> findFloorImage();

	//商品详情页
	//第一部分
	public List<Goods> findGoodsById(int id);
	//第二部分
	public List<GoodsImage> findGoodsImage(int id);
	//第三部分
	public List<Goods> findGoodsByAll_id(int All_id);
	//第四部分
	public List<GoodsImage> findGoodsImage1(int id);
	//第五部分
	public List<Comments> findComments(int gId);
	//第六部分
	public List<User_Info> findUser_Info(int uId);
	//	添加历史记录
	public boolean  insert1(String userName,String goodsName,String goodsImage,Double goodsPrice);
	//调出历史记录
	public List<History> findHistory(String userName);
//	 判断有无
   public int findNull(String goodsName);


	//地址三级联动模块
	public DiZhi_Info findDiZhicityid(int cityid);
	public List<DiZhi_Info> selectDiZhiChildrenByParentId(int cityid);

	//	无限级查询
	public List<GoodsType> find1(Goods good1 ,Integer aId);
	//查询aId
	public List<GoodsType> findfenlei(Integer aId);
	//=====
	public List findLun();
	//	找到三张图
	public List findIndexSan(Integer aId);


	//购物车模块
	//添加商品
	public void updateShopCar1(int cout,Double sum,int goods_id);
	public ShopCar findShopCargoods_id(Integer goods_id);
	public void updateShopCar(int gId,String gName,Double price,int count,Double sum,String goods_url);
	public void deleteShopCar(int id);

	//侧边栏点击购物车模块
	public List<ShopCar> findShopCar();

	//添加订单模块
	//添加订单模块
	public void addOrders(String order_time,int address_sId,double totalMoney,int user_id);
	public Integer findMaxOrders();
	public void addOrdersGoods(int goods_id,int goods_num,int orders_id);

	//查询订单模块
	public Orders findOrdersByMaxId(int maxId);

	//查询订单商品记录
	public List<Orders_goods> findOrdersGoodsByorders_id(int orders_id);

//	public List<Orders> findOrders(int user_id);

	//删除购物车中的所有数据
	public void deleteShopCarAll();


	//查询当前用户的所有订单
	public List<Orders> findAllOrdersByUser_id(int user_id);

	//订单管理模块
	public List<Orders> findAllOrders();
	public List<Orders> findOrdersByPage(int count);
	public List<Orders> findOrdersByOrderId(int number);
	public int updateOrderState(int orderId);
	public int updateState(int state,int orderId);

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
