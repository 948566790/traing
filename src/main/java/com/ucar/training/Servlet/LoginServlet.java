package com.ucar.training.Servlet;

import com.ucar.training.domain.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

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
        ServletContext sc = this.getServletContext();
        boolean flag = false;
        Set<User> users = (Set<User>) sc.getAttribute("users");
        if (users != null) {
            for (User u : users) {
                if (uname.equals(u.getUname())) {
                    flag = true;
                    if (pwd.equals(u.getPwd())) {
                        //用户名存在且密码正确,即登陆成功
                        req.getSession().setAttribute("user", u);
                        req.setAttribute("username", u.getUname());
                        //System.out.println("session-->"+req.getSession().getAttribute("user"));
                        req.getRequestDispatcher("message.jsp").forward(req, resp);
                        return;
                    } else {//密码不正确
                        flag = false;
                        break;
                    }
                }
            }
        }
        if (!flag) {
            //用户名不存在或密码错误
            resp.getWriter().write("<script language='javascript'>alert('用户名或密码不正确！！！');window.location.href='login.jsp';</script>");
            return;
        }
    }
}
