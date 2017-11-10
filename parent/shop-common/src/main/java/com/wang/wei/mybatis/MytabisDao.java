package com.wang.wei.mybatis;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

public interface MytabisDao {

	@InsertProvider(type = BaseProvider.class, method = "save")
	public void save(@Param("obj") Object obj, @Param("talbe") String table);
	
	@InsertProvider(type = BaseProvider.class, method = "update")
	public void update(@Param("obj")Object obj,@Param("talbe") String table);
}
