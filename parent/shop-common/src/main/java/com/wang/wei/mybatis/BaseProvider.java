package com.wang.wei.mybatis;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class BaseProvider {

	/**
	 * 新增  sql 拼装
	 * 
	 * @param map
	 * @return
	 */
	public String save(Map<String, Object> map) {
		Object obj = map.get("obj");
		String table = (String) map.get("table");
		SQL sql = new SQL() {
			{
				INSERT_INTO(table);
				VALUES(ReflectionUtils.fatherAndSonField(obj), ReflectionUtils.getFatherAndSonFieldValue(obj));
			}
		};
		return sql.toString();
	}
	
	/**
	 * 修改  sql 拼装
	 * @param map
	 * @return
	 */
	public String update(Map<String, Object> map) {
		Object obj = map.get("obj");
		String table = (String) map.get("table");
		SQL sql = new SQL() {
			{
				UPDATE(table);
				SET(ReflectionUtils.update(obj));
			}
		};
		return sql.toString();
	}
}
