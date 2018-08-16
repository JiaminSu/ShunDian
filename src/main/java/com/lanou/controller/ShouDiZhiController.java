package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.entity.DiZhi;
import com.lanou.entity.ShouDiZhi;
import com.lanou.entity.User;
import com.lanou.service.DiZhiService;
import com.lanou.service.ShouDiZhiService;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
/**
 * Created by lanou on 2017/12/5.
 */
@Controller
@RequestMapping("/")
public class ShouDiZhiController {

   @Autowired
   private ShouDiZhiService shouDiZhiService;
    @Autowired
    private DiZhiService diZhiService;
   @RequestMapping("findShouDiZhi.do")
   public void findShouDiZhi(Integer uId,HttpServletResponse response ,HttpSession session){
       User user=(User)session.getAttribute("users");
       uId= user.getuId();
       Map<String,Object> map=new HashMap<String, Object>();
        //接收到用户的uId返回对应的地址
       List<ShouDiZhi> result=null;
       result= shouDiZhiService.findShouDiZhi(uId);
       if (result==null){
           result=null;
       }

       System.out.println(result);
       map.put("result",result);
       FastJson_All.toJson(map,response);
   }

//   //添加收获地址
//   //<!--需要传过来姓名等信息user_id自己从session中取-->
//    @RequestMapping("addShouDiZhi.do")
//   public  void addShouDiZhi(@RequestParam("cityid") Integer[] param,ShouDiZhi shouDiZhi, HttpServletResponse response, HttpSession session){
//        User user=(User)session.getAttribute("users");
//      Integer user_id=  user.getuId();
//
//        List diZhis=new ArrayList();
//        String diZhi=null;
//
//        for(int i=0;i<param.length;i++){
//
//            System.out.println(param[i]);
//            diZhi=diZhiService.findSXQ(param[i]);
//            diZhis.add(diZhi);
//        }
//
//        String strResult="";
//        for (int i=0;i<diZhis.size();i++){
//            strResult+=diZhis.get(i)+"/";
//        }
//        strResult=strResult.substring(0,strResult.length()-1);
//        System.out.println("返回："+strResult);
//        System.out.println(shouDiZhi.getsZip());
//
//        shouDiZhi.setUser_id(user_id);
//        shouDiZhi.setsArea(strResult);
//        System.out.println(shouDiZhi.getsArea());
//       boolean result=false;
//      if (shouDiZhiService.addShouDiZhi(shouDiZhi)){
//          result=true;  //添加成功返回true
//      }
//        System.out.println(result);
//        //添加失败返回false
//        FastJson_All.toJson(result,response);
//   }


    @RequestMapping("addShouDiZhi.do")
    public  void addShouDiZhi(String sName,String sArea, String sAddress,String sZip,String sPhone, HttpServletResponse response, HttpSession session){
        User user=(User)session.getAttribute("users");
        Integer user_id=  user.getuId();
        boolean result=false;
        System.out.println(sName+sArea+sAddress);
        if (shouDiZhiService.addShouDiZhi(sName,sArea, sAddress,sZip,sPhone,user_id)){
            result=true;  //添加成功返回true
        }

        System.out.println(result);
        //添加失败返回false
        FastJson_All.toJson(result,response);
    }


   //删除收获地址  需要传过来地址的id  user_id我自己从session中取
    @RequestMapping("deleteShouDiZhi.do")
    public void deleteShouDiZhi(Integer sId ,Integer user_id,HttpServletResponse response,HttpSession session){
        User user=(User)session.getAttribute("users");
        user_id= user.getuId();
        boolean result=false;
        if (shouDiZhiService.deleteShouDiZhi(sId,user_id)){
            result=true;   //删除成功返回true
        }
        //删除失败返回false
        FastJson_All.toJson(result,response);
    }
}
