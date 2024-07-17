//package com.example.springblog.configation;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebMvc implements WebMvcConfigurer
//{
//    /**
//     * 控制器配置
//     */
//
//
//    /**
//     * 拦截器配置
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry)
//    {
//        //注册Interceptor拦截器
//        InterceptorRegistration registration = registry.addInterceptor(new LogIneterceptor());
//        registration.addPathPatterns("/**"); //所有路径都被拦截
//        registration.excludePathPatterns( //添加不拦截路径
//                "/toLoginPage", //登录页面
//                "/login",       //登录请求
//                "/**/*.html",   //html静态资源
//                "/**/*.js",     //js静态资源
//                "/**/*.css"     //css静态资源
//        );
//    }
//}
