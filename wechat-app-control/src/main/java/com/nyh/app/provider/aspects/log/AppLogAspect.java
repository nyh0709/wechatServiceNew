package com.nyh.app.provider.aspects.log;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

/**
 * <strong>Order</strong> 定义切面执行的优先级，数字越低，优先级越高 <br>
 * 在切入点之前执行：按order值有小到大的顺序执行  <br>
 * 在切入点之后执行：按order值由大到小的顺序执行
 */
@Component
@Aspect
@Order(-5)
@Slf4j
public class AppLogAspect {

    // 保证每个线程都有一个单独的实例
    //private ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    @Pointcut("execution(* com.nyh.app.provider.controller.*.*.*(..))")
    public void log() {
    }
    
    @Around("log()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();


        // result的值就是被拦截方法的返回值
        long startTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        long endTime = System.currentTimeMillis();
        Gson gson = new Gson();

        log.info("【Request URL】: {}; 【Request Method】: {}; 【IP】: {}; 【User-Agent】: {}; 【Class Method】: {}; 【Cookies】: {}; 【Params】: {}; 【Result】：{}; 【耗时】: {}", 
    			request.getRequestURL().toString(), 
    			request.getMethod(), 
    			request.getRemoteAddr(), 
    			request.getHeader("User-Agent"), 
    			pjp.getSignature().getDeclaringTypeName() + "."  + pjp.getSignature().getName(), 
    			request.getCookies(), 
    			Arrays.toString(pjp.getArgs()), 
    			gson.toJson(result),
		        endTime - startTime + "ms");
        return result;
    }
    
    

//    @Before("log()")
//    public void doBefore(JoinPoint joinPoint) {
//    	Map<String, Object> map = new HashMap<String, Object>();
//    	map.put("startTime",System.currentTimeMillis());
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        map.put("request",request);
//        threadLocal.set(map);
//        // 记录请求的内容
//        log.info("执行前 Request URL: {};Request Method: {};IP: {};User-Agent:{};Class Method:{};Cookies:{};Params:{}", request.getRequestURL().toString(), request.getMethod(), request.getRemoteAddr(), request.getHeader("User-Agent"), joinPoint.getSignature().getDeclaringTypeName() + "."  + joinPoint.getSignature().getName(), request.getCookies(), Arrays.toString(joinPoint.getArgs()));
//        Enumeration<String> enums = request.getParameterNames();
//        while (enums.hasMoreElements()) {
//            String paraName = enums.nextElement();
//            log.info(paraName + ":" + request.getParameter(paraName));
//        }
//    }
//
//    @After("log()")
//    public void doAfter(JoinPoint joinPoint) {
//        log.info("doAfter():{}", joinPoint.toString());
//    }
//
//    @AfterReturning("log()")
//    public void doAfterReturning(JoinPoint joinPoint) {
//    	HttpServletRequest request = (HttpServletRequest)threadLocal.get().get("request");
//    }
}
