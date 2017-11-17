
package com.wang.wei.common.api;

import java.util.HashMap;
import java.util.Map;

import com.wang.wei.constants.BaseApiConstants;

public class BaseApiService {
  
	public Map<String, Object> setResutError(String msg) {
		return setResut(BaseApiConstants.HTTP_500_CODE, msg, null);
	}

	public Map<String, Object> setResutSuccessData(Object data) {
		return setResut(BaseApiConstants.HTTP_200_CODE, BaseApiConstants.HTTP_SUCCESS_NAME, data);
	}

	public Map<String, Object> setResutSuccess() {
		return setResut(BaseApiConstants.HTTP_200_CODE, BaseApiConstants.HTTP_SUCCESS_NAME, null);
	}
	public Map<String, Object> setResutParameterError(String msg) {
		return setResut(BaseApiConstants.HTTP_400_CODE, msg, null);
	}
	public Map<String, Object> setResutSuccess(String msg) {
		return setResut(BaseApiConstants.HTTP_200_CODE, msg, null);
	}
	public Map<String, Object> setResut(Integer code, String msg, Object data) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(BaseApiConstants.HTTP_CODE_NAME, code);
		result.put(BaseApiConstants.HTTP_200_NAME, msg);
		if (data != null)
			result.put(BaseApiConstants.HTTP_DATA_NAME, data);
		return result;
	}

}
