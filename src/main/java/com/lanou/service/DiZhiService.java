package com.lanou.service;

import com.lanou.entity.DiZhi;
import com.lanou.entity.User;

import java.util.List;

public interface DiZhiService {


	public  List<DiZhi> findDiZhi(DiZhi diZhi);
	public String findSXQ(Integer cityid);
//	public DiZhi findDiZhicityid(int cityid);
}
