package com.lanou.dao;

import com.lanou.entity.Comments;
import com.lanou.entity.DiZhi;

import java.util.List;

public interface CommentMapper {

	  public void addComment(Integer good_id,Integer user_id,String content);
		public Integer findGoods_id(Integer goods_id,Integer user_id);
	public List<Comments> pinglun(Integer page);
	public void PLdelete(Integer cId);
}
