package com.wang.wei;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan
@ComponentScan("com.wamg.wei")
@Mapper
public class ShoppMemberApp {

	public static void main(String[] args) {
		SpringApplication.run(ShoppMemberApp.class, args);
	}

}
