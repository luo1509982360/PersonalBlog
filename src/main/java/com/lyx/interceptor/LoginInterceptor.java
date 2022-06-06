package com.lyx.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.*;

/**
 * @author The setting sun
 * @version 1.0
 * @title: LoginInterceptor
 * @description: TODO
 * @date 2022/5/13 19:13
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        if (session.getAttribute("user") == null) {
            response.sendRedirect("/admin");

            return false;
        }

        return true;
    }
}
