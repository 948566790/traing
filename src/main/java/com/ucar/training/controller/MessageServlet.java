package com.ucar.training.controller;

import com.ucar.training.domain.User;
import com.ucar.training.service.impl.MessageServiceImpl;
import com.ucar.training.service.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 保存用户留言
 */
@WebServlet(name = "MessageServlet", urlPatterns = "/mg")
public class MessageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求数据
        String message = req.getParameter("message");
        String uname = req.getParameter("uname");
        //处理
        MessageServiceImpl ms = new MessageServiceImpl();
        ms.saveMsgService(uname, message);

        //获取当前用户所有留言
        req.getSession().setAttribute("umessages", ms.getUserMsgService(uname));
        req.getSession().setAttribute("allmessages", ms.getAllMsgService());

        //刷新
        resp.setHeader("refresh", "0.05;url=pages/user/userlogin.jsp");
    }
}
