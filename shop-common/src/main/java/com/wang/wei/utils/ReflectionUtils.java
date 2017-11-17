
package com.wang.wei.utils;

import java.lang.reflect.Field;
import java.sql.Timestamp;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ReflectionUtils {

	/**
	 * 
	 * @methodDesc: 鍔熻兘鎻忚堪:(灏佽褰撳墠绫诲拰鐖剁被鐨勬墍鏈夊睘鎬� 鎷兼帴灞炴�ql)
	 * @param: @return
	 */
	public static String fatherAndSonField(Object oj) {
		if (oj == null) {
			return null;
		}
		// 鑾峰彇class鏂囦欢
		Class classInfo = oj.getClass();
		// 鑾峰彇褰撳墠绫诲睘鎬ql
		Field[] sonFields = classInfo.getDeclaredFields();
		String s1 = getField(sonFields);
		Field[] panretFields = classInfo.getSuperclass().getDeclaredFields();
		String s2 = getField(panretFields);
		return s1 + "," + s2;
	}

	/**
	 * 
	 * @methodDesc: 鍔熻兘鎻忚堪:(鑾峰彇鍒板睘鎬у��)
	 * @param: @param
	 *             oj
	 * @param: @return
	 */
	public static String fatherAndSonFieldValue(Object oj) {
		if (oj == null) {
			return null;
		}
		// 鑾峰彇class鏂囦欢
		Class classInfo = oj.getClass();
		// 鑾峰彇褰撳墠绫诲睘鎬ql
		Field[] sonFields = classInfo.getDeclaredFields();
		String s1 = getFieldValue(oj, sonFields);
		Field[] panretFields = classInfo.getSuperclass().getDeclaredFields();
		String s2 = getFieldValue(oj, panretFields);
		return s1 + "," + s2;
	}

	public static String getField(Field[] declaredFields) {
		StringBuffer sf = new StringBuffer();
		for (int i = 0; i < declaredFields.length; i++) {
			sf.append(declaredFields[i].getName());
			if (i < declaredFields.length - 1) {
				sf.append(",");
			}
		}
		return sf.toString();
	}

	public static String getFieldValue(Object oj, Field[] declaredFields) {
		StringBuffer sf = new StringBuffer();
		for (int i = 0; i < declaredFields.length; i++) {
			// 鑾峰彇鍒板睘鎬у��
			try {
				Field field = declaredFields[i];
				// 杩愯鎿嶄綔绉佹湁灞炴��
				field.setAccessible(true);
				Object value = field.get(oj);
				// 鏍囪瘑绫诲瀷鏄惁涓簊tring绫诲瀷
				boolean flag = false;
				if (value != null && (value instanceof String || value instanceof Timestamp)) {
					flag = true;
				}
				if (flag) {
					sf.append("'");
					sf.append(value);
					sf.append("'");
				} else {
					sf.append(value);
				}
				if (i < declaredFields.length - 1) {
					sf.append(",");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sf.toString();
	}

/*	public static void main(String[] args) {
		TestEntity testEntity = new TestEntity();
		testEntity.setUserName("寮犱笁");
		testEntity.setPhone("15921009245");
		testEntity.setEmail("644064779@qq.com");
		testEntity.setPassword("123456");
		testEntity.setCreated(DateUtils.getTimestamp());
		testEntity.setUpdated(DateUtils.getTimestamp());
		String filed = fatherAndSonField(testEntity);
		String value = fatherAndSonFieldValue(testEntity);
		
	}*/

}
