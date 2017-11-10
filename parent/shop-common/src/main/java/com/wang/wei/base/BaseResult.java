package com.wang.wei.base;

import java.util.HashMap;
import java.util.Map;

import com.wang.wei.constants.Constant;
/**
 * 返回值
 *
 */
public class BaseResult {
	/**
	 * 成功无data
	 * @return
	 */
	public Map<String, Object> ok() {
		return setResult(Constant.HTTP_CODE_200, Constant.HTTP_MSG_200, null);
	}
	/**
	 * 成功有data
	 * @return
	 */
	public Map<String, Object> ok(Object obj) {
		return setResult(Constant.HTTP_CODE_200, Constant.HTTP_MSG_200, obj);
	}
	/**
	 * 失败，自定义返回码
	 * @return
	 */
	public Map<String, Object> fail(String code, String msg) {
		return setResult(code, msg, null);
	}

	/**
	 * 失败，内部错误
	 * @return
	 */
	public Map<String, Object> error() {
		return setResult(Constant.HTTP_CODE_500, Constant.HTTP_MSG_500, null);
	}
	
	public Map<String, Object> setResult(String code, String msg, Object data) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Constant.HTTP_CODE_NAME, code);
		map.put(Constant.HTTP__MSG_NAME, msg);
		if (data != null) {
			map.put(Constant.HTTP__DATA_NAME, data);
		}
		return map;

	}
}
