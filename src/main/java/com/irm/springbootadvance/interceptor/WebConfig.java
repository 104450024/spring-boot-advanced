package com.irm.springbootadvance.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Logininterceptor()).
                addPathPatterns("/").
                addPathPatterns("/books/**");

        //攔截器::若沒有登入就無法查看資料庫內容


    }
}
