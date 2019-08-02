package com.ucar.training.Servlet;

import com.ucar.training.domain.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "RegisterServlet", urlPatterns = "/rs")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //接受请求数据
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String age = req.getParameter("age");
        String sex = req.getParameter("sex");
        String tel = req.getParameter("tel");
        String email = req.getParameter("mail");
        String[] fav = req.getParameterValues("fav");
        String sign = req.getParameter("sign");

        //处理请求数据
        User u = new User(uname, pwd, age, sex, tel, email, fav, sign);
        System.out.println(u);
        ServletContext sc = this.getServletContext();
        Set<User> users = (Set<User>) sc.getAttribute("users");
        if (users == null) {
            users = new HashSet<User>();
        } else {
            for (User v : users) {
                System.out.println(v);
            }
        }
        users.add(u);
        sc.setAttribute("users", users);
        resp.getWriter().write("<h3>注册成功，即将跳转到注册页面！！!</h3>");
        //定时刷新，跳转页面
        resp.setHeader("refresh", "3;url=register.jsp");
    }
}
