package oldtraining.controller;

import oldtraining.domain.User;
import oldtraining.service.impl.RootUserServiceImpl;
import oldtraining.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 修改用户信息（仅超级用户可用）
 */
@WebServlet(name = "ChangeInfoServlet", urlPatterns = "/save")
public class ChangeInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求数据
        String uname = req.getParameter("uname");
        String age = req.getParameter("age");
        String sex = req.getParameter("sex");
        String tel = req.getParameter("tel");
        String email = req.getParameter("mail");
        String sign = req.getParameter("sign");
        //处理
        UserServiceImpl us = new UserServiceImpl();
        //获取用户对象
        User u = us.getUserInfoService(uname);
        User user = new User(uname, u.getPwd(), age, sex, tel, email, u.getFav(), sign);
        //修改信息
        RootUserServiceImpl rus = new RootUserServiceImpl();
        rus.userChangeService(user);
        resp.sendRedirect("pages/root/rootlogin.jsp");
        return;
    }
}
