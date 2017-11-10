package com.wang.wei.base;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseEntity {
	private Long id;
	
	private Timestamp createAt;
	
	private Timestamp updateAt;
	
	private String createBy;
	
	private String updateBy;
	//乐观锁
	private String version;
}
