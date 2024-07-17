package com.example.springblog.controller;

import com.example.springblog.domain.Blog;
import com.example.springblog.domain.User;
import com.example.springblog.service.BlogService;
import com.example.springblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private UserService userService;

    @PostMapping()
    public Result posts(@RequestBody Blog blog){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if(requestAttributes==null){
            return new Result("需要登录",401);
        }else{
            String token=requestAttributes.getRequest().getHeader("token");
            User user=userService.getMessage(userService.getusername(token));
            blog.setUser_id(user.getUser_id());
            blogService.createtext(blog);
            return new Result("创建完成",201);

        }
    }

    @GetMapping("/{id}")
    public Result getcontent(@PathVariable("id")int id){
        String content=blogService.getBlogDetile(id);
        return new Result(content,200);
    }

    @GetMapping("")
    public Result getAllTitle(@RequestParam("uid")int id){
        List<String> titles=blogService.getAlltitle(id);
        return new Result(titles,200);
    }

    //分页
//    @GetMapping("")
//    public Result getAllTitlePartition(@RequestParam("uid")int id,@RequestParam("count")int count,@RequestParam("page")int page){
//        List<String> titles=blogService.getAlltitle(id);
//        List<String> s=blogService.partition(count,page,titles);
//        return new Result(s,200);
//    }

    @PutMapping("/{id}")
    public Result updateContent(@PathVariable("id")int id,@RequestParam("content")String c){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if(requestAttributes==null){
            return new Result("需要登录",401);
        }else{
            String token=requestAttributes.getRequest().getHeader("token");
            User user=userService.getMessage(userService.getusername(token));
            if(user.getUser_id()==blogService.getUserid(id)){
                blogService.updatecontent(c,id);
                return new Result("更新成功",200);
            }else{
                return new Result("没有权限",401);
            }


        }
    }

    @DeleteMapping ("/{id}")
    public Result deleteBlog(@PathVariable("id")int id){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if(requestAttributes==null){
            return new Result("需要登录",401);
        }else{
            String token=requestAttributes.getRequest().getHeader("token");
            User user=userService.getMessage(userService.getusername(token));
            if(user.getUser_id()==blogService.getUserid(id)){
                blogService.deleteblog(id);
                return new Result("删除成功",200);
            }else{
                return new Result("没有权限",401);
            }


        }
    }
}
