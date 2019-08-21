package com.ucar.training.controller;

import com.ucar.training.domain.User;
import com.ucar.training.service.MenuService;
import com.ucar.training.service.MessageService;
import com.ucar.training.service.RoleService;
import com.ucar.training.service.UserService;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 登陆
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login2")
public class LoginServlet extends HttpServlet {
    private UserService userService;
    private MessageService messageService;
    private MenuService menuService;
    private RoleService roleService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = context.getBean("userService", UserServiceImpl.class);
        messageService = context.getBean("messageService", MessageService.class);
        menuService = context.getBean("menuService", MenuService.class);
        roleService = context.getBean("roleService", RoleService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        //获取请求数据
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        //处理
        //MessageServiceImpl ms = new MessageServiceImpl();
        User u = userService.userCheckPwdService(uname, pwd);
        if (u != null) {//登陆成功
            List<User> users = userService.getUSersService();
                req.getSession().setAttribute("user", u);
                //获取当前用户所有留言
                req.getSession().setAttribute("umessages", messageService.getUserMsgService(uname));
                req.getSession().setAttribute("users", users);
            //获取所有留言
                req.getSession().setAttribute("allmessages", messageService.getAllMsgService());
            //获取相应菜单
            req.getSession().setAttribute("menus", menuService.selMenuByIdService(u.getRoleId()));
            //获取角色
            req.getSession().setAttribute("roles", roleService.getRolesService());
            //获取所有菜单
            req.getSession().setAttribute("allmenus", menuService.getMenusService());
            resp.sendRedirect("pages/user/userinfo.jsp");
                return;
        } else {//用户名不存在或密码错误
            resp.getWriter().write("<script language='javascript'>alert('用户名或密码不正确！！！');window.location.href='pages/user/login.jsp';</script>");
            return;
        }
    }
}
