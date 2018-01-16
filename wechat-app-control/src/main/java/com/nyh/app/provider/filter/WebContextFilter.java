package com.nyh.app.provider.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.nyh.app.core.context.WebContext;

/**
 * 初始化Web上下文
 */
@Component
public class WebContextFilter extends OncePerRequestFilter {

    /**
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     * @see org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        WebContext.init(request, response);
//        WebContext.initUserId(request.getHeader(AppConstant.WX_HEADER_USER_ID));
        try {
            filterChain.doFilter(request, response);
        } finally {
            WebContext.destory();
        }
    }
}
