package com.wang.wei.mybatis;

import java.lang.reflect.Field;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import lombok.extern.slf4j.Slf4j;

//拼装sql工具类
@Slf4j
public class ReflectionUtils {

	/**
	 * 获取本类父类所有属性名称
	 * 
	 * @param obj
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static String fatherAndSonField(Object obj) {
		if (obj == null) {
			return null;
		}
		Class objClass = obj.getClass();
		// 子类属性
		Field[] sonFields = objClass.getDeclaredFields();
		// 父类属性
		Field[] parentFields = objClass.getSuperclass().getDeclaredFields();
		// 属性String
		String strName = getFieldName(sonFields, parentFields);
		// 属性value
		return strName;
	}

	/**
	 * 获取所有属性的值
	 * 
	 * @param obj
	 * @return
	 */
	public static String getFatherAndSonFieldValue(Object obj) {
		if (obj == null) {
			return null;
		}
		Class objClass = obj.getClass();
		// 子类属性
		Field[] sonFields = objClass.getDeclaredFields();
		// 父类属性
		Field[] parentFields = objClass.getSuperclass().getDeclaredFields();
		String strValue = fieldValueString(obj, sonFields) + "," + fieldValueString(obj, parentFields);
		return strValue;
	}

	/**
	 * 获取属性名称
	 * 
	 * @param sonFields
	 * @param parentFields
	 * @return
	 */
	public static String getFieldName(Field[] sonFields, Field[] parentFields) {
		StringBuffer sbf = new StringBuffer();
		if (StringUtils.isNotEmpty(fieldToString(sonFields))) {
			sbf.append(fieldToString(sonFields));
		}
		if (StringUtils.isNotEmpty(fieldToString(parentFields))) {
			sbf.append(",");
			sbf.append(fieldToString(parentFields));
		}
		return sbf.toString();
	}

	/**
	 * 新增-获取属性名称
	 * 
	 * @param sonFields
	 * @return
	 */
	public static String fieldToString(Field[] sonFields) {
		StringBuffer sbf = new StringBuffer();
		for (int i = 0; i < sonFields.length; i++) {
			sbf.append(sonFields[i].getName());
			if (i < sonFields.length - 1) {
				sbf.append(",");
			}
		}
		return sbf.toString();
	}

	/**
	 * 获取属性值
	 * 
	 * @param obj
	 * @param fields
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static String fieldValueString(Object obj, Field[] fields) {
		StringBuffer sbf = new StringBuffer();
		for (int i = 0; i < fields.length; i++) {
			try {
				Field field = fields[i];
				// 允许访问私有属性
				field.setAccessible(true);
				Object value = field.get(obj);

				if (verfiyObjType(value)) {
					sbf.append("'");
					sbf.append(value);
					sbf.append("'");
				} else {
					sbf.append(value);
				}

				if (i < fields.length - 1) {
					sbf.append(",");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return sbf.toString();
	}

	public static boolean verfiyObjType(Object value) {
		if (value != null || value instanceof String || value instanceof Timestamp) {
			return true;
		}
		return false;
	}

	/**
	 * 修改语句
	 * 
	 * @param obj
	 * @return
	 */
	public static String update(Object obj) {
		if (obj == null) {
			return null;
		}
		Class objClass = obj.getClass();
		Field[] sonFields = objClass.getDeclaredFields();
		Field[] fatherFields = objClass.getSuperclass().getDeclaredFields();
		StringBuffer sbf = new StringBuffer();
		handler(fatherFields, obj, sbf);
		if (StringUtils.isNotEmpty(sbf.toString())) {
			sbf.append(",");
		}
		handler(sonFields, obj, sbf);
		return sbf.toString();
	}

	public static void handler(Field[] sonFields, Object obj, StringBuffer sbf) {
		for (int i = 0; i < sonFields.length; i++) {
			Field field = sonFields[i];
			field.setAccessible(true);
			String fieldName = field.getName();
			if ("id".equals(fieldName))
				continue;
			try {
				Object value = field.get(obj);
				if (verfiyObjType(value) && value != null) {
					sbf.append(fieldName + " = '" + value + "'");
				} else if (value != null) {
					sbf.append(fieldName + " = " + value);
				}
				if (value != null && i < sonFields.length - 1) {
					sbf.append(",");
				}
			} catch (Exception e) {
				log.info("未知异常", e);
			}
		}
	}

	public static void main(String[] args) {
		TestEntity testEntity = new TestEntity();
		testEntity.setCreateBy("創建人");
		testEntity.setUserName("王维");
		testEntity.setUserNo("100001");
		System.out.println(update(testEntity));
	}

}
