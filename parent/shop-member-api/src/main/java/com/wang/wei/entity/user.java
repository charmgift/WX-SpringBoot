package com.wang.wei.entity;

import com.wang.wei.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class user extends BaseEntity{

	private String userName;
	private String password;
	private String phone;
	private String email;

}
