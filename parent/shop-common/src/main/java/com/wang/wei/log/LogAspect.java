package com.wang.wei.log;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Aspect
public class LogAspect {
	
	//定义切面
	@Pointcut("execution(public * com.wang.wei.apiservice.*.*(..))")
	private void controllerAspect() {
	}
	
	//切入点
	@Before(value = "controllerAspect()")
	public void methodBefore(JoinPoint joinPoint) {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		log.info("请求内容:===========START================");
		
		try {
			log.info("请求地址--->" + request.getRequestURL().toString());
			log.info("请求方式 -->" + request.getMethod());
			log.info("请求类方法-->" + joinPoint.getSignature());
			log.info("请求参数 -->" + Arrays.toString(joinPoint.getArgs()));
		} catch (Exception e) {
			log.error("LogAspect.methodBefore() ERROR",e);
		}
		
		log.info("请求内容:===========END================");
	}
	
	@AfterReturning(returning = "obj", pointcut = "controllerAspect()")
	public void methodAfter(Object obj) {
		log.info("返回内容:===========START================");
		try {
			log.info("返回参数-->" + JSON.toJSONString(obj));
		} catch (Exception e) {
			log.error("LogAspect.methodAfter() ERROR",e);
		}
		log.info("返回内容:===========END================");
	}
}
