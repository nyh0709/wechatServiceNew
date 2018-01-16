package com.nyh.app.core.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Web上下文
 */
public class WebContext {

    // request hodler
    private static ThreadLocal<HttpServletRequest> requestHodler = new ThreadLocal<HttpServletRequest>();
    // response hodler
    private static ThreadLocal<HttpServletResponse> responseHodler = new ThreadLocal<HttpServletResponse>();
    
    private static ThreadLocal<String> userIdHodler = new ThreadLocal<String>();

    /**
     * 当前线程绑定request response对象
     * 
     * @param request
     * @param response
     */
    public static void init(HttpServletRequest request, HttpServletResponse response) {
        requestHodler.set(request);
        responseHodler.set(response);
    }

    
    public static void initUserId(String userId) {
    	userIdHodler.set(userId);
    }

    public static String getUserId() {
        return userIdHodler.get();
    }

    public static HttpServletRequest getHttpServletRequest() {
        return requestHodler.get();
    }

    public static HttpServletResponse getHttpServletResponse() {
        return responseHodler.get();
    }

    
    /**
     * 销毁当前线程绑定的资源
     */
    public static void destory() {
        requestHodler.remove();
        responseHodler.remove();
        userIdHodler.remove();
    }
}
