package com.wang.wei.base;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis 存储 查询
 */
@Component
public class BaseRedis {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 存儲
	 * 
	 * @param key
	 * @param data
	 * @param timeout
	 */
	public void setString(String key, Object data, Long timeout) {

		if (data instanceof String) {
			String value = (String) data;
			stringRedisTemplate.opsForValue().set(key, value);
		}

		// 设置失效时间
		if (null != timeout) {
			stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
		}
	}

	/**
	 * 获取
	 * @param key
	 * @return
	 */
	public Object getString(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}
	
	/**
	 * 刪除
	 * @param key
	 */
	public void delete(String key) {
		 stringRedisTemplate.delete(key);
	}
}
