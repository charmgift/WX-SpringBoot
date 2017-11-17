package com.wang.wei.mapper;

import com.wang.wei.mybatis.MytabisDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public  interface UserMappper extends MytabisDao {

    @Insert("insert into user(phone,password) values(#{phone},#{password})")
    public   Integer regiter(@Param("phone") String  phone,@Param("password") String password);
}
