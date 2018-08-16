package com.lanou.controller;

import com.lanou.Util.FastJson_All;
import com.lanou.entity.Comments;
import com.lanou.entity.DiZhi;
import com.lanou.entity.User;
import com.lanou.service.CommentService;
import com.lanou.service.DiZhiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.font.TrueTypeFont;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by lanou on 2017/12/5.
 */
@Controller
@RequestMapping("/")
public class CommentController {

   @Autowired
   private CommentService commentService;

   @RequestMapping("addComment.do")
   public void addComment(Integer goods_id,String content, HttpServletResponse response, HttpSession session){
      User user=(User) session.getAttribute("users");
     Integer user_id= user.getuId();
       Map<String,Object> map=new HashMap<String, Object>();
     Integer result= commentService.findGoods_id(goods_id,user_id);
       System.out.println("sssssss"+result);
     if (result==null){
         commentService.addComment(goods_id,user_id,content);
         map.put("result","true");
     }else {
         map.put("result","false");
     }
      FastJson_All.toJson(map,response);
   }
}
