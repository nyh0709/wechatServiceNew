package com.nyh.app.provider.interceptor.impl;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.nyh.app.common.constant.AppConstant;
import com.nyh.app.core.context.WebContext;
import com.nyh.app.core.orm.userInfo.domain.UserInfo;
import com.nyh.app.core.service.userInfo.UserInfoService;
import com.nyh.app.provider.anotation.IgnoreUserId;

import lombok.extern.slf4j.Slf4j;

/**
 * token验证拦截器
 */
@Slf4j
@Component
public class UserIdInterceptor extends HandlerInterceptorAdapter {
    
    
    @Autowired
    private UserInfoService userInfoService;
    
    
    /**
     * token校验
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String uri = request.getRequestURI();
        log.info("requestURI:{}",uri);
        try{
            // 请求类型
            String requestMethod = request.getMethod();
            if ("OPTIONS".equals(requestMethod)) {
                return true;
            }
            if (!(handler instanceof HandlerMethod)) {
                return true;
            }
            // 从切点上获取目标方法
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            // 若目标方法忽略了安全性检查，则直接调用目标方法
            if (method.isAnnotationPresent(IgnoreUserId.class)) {
                return true;
            }
            
            String userId = request.getHeader(AppConstant.WX_HEADER_USER_ID);

            log.info("传入的userId值 {}", userId);
            if (StringUtils.isEmpty(userId)) {
                log.info("当前请求userId为 null值");
                setUnAuth(response);
                return false;
            }
            
            UserInfo userInfo = userInfoService.findOne(userId);
            
            if (userInfo == null) {
            	log.info("当前请求userId不存在");
                setUnAuth(response);
                return false;
			}
            
            WebContext.initUserId(userId);

            return true;
        } catch (Exception e) {
        	response.setStatus(HttpStatus.UNAUTHORIZED.value());
        	log.error("拦截器异常：{}", e.getMessage(), e);
        }
        return false;
    }
    
	/**
     * 401返回
     * @param response
     * @throws IOException
     */
    private void setUnAuth(HttpServletResponse response) throws IOException{
    	response.setCharacterEncoding("utf-8");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().append("{\"code\":401,\"message\":\"请先登录!\"}");
    }
    
    
}
