package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.dao.GoodsTypeMapper;
import com.lanou.entity.*;
import com.lanou.service.DiZhiService;
import com.lanou.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2017/12/5.
 */
@Controller
@RequestMapping("/")
public class GoodsInfoController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @Autowired
    private DiZhiService diZhiService;

    //==================================商品详情功能=====================================
    @RequestMapping("/product")
    @ResponseBody
    public void findsId(int id, HttpServletResponse response,HttpServletRequest request){//请求点击商品跳转到商品详情页，需要接收商品的id

        //根据id请求找到对应的商品

        List<Goods> goodsList = new ArrayList<Goods>();
        List<GoodsImage> goodsImages = new ArrayList<GoodsImage>();
        List<Goods> goodsList1 = new ArrayList<Goods>();
        List<GoodsImage> goodsImages1 = new ArrayList<GoodsImage>();
        List<String> names = new ArrayList<String>();
        List<Comments> commentsList = new ArrayList<Comments>();
        List<Comments_Info> comments_infos = new ArrayList<Comments_Info>();
        Map<String,Object> map = new HashMap<String,Object>();

        //第一部分是商品的主要信息，在Goods表中
        goodsList = goodsTypeService.findGoodsById(id);
        //第二部分是商品的多个图片
        goodsImages = goodsTypeService.findGoodsImage(id);
        //第三部分是同类商品信息（根据All_id）
        //先取到这个商品的All_id
        int All_id = goodsList.get(0).getAll_id();
        goodsList1 = goodsTypeService.findGoodsByAll_id(All_id);
        //第四部分是商品的大图
        goodsImages1 = goodsTypeService.findGoodsImage1(id);
        //第五部分是从首页->一级标签->二级标签->三级标签->商品的名字
        names.add(goodsList.get(0).getgName());
        GoodsType goodsType = new GoodsType();
        goodsType = goodsTypeService.findGoodsType(All_id).get(0);
        names.add(goodsType.getaName());
        while(goodsType.getParentId()!=0){
            goodsType = goodsTypeService.findGoodsType(goodsType.getParentId()).get(0);
            names.add(goodsType.getaName());
        }
        names.add("首页");
        //这里取到的是逆序的，然后倒序排序
        for(int i=0;i<names.size()/2;i++){
            String t = names.get(i);
            names.get(i).replace(names.get(i),names.get(names.size()-i-1));
            names.get(names.size()-i-1).replace(names.get(names.size()-i-1),t);
        }
        //第六部分是当前商品的评论
        //找到了所有的评论
        commentsList = goodsTypeService.findComments(id);
        for(int i=0;i<commentsList.size();i++){
           int uId =  commentsList.get(i).getUser_id();
           List<User_Info> user_info = goodsTypeService.findUser_Info(uId);
           Comments_Info comments_info = new Comments_Info();
           comments_info.setuName(user_info.get(0).getuName());
           comments_info.setcContent(commentsList.get(i).getContent());
           comments_infos.add(comments_info);
        }
        System.out.println(comments_infos);

        DiZhi_Info diZhi_info = new DiZhi_Info();
        diZhi_info = goodsTypeService.findDiZhicityid(2);

        List<DiZhi_Info> diZhi_infos = new ArrayList<DiZhi_Info>();
        diZhi_infos.add(goodsTypeService.findDiZhicityid(35)) ;

        diZhi_infos.get(0).setDiZhi_infos(findChildDiZhi_Info(diZhi_infos.get(0),35));
        diZhi_info.setDiZhi_infos(diZhi_infos);

        System.out.println(diZhi_info);
//        添加到历史记录中
        User user  = (User) request.getSession().getAttribute("users");
        if(user != null){
            List<History> history = (ArrayList < History> )request.getSession().getAttribute("History");
            System.out.println(history);
            String uName = user.getuName();
            System.out.println("userName"+uName);
            inHistory(goodsList,uName);
            System.out.println("dasd"+inHistory(goodsList,uName));
        }
//
        map.put("content",comments_infos);
        map.put("main",goodsList);
        map.put("xiao",goodsImages);
        map.put("left",goodsList1);
        map.put("right",goodsImages1);
        map.put("road",names);
        map.put("address",diZhi_info);
        FastJson_All.toJson(map,response);
        //return map;

    }
    //        添加到历史记录中
    public boolean inHistory(List<Goods> goodsList ,String uName){
       if(uName != null){
            String goodsName =  goodsList.get(0).getgName();
            int findNull = goodsTypeService.findNull(goodsName);
            if(findNull == 0){
                Double goodsPrice =  goodsList.get(0).getgPrice();
                String goodsUrl = goodsList.get(0).getgUrl();
                boolean result = goodsTypeService.insert1(uName,goodsName,goodsUrl,goodsPrice);
                System.out.println(uName);
                System.out.println(goodsName);
                return  result;

            }

           return false;
       }
        return false;
    }
