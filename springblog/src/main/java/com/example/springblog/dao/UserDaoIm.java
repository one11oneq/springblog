package com.example.springblog.dao;

import com.example.springblog.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.Date;


@Mapper
public interface UserDaoIm {

    @Insert("insert into user(username,password,email,created,last_modified) value(#{username},#{password},#{email},#{created},#{last_modified})")
    public void insert(@Param("username")String username, @Param("password")String password, @Param("email")String email,
                       @Param("created")Date created,@Param("last_modified")Date last_modified);
    @Select("select * from user where username=#{username}")
    public User selectuser(@Param("username")String username);

}
