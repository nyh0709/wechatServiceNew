package com.nyh.app.provider.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**  
 * userId校验属性
 */
@Configuration
@ConfigurationProperties(prefix = "wechatService.userId")
@Getter
@Setter
public class UserIdProperty {
    /**
     * 是否开启token验证
     */
    private boolean authEnable;
    
    /**
     * 不需要验证的请求路径
     */
    private String excludePath;
    
}
