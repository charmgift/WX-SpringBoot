package com.wang.wei.common.log;

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

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

@Aspect
// 鐢虫槑鏄釜spring绠＄悊鐨刡ean
@Component
@Slf4j
public class LogAspectServiceApi {
	private JSONObject jsonObject = new JSONObject();

	// 鐢虫槑涓�涓垏鐐� 閲岄潰鏄� execution琛ㄨ揪寮�
	@Pointcut("execution(public * com.wang.wei.api.service.*.*(..))")
	private void controllerAspect() {
	}

	// 璇锋眰method鍓嶆墦鍗板唴瀹�
	@Before(value = "controllerAspect()")
	public void methodBefore(JoinPoint joinPoint) {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		log.info("===============璇锋眰鍐呭===============");
		try {
			// 鎵撳嵃璇锋眰鍐呭
			log.info("璇锋眰鍦板潃:" + request.getRequestURL().toString());
			log.info("璇锋眰鏂瑰紡:" + request.getMethod());
			log.info("璇锋眰绫绘柟娉�:" + joinPoint.getSignature());
			log.info("璇锋眰绫绘柟娉曞弬鏁�:" + Arrays.toString(joinPoint.getArgs()));
		} catch (Exception e) {
			log.error("###LogAspectServiceApi.class methodBefore() ### ERROR:", e);
		}
		log.info("===============璇锋眰鍐呭===============");
	}

	// 鍦ㄦ柟娉曟墽琛屽畬缁撳悗鎵撳嵃杩斿洖鍐呭
	@AfterReturning(returning = "o", pointcut = "controllerAspect()")
	public void methodAfterReturing(Object o) {
		log.info("--------------杩斿洖鍐呭----------------");
		try {
			log.info("Response鍐呭:" + jsonObject.toJSONString(o));
		} catch (Exception e) {
			log.error("###LogAspectServiceApi.class methodAfterReturing() ### ERROR:", e);
		}
		log.info("--------------杩斿洖鍐呭----------------");
	}
}
