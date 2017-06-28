package com.example.demo.config;

import com.example.demo.Interceptor.URLInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by tianxianglan on 2017/6/2.
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter{

    @Bean
    URLInterceptor urlInterceptor(){
        return new URLInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(urlInterceptor()).addPathPatterns("/**");
    }
}
