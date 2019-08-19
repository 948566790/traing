package com.ucar.training.controller;

import com.ucar.training.domain.User;
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
 * 通过用户名获取用户对象
 */
@WebServlet(name = "GetUserInfoServlet", urlPatterns = "/info")
public class GetUserInfoServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = context.getBean("userService", UserService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");

        //处理
        User u = userService.getUserInfoService(uname);
        if (u != null) {
            req.setAttribute("user", u);
            req.getRequestDispatcher("pages/root/changeuser.jsp").forward(req, resp);
        }

    }
}
