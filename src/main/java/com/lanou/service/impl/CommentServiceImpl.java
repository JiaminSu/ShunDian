package com.lanou.service.impl;

import com.lanou.dao.CommentMapper;
import com.lanou.dao.DiZhiMapper;
import com.lanou.entity.Comments;
import com.lanou.entity.DiZhi;
import com.lanou.service.CommentService;
import com.lanou.service.DiZhiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService{
    @Autowired
   private CommentMapper commentMapper;

    public void addComment(Integer good_id,Integer user_id,String content){
        commentMapper.addComment(good_id,user_id,content);
    }
    public Integer findGoods_id(Integer goods_id,Integer user_id){
        return commentMapper.findGoods_id(goods_id,user_id);
    }
    public List<Comments>  pinglun(Integer page){
        page=(page-1)*20;
        return  commentMapper.pinglun(page);
    }
    public void PLdelete(Integer cId){
       commentMapper.PLdelete(cId);
    }
}
