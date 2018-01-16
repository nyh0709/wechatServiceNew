package com.nyh.app.provider.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.nyh.app.provider.config.UserIdProperty;
import com.nyh.app.provider.interceptor.impl.UserIdInterceptor;


/**
 * WebMvcConfigurer
 */
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
    private UserIdInterceptor userIdInterceptor;
    
    @Autowired
    private UserIdProperty userIdProperty;
    
    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        if(userIdProperty.isAuthEnable()){
            registry.addInterceptor(userIdInterceptor).addPathPatterns("/**")
                .excludePathPatterns(userIdProperty.getExcludePath().split(","));
        }


    }

}
