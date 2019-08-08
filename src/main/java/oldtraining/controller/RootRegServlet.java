package oldtraining.controller;

import oldtraining.domain.RootUser;
import oldtraining.service.impl.RootUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 超级用户注册
 */
@WebServlet(name = "RootRegServlet", urlPatterns = "/rreg")
public class RootRegServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //接受请求数据
        String rname = req.getParameter("uname");
        String rpwd = req.getParameter("pwd");
        RootUser root = new RootUser(rname, rpwd);
        //创建业务层对象,处理请求数据
        RootUserServiceImpl rus = new RootUserServiceImpl();
        rus.rootRegService(root);

        //定时刷新，跳转页面
        resp.getWriter().write("<h3>超级用户注册成功，即将跳转到注册页面！！!</h3>");
        resp.setHeader("refresh", "1;url=pages/user/register.jsp");
    }
}
