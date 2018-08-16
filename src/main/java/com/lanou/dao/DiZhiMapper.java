package com.lanou.dao;

import com.lanou.entity.DiZhi;
import com.lanou.entity.User;

import java.util.List;

public interface DiZhiMapper {

	public  List<DiZhi> findDiZhi(DiZhi diZhi);
	public String findSXQ(Integer cityid);

}
