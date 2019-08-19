package com.ucar.training.controller;

import com.ucar.training.service.UserService;
import com.ucar.training.service.impl.UserServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除用户信息（仅超级用户可用）
 */
@WebServlet(name = "DelUserServlet", urlPatterns = "/del")
public class DelUserServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = context.getBean("userService", UserService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求数据
        String uname = req.getParameter("uname");
        //处理
        userService.userDelService(uname);
        req.getSession().setAttribute("users", userService.getUSersService());
        resp.setHeader("refresh", "0.05;url=pages/root/rootlogin.jsp");
    }
}
