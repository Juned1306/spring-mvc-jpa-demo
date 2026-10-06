package com.mvc.interceptor;

import org.springframework.stereotype.Component;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String email = request.getParameter("email");

        if (email != null && email.contains("@gmail.com")) {
            return true; 
        }

        request.setAttribute("msg", "Email is invalid");
        request.getRequestDispatcher("/WEB-INF/view/errorPage.jsp").forward(request, response);
        return false; 
    }
}