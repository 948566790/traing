package com.ucar.training.controller;

import com.ucar.training.dao.MessageMapper;
import com.ucar.training.domain.Message;
import com.ucar.training.domain.User;
import com.ucar.training.service.MessageService;
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
import java.util.Date;

/**
 * 保存用户留言
 */
@WebServlet(name = "MessageServlet", urlPatterns = "/mg")
public class MessageServlet extends HttpServlet {
    private MessageService messageService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext wc = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        messageService = wc.getBean("messageService", MessageService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求数据
        String message = req.getParameter("message");
        String uname = req.getParameter("uname");
        //处理
        messageService.saveMsgService(uname, message);

        //获取当前用户所有留言
        req.getSession().setAttribute("umessages", messageService.getUserMsgService(uname));
        req.getSession().setAttribute("allmessages", messageService.getAllMsgService());

        //刷新
        resp.setHeader("refresh", "0.05;url=pages/user/usermsg.jsp");
    }
}
