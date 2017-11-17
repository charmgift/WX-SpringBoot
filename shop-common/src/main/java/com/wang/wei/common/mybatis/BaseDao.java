
package com.wang.wei.common.mybatis;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

public interface BaseDao {

	    /**
	     * @InsertProvider 娉ㄨВ浣滅敤锛� 鑷畾涔塻ql璇彞.
	     */
	
	   @InsertProvider(type=BaseProvider.class,method="save")
	   public void save(@Param("oj")Object oj,@Param("table")String table);
	
	
}
