package oldtraining.controller;

import oldtraining.service.impl.RootUserServiceImpl;

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
        System.out.println("delmsg:uname:" + uname + "   date:" + date);
        //处理
        RootUserServiceImpl rus = new RootUserServiceImpl();
        rus.msgDelService(uname, date);
        resp.setHeader("refresh", "0.05;url=pages/root/rootmsg.jsp");
    }
}
