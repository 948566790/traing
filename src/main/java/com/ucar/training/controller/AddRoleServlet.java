package com.ucar.training.controller;


import com.ucar.training.domain.Menu;
import com.ucar.training.domain.Role;
import com.ucar.training.domain.User;
import com.ucar.training.service.RoleService;
import com.ucar.training.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 增加角色及角色权限
 */


@WebServlet(name = "AddRoleServlet", urlPatterns = "/addrole")
public class AddRoleServlet extends HttpServlet {
    private RoleService roleService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        roleService = context.getBean("roleService", RoleService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //接受请求数据
        String roleName = req.getParameter("rolename");
        String[] menuId = req.getParameterValues("menu");
        //将请求数据保存在Role
        List<Menu> menus = new ArrayList<Menu>();
        for (String m : menuId) {
            Menu menu = new Menu();
            menu.setMenuId(Integer.parseInt(m));
            menus.add(menu);
        }
        Role role = new Role();
        role.setRoleName(roleName);
        role.setMenus(menus);
        //创建业务层对象,处理请求数据
        roleService.addRoleService(role);
        req.getSession().setAttribute("roles", roleService.getRolesService());
        //定时刷新，跳转页面
        resp.getWriter().write("<h3>添加成功，即将返回！！!</h3>");
        resp.setHeader("refresh", "1;url=pages/user/addrole.jsp");
    }
}
