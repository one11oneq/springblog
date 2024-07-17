package com.example.springblog.service;

import com.example.springblog.dao.BlogDaoIm;
import com.example.springblog.dao.UserDaoIm;
import com.example.springblog.domain.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogDaoIm blogDaoIm;

    @Autowired
    private UserDaoIm userDaoIm;

    public void createtext(Blog blog){
        long date=System.currentTimeMillis();
        Date date1=new Date(date);
        blog.setCreated(date1);
        blog.setLast_modified(date1);
        blogDaoIm.insertblog(blog.getTitle(),blog.getContent(),blog.getUser_id(),blog.getCreated(),blog.getLast_modified());
    }

    public List<String> getAlltitle(int id){
        return blogDaoIm.selectAllContent(id);
    }

    public List<String> getAlltitleOrder(int id){
        return blogDaoIm.selectAllContentOrderC(id);
    }
    public List<String> getAlltitleOrdercd(int id){
        return blogDaoIm.selectAllContentOrderCD(id);
    }

    public String getBlogDetile(int id){
        return blogDaoIm.selectContent(id);
    }
    public int getUserid(int id){
        return blogDaoIm.getUserid(id);
    }

    public void updatecontent(String content,int id){
        long date=System.currentTimeMillis();
        Date date1=new Date(date);
        blogDaoIm.update(content,id,date1);
    }

    public void deleteblog(int id){
        blogDaoIm.delete(id);
    }

    public List<String> partition(int count,int page,List<String> s){
        List<String> s1=new ArrayList<>();
        int l=s.size();
        for(int i=(page-1)*count;i<page*count;i++){
            if(i<l){
                s1.add(s.get(i));
            }
        }
        return s1;
    }

}
