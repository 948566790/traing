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
import java.util.List;

/**
 * 通过用户名获取用户对象
 */
@WebServlet(name = "GetRoleInfoServlet", urlPatterns = "/roleinfo")
public class GetRoleInfoServlet extends HttpServlet {
    private RoleService roleService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        roleService = context.getBean("roleService", RoleService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleId = req.getParameter("roleId");

        //处理
        Role role = roleService.getRoleByIdService(roleId);
        //获取角色的菜单名称
        List<String> menusName = new ArrayList<String>();
        for (Menu menu : role.getMenus()) {
            menusName.add(menu.getMenuName());
        }
        if (role != null) {
            req.setAttribute("role", role);
            req.setAttribute("menusName", menusName);
            req.getRequestDispatcher("pages/user/changerole.jsp").forward(req, resp);
        }

    }
}
