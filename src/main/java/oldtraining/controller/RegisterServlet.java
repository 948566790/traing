package oldtraining.controller;

import oldtraining.dao.impl.UserDaoImpl;
import oldtraining.domain.User;
import oldtraining.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/rrs")
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
        String sex = req.getParameter("sex");
        String tel = req.getParameter("tel");
        String email = req.getParameter("mail");
        String[] fav = req.getParameterValues("fav");
        String sign = req.getParameter("sign");
        User u = new User(uname, pwd, age, sex, tel, email, fav, sign);

        //创建业务层对象,处理请求数据
        UserServiceImpl us = new UserServiceImpl();
        us.userRegService(u);
        this.getServletContext().setAttribute("users", UserDaoImpl.getUsers());

        //定时刷新，跳转页面
        resp.getWriter().write("<h3>注册成功，即将跳转到注册页面！！!</h3>");
        resp.setHeader("refresh", "1;url=pages/user/register.jsp");
    }
}
