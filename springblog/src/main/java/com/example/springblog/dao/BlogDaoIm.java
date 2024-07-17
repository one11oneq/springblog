package com.example.springblog.dao;

import com.example.springblog.domain.Blog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Mapper
public interface BlogDaoIm {
    @Select("select * from blog ")
    public List<Blog> selectAll();
    @Select("select title from blog where user_id=#{user_id}")
    public List<String> selectAllContent(@Param("user_id")int id);
    @Select("select title from blog where user_id=#{user_id} order by created")
    public List<String> selectAllContentOrderC(@Param("user_id")int id);
    @Select("select title from blog where user_id=#{user_id} order by created desc")
    public List<String> selectAllContentOrderCD(@Param("user_id")int id);

    @Insert("insert into blog(title,content,user_id,created,last_modified) value(#{title},#{content},#{user_id},#{created},#{last_modified})")
    public void insertblog(@Param("tiltle")String title, @Param("content")String content, @Param("user_id")int user_id, @Param("created")Date created,
                           @Param("last_modified")Date last_modified);

    @Delete("delete from blog where post_id=#{post_id}")
    public void delete(@Param("post_id")int id);
    @Select("select post_id from blog where user_id=#{post_id}")
    public int getUserid(@Param("post_id")int id);
    @Update("update blog set content=#{content},last_modified=#{last} where post_id=#{post_id}")
    public void update(@Param("content")String content,@Param("post_id")int post_id,@Param("last")Date last);

    @Select("select content from blog where post_id=#{post_id}")
    public String selectContent(@Param("post_id")int post_id);
}
