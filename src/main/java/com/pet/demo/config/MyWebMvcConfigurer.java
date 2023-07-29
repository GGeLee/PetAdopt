package com.pet.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

//注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        添加拦截路径
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/backstage/admin","/Apply/find","/PetTest/pet","/front/user","/manage","/info");
    }


}

