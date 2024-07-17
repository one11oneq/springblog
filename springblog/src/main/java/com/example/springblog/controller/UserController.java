package com.example.springblog.controller;

import com.example.springblog.domain.User;
import com.example.springblog.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.sql.Date;


@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public Result register(@RequestBody User user){
        long m=System.currentTimeMillis();
        Date date=new Date(m);
        user.setCreated(date);
        user.setCreated(date);
        userService.login(user);
        return new Result("注册成功",201);
    }
    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpServletResponse response){
        if (userService.verify(user.getUsername(),user.getPassword())){
            String token=userService.gettoken(user);
            Cookie cookie=new Cookie("token",token);
            response.addCookie(cookie);
            return new Result("登陆成功",200);
        }
        return new Result("用户名或者密码错误",400);
    }

    @GetMapping("/me")
    public Result getmessage(String username){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if(requestAttributes==null){
            return new Result("您没有权限",401);
        }else{
            String token=requestAttributes.getRequest().getHeader("token");
            if(username.equals(userService.getusername(token))){
                User user=userService.getMessage(username);
                return new Result(user,200);
            }
            return new Result("您没有权限",401);

        }
    }

}
