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
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

/**
 * Ajax用来检查是否存在重名
 */
@WebServlet(name = "AjaxServlet", urlPatterns = "/checkname")
public class AjaxServlet extends HttpServlet {
    private UserService userService;


    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = context.getBean("userService", UserService.class);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取请求数据
        String uname = request.getParameter("userName");
        //处理
        PrintWriter out = response.getWriter();
        List<User> users = userService.getUSersService();
        if (users != null) {
            for (User u : users) {
                if (u.getUname().equals(uname)) {
                    out.print(true);
                    break;
                }
            }
        } else {
            out.print(false);
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
