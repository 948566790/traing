package com.ucar.training.controller;

import com.ucar.training.service.impl.MessageServiceImpl;
import com.ucar.training.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除用户留言（仅超级用户可用）
 */
@WebServlet(name = "MsgDelServlet", urlPatterns = "/delmsg")
public class MsgDelServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求数据
        String uname = req.getParameter("uname");
        String date = req.getParameter("date");
        //处理
        MessageServiceImpl ms = new MessageServiceImpl();
        ms.msgDelService(uname, date);
        req.getSession().setAttribute("allmessages", ms.getAllMsgService());
        resp.setHeader("refresh", "0.05;url=pages/root/rootmsg.jsp");
    }
}
