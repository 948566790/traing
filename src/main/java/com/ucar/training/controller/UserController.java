package com.ucar.training.controller;

import com.ucar.training.domain.Menu;
import com.ucar.training.domain.Role;
import com.ucar.training.domain.User;
import com.ucar.training.service.MenuService;
import com.ucar.training.service.MessageService;
import com.ucar.training.service.RoleService;
import com.ucar.training.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userServiceImpl;
    @Resource
    private MessageService messageServiceImpl;
    @Resource
    private RoleService roleServiceImpl;
    @Resource
    private MenuService menuServiceImpl;

    @RequestMapping("userinfo/{uname}")
    public String userInfo(@PathVariable String uname, HttpServletRequest request) {
        User user = userServiceImpl.getUserInfoService(uname);
        request.setAttribute("menus", menuServiceImpl.selMenuByIdService(user.getRoleId()));
        request.setAttribute("user", userServiceImpl.getUserInfoService(uname));
        return "userinfo";
    }

    @RequestMapping("manageuser/{uname}")
    public String manageUser(@PathVariable String uname, HttpServletRequest request) {
        User user = userServiceImpl.getUserInfoService(uname);
        request.setAttribute("menus", menuServiceImpl.selMenuByIdService(user.getRoleId()));
        request.setAttribute("users", userServiceImpl.getUSersService());
        return "manageuser";
    }

    @RequestMapping("login")
    public String login(String uname, String pwd, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User u = userServiceImpl.userCheckPwdService(uname, pwd);
        if (u != null) {//登陆成功
            request.getSession().setAttribute("username", uname);
            List<User> users = userServiceImpl.getUSersService();
            request.setAttribute("user", u);
            //获取相应菜单
            request.setAttribute("menus", menuServiceImpl.selMenuByIdService(u.getRoleId()));
            return "userinfo";
        } else {//用户名不存在或密码错误
            response.getWriter().write("<script language='javascript'>alert('用户名或密码不正确！！！');window.location.href='pages/user/login.jsp';</script>");
            return null;
        }
    }

    @RequestMapping("register")
    public void register(User user, HttpServletResponse resp) throws IOException {
        userServiceImpl.userRegService(user);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("<h3>注册成功，即将跳转到注册页面！！!</h3>");
        resp.setHeader("refresh", "1;url=getroles2");
    }

    @RequestMapping("befupduser/{uname}")
    public String befUpdUser(@PathVariable String uname, HttpServletRequest request) {
        request.setAttribute("user", userServiceImpl.getUserInfoService(uname));
        request.setAttribute("roles", roleServiceImpl.getRolesService());
        return "changeuser";
    }

    @RequestMapping("upduser")
    public String updUser(User user, HttpServletRequest request) {
        userServiceImpl.userChangeService(user);
        return "forward:/manageuser/" + request.getSession().getAttribute("username");
    }

    @RequestMapping("deluser/{uname}")
    public String delUser(@PathVariable String uname, HttpServletRequest request) {
        userServiceImpl.userDelService(uname);
        return "forward:/manageuser/" + request.getSession().getAttribute("username");
    }
}
