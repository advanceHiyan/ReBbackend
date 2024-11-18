package com.readbook.readbookbackend.utils.filter;

import com.alibaba.fastjson.JSONObject;
import com.readbook.readbookbackend.utils.Result;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取请求的url
        String url = request.getRequestURI();
        log.info("请求url: " + url);
        //判断是否需要登录
        if(url.contains("login") || url.contains("signup")) {
            filterChain.doFilter(request, response);
            return;
        }
        //获取令牌
        String token = request.getHeader("userJwt");
        if(token == null || token.isEmpty()) {
            log.info("请求头没有jwt，请求url: " + url);
            Result result = Result.error("not login","000");
            String erg = JSONObject.toJSONString(result);
            response.getWriter().print(erg);
            return;
        }
        if(token.equals("open")) {
            log.info("token 有效，请求url: " + url);
            filterChain.doFilter(request, response);
            return;
        }
        //判断令牌是否有效
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            log.error("token 解析失败，请求url: " + url);
            Result result = Result.error("not login","000");
            String erg = JSONObject.toJSONString(result);
            response.getWriter().print(erg);
            return;
        }

        //如果令牌有效，则放行
        log.info("token 有效，请求url: " + url);
        filterChain.doFilter(request, response);
    }
}
