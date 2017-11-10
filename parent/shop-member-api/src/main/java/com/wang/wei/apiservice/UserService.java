package com.wang.wei.apiservice;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/member")
public interface UserService {

	public Map<String,Object> regier();
}
