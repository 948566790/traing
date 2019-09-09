package com.ming.springbootdemo.interceptor;

import com.ming.springbootdemo.pojo.User;
import com.ming.springbootdemo.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    private UserService userServiceImpl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = userServiceImpl.checkPwdService(request.getParameter("uname"), request.getParameter("pwd"));
        if (user == null) {
            response.setContentType("text/html;charset=utf8");
            response.getWriter().write("<script language='javascript'>alert('用户名或密码不正确！！！');window.location.href='/login';</script>");
            return false;
        } else {
            request.getSession().setAttribute("user", user);
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
