package com.ucar.training.controller;

import com.ucar.training.domain.User;
import com.ucar.training.service.impl.UserServiceImpl;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 登陆
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        //获取请求数据
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        //处理
        UserServiceImpl us = new UserServiceImpl();
        User u = us.userCheckPwdService(uname, pwd);
        if (u != null) {//登陆成功
            this.getServletContext().setAttribute("user", u);
            req.setAttribute("username", u.getUname());
            resp.sendRedirect("pages/user/userlogin.jsp");
            return;
        } else {//用户名不存在或密码错误
            resp.getWriter().write("<script language='javascript'>alert('用户名或密码不正确！！！');window.location.href='pages/user/login.jsp';</script>");
            return;
        }
    }

    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        return sdf.format(date);
    }
}