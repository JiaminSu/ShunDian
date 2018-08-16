package com.lanou.service.impl;

import com.lanou.dao.UserMapper;
import com.lanou.entity.User;
import com.lanou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	

	public User finduNameAndPwd(User user){
		return userMapper.finduNameAndPwd(user);
	}

	public  User finduName(User user){

		return userMapper.finduName(user);
	}

	public boolean adduNameAndPwd(User user){

		return userMapper.adduNameAndPwd(user);
	}
	public  boolean updateUser(User user){

		return userMapper.updateUser(user);
	}
	public String finduPasswordByuName(String uPassword){
		return userMapper.finduPasswordByuName(uPassword);
	}
	public  User findUser(String uName){
		return userMapper.findUser(uName);
	}
	public  void updatePwd(String uPassword,String uName){
		 userMapper.updatePwd(uPassword,uName);
	}
}
