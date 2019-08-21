package com.ucar.training.controller;

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

/**
 * 删除角色及对应角色的角色权限
 */
@WebServlet(name = "DelRoleServlet", urlPatterns = "/delrole")
public class DelRoleServlet extends HttpServlet {
    private RoleService roleService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        roleService = context.getBean("roleService", RoleService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求数据
        String id = req.getParameter("id");
        //处理
        roleService.delRoleService(id);
        req.getSession().setAttribute("roles", roleService.getRolesService());
        resp.setHeader("refresh", "0.05;url=pages/user/managerole.jsp");
    }
}
