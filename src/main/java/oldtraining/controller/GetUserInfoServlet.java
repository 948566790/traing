package oldtraining.controller;

import oldtraining.domain.User;
import oldtraining.service.impl.UserServiceImpl;

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
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");

        //处理
        UserServiceImpl us = new UserServiceImpl();
        User u = us.getUserInfoService(uname);
        if (u != null) {
            req.setAttribute("user", u);
            req.getRequestDispatcher("pages/root/changeuser.jsp").forward(req, resp);
        }

    }
}
