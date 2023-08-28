package com.ddit.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("실행됐는지 check");
        registry.addResourceHandler("/kmerong/**")             // 웹 접근 경로
                .addResourceLocations("file:///Users/soyeonlee/Dev/test-folder/upload/");  // 서버내 실제 경로
    }
}