//
    //========================================================================

    //=======================三级联动地址功能模块=============================
    @RequestMapping("/select")
    public void selectDiZhiAndChildren(Integer cityid,Integer type,HttpServletResponse response){

        //如果type为0则表示取到的是头部，需要遍历的是同级标签
        //如果type为1则表示取到的是身体部分，需要遍历的是下级标签
        List<DiZhi_Info> diZhi_infos = new ArrayList<DiZhi_Info>();
        //先查找到对应id的所有信息
        DiZhi_Info diZhi_info = goodsTypeService.findDiZhicityid(cityid);
        if(type==0){
            //再查找到所有parent_id同属于这一层的
           diZhi_infos = goodsTypeService.selectDiZhiChildrenByParentId(diZhi_info.getParentid());
            FastJson_All.toJson(diZhi_infos,response);
        }else if(type==1){
            diZhi_info.setDiZhi_infos(goodsTypeService.selectDiZhiChildrenByParentId(cityid));
            FastJson_All.toJson(diZhi_info,response);
        }

    }

    private List<DiZhi_Info> findChildDiZhi_Info(DiZhi_Info diZhi_info,int cityid){
        //通过主键的id，查找表中所有parent_id和Id匹配的，放入一个goodsTypeList集合中
		List<DiZhi_Info> diZhi_infos = goodsTypeService.selectDiZhiChildrenByParentId(cityid);
        for (DiZhi_Info diZhiInfoItem:diZhi_infos) {
            diZhiInfoItem.setDiZhi_infos(findChildDiZhi_Info(diZhi_info,diZhiInfoItem.getCityid()));
        }
        return diZhi_infos;
    }
    //========================================================================

    //	//无限级查询
//	@RequestMapping("/select")
//	@ResponseBody
//	//通过查找当前传送过来的Id，查找对应的信息
//	public Map<String,Object> selectGoodsTypeAndChildren(Integer aId){
//		//定义一个map容器
//		Map<String,Object> map = new HashMap<String,Object>();
//		//先查找到对应Id的所有信息
//		GoodsType goodsType = goodsTypeService.selectByPrimaryKey(aId);
//		//如果当前查找的Id不存在，则返回一个值为空
//		if(goodsType == null){
//			return null;
//		}
//		//否则表示已经查找到当前id的信息，然后执行findChildGoodsType方法
//		//将goodsType和主键id作为形参传送过去
//		goodsType.setGoodsTypes(findChildGoodsType(goodsType,aId));
//		map.put("data",goodsType);
//		return map;
//	}
//
//	//私有方法，接收goodsType和主键id
//	private List<GoodsType> findChildGoodsType(GoodsType goodsTypeRes,Integer aId){
//		//通过主键的id，查找表中所有parent_id和Id匹配的，放入一个goodsTypeList集合中
//		List<GoodsType> goodsTypeList = goodsTypeService.selectGoodsTypeChildrenByParentId(aId);
//		//对这个集合进行遍历
//		for (GoodsType goodsTypeItem:goodsTypeList ) {
//			//这里运用到循环嵌套调用
//			//如果当前商品，根据他的主键还能查找到parent_id与之对应的话，就嵌套调用
//			//如果已经查找不到parent_id等于主键的时候，就说明集合中的参数为空，就不会再执行了
//			//最终在当前集合的goodsType中放入当前属于他子集的所有参数，完成无限极查询的功能
//			goodsTypeItem.setGoodsTypes(findChildGoodsType(goodsTypeRes,goodsTypeItem.getaId()));
//		}
//		return goodsTypeList;
//	}
}
