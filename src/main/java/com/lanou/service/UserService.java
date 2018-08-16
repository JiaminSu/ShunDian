package com.lanou.service;

import com.lanou.entity.User;

import java.util.List;

public interface UserService {
	

	public User finduNameAndPwd(User user);
	public User finduName(User user);
	public  boolean adduNameAndPwd(User user);
	public  boolean updateUser(User user);
	public String finduPasswordByuName(String uPassword);
	public  User findUser(String uName);
	public  void updatePwd(String uPassword,String uName);
}
