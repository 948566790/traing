package com.ucar.training.controller;

import com.ucar.training.domain.Role;
import com.ucar.training.service.RoleService;
import com.ucar.training.service.impl.RoleServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 获取所有角色信息
 */
@WebServlet(name = "GetAllRolesServlet", urlPatterns = "/getroles")
public class GetAllRolesServlet extends HttpServlet {
    private RoleService roleService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        roleService = context.getBean("roleService", RoleServiceImpl.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求
        //处理
        List<Role> roles = roleService.getRolesService();
        //请求转发
        if (roles != null) {
            req.setAttribute("roles", roles);
            req.getRequestDispatcher("pages/user/register2.jsp").forward(req, resp);
        }
        return;
    }
}
