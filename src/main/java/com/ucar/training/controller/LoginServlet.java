package com.ucar.training.controller;

import com.ucar.training.domain.User;
import com.ucar.training.service.MessageService;
import com.ucar.training.service.UserService;
import com.ucar.training.service.impl.MessageServiceImpl;
import com.ucar.training.service.impl.UserServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 登陆
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login2")
public class LoginServlet extends HttpServlet {
    private UserService userService;
    private MessageService messageService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = context.getBean("userService", UserServiceImpl.class);
        messageService = context.getBean("messageService", MessageService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        //获取请求数据
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        //处理
        //MessageServiceImpl ms = new MessageServiceImpl();
        User u = userService.userCheckPwdService(uname, pwd);
        if (u != null) {//登陆成功
            if (u.getIsRoot().equals("2")) {//普通用户登录
                req.getSession().setAttribute("user", u);
                req.getSession().setAttribute("username", u.getUname());
                //获取当前用户所有留言
                req.getSession().setAttribute("umessages", messageService.getUserMsgService(uname));
                resp.sendRedirect("pages/user/userlogin.jsp");
                return;
            } else {//超级用户登陆
                List<User> users = userService.getUSersService();
                req.getSession().setAttribute("rootname", u.getUname());
                req.getSession().setAttribute("users", users);
                //获取当前用户所有留言
                req.getSession().setAttribute("allmessages", messageService.getAllMsgService());
                resp.sendRedirect("pages/root/rootlogin.jsp");
                return;
            }
        } else {//用户名不存在或密码错误
            resp.getWriter().write("<script language='javascript'>alert('用户名或密码不正确！！！');window.location.href='pages/user/login.jsp';</script>");
            return;
        }
    }
}
