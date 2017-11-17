package com.wang.wei.apiservice.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wang.wei.apiservice.UserService;
import com.wang.wei.base.BaseResult;
import com.wang.wei.entity.User;
import com.wang.wei.mapper.UserMappper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserServiceImpl implements UserService {


	@Autowired
	private UserMappper userMappper;

	@Override
	public Map<String, Object> regier(@RequestBody User user) {
	/*	Integer i =userMappper.regiter(phoneNo,password);
		if(i == 1){
			return new BaseResult().ok();
		}*/
		return new BaseResult().fail("100001","注册失败");
	}

	@Override
	public Map<String, Object> login(String phone, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
