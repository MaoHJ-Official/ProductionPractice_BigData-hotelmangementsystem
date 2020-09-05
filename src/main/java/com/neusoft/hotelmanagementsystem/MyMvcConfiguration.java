package com.neusoft.hotelmanagementsystem;

import com.neusoft.hotelmanagementsystem.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.neusoft.hotelmanagementsystem.controller.CustomDateConverter;
import org.springframework.format.FormatterRegistry;

@Configuration
public class MyMvcConfiguration implements WebMvcConfigurer {

//    放行被拦截的资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        第一个方法里面的参数 表示的是在页面上引用的url地址
//        第二个方法里面的参数 表示的是当前资源具体的位置
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new CustomDateConverter());
    }

//    注册拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/index");
//    }
}
