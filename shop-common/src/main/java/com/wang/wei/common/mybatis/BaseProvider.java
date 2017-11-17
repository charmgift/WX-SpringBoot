
package com.wang.wei.common.mybatis;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.wang.wei.utils.ReflectionUtils;


public class BaseProvider {

	/**
	 * 
	 * @methodDesc: 鍔熻兘鎻忚堪:(鑷畾涔夊皝瑁卻ql璇彞)
	 * @param: @return
	 */
	public String save(Map<String, Object> map) {
		// 瀹炰綋绫�
		final Object oj = map.get("oj");
		// 琛ㄥ悕绉�
		final String table = (String) map.get("table");
		// 鐢熸垚娣诲姞鐨剆ql璇彞銆� 浣跨敤鍙嶅皠鏈哄埗
		// 姝ラ锛氫娇鐢ㄥ弽灏勬満鍒跺姞杞借繖涓被鎵�鏈夊睘鎬�
		// INSERT INTO `mb_user` (username,password,phone,email,created,updated)
		// VALUES ('yushengjun2', 'e10adc3949ba59abbe56e057f20f883e',
		// '15527339673', 'aa1@a', '2015-04-06 17:03:55', '2015-04-06
		// 17:03:55');
		SQL sql = new SQL() {
			{
				INSERT_INTO(table);
				VALUES(ReflectionUtils.fatherAndSonField(oj), ReflectionUtils.fatherAndSonFieldValue(oj));

			}
		};

		return sql.toString();

	}

}
