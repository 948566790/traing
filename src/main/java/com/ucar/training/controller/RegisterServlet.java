package com.ucar.training.controller;

import com.ucar.training.dao.impl.UserDaoImpl;
import com.ucar.training.domain.User;
import com.ucar.training.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "RegisterServlet", urlPatterns = "/rs2")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //接受请求数据
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String age = req.getParameter("age");
        String isRoot = req.getParameter("isroot");
        String sex = req.getParameter("sex");
        String tel = req.getParameter("tel");
        String email = req.getParameter("mail");
        String[] favs = req.getParameterValues("fav");
        String sign = req.getParameter("sign");
        //数组转换
        String fav = Arrays.toString(favs);
        User u = new User(uname, pwd, age, isRoot, sex, tel, email, fav, sign);


        //创建业务层对象,处理请求数据
        UserServiceImpl us = new UserServiceImpl();
        us.userRegService(u);

        this.getServletContext().setAttribute("users", us.getUSersService());

        //定时刷新，跳转页面
        resp.getWriter().write("<h3>注册成功，即将跳转到注册页面！！!</h3>");
        resp.setHeader("refresh", "1;url=pages/user/register2.jsp");
    }
}
