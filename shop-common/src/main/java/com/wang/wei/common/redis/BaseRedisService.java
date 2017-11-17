
package com.wang.wei.common.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class BaseRedisService {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	/**
	 * 
	 * @methodDesc: 鍔熻兘鎻忚堪:(寰�redis娣诲姞淇℃伅)
	 * @param: @param
	 *             key
	 */
	public void setString(String key, String value) {
		set(key, value, null);
	}

	public void setString(String key, String value, Long timeOut) {
		set(key, value, timeOut);
	}

	public void set(String key, Object value, Long timeOut) {
		if (value != null) {

			if (value instanceof String) {
				String setValue = (String) value;
				stringRedisTemplate.opsForValue().set(key, setValue);
			}
			// 灏佽鍏朵粬绫诲瀷
			// 璁剧疆鏈夋晥鏈�
			if (timeOut != null)
				stringRedisTemplate.expire(key, timeOut, TimeUnit.SECONDS);

		}

	}

	/**
	 * 
	 * @methodDesc: 鍔熻兘鎻忚堪:(浣跨敤key 鏌ユ壘redis淇℃伅)
	 * @param: @param
	 *             key
	 */
	public String get(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}

	/**
	 * 
	 * @methodDesc: 鍔熻兘鎻忚堪:(浣跨敤key 鍒犻櫎redis淇℃伅)
	 * @param: @param
	 *             key
	 */
	public void delete(String key) {
		stringRedisTemplate.delete(key);
	}
}
