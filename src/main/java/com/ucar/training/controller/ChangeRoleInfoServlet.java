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
 * 修改角色信息
 */
@WebServlet(name = "ChangeRoleInfoServlet", urlPatterns = "/saverole")
public class ChangeRoleInfoServlet extends HttpServlet {
    private RoleService roleService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        roleService = context.getBean("roleService", RoleService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求数据
        String roleId = req.getParameter("roleid");
        String roleName = req.getParameter("rolename");
        String[] menuId = req.getParameterValues("menu");
        //处理
        //保存修改的菜单信息为菜单列表
        List<Menu> menus = new ArrayList<Menu>();
        for (String m : menuId) {
            Menu menu = new Menu();
            menu.setMenuId(Integer.parseInt(m));
            menus.add(menu);
        }
        //获取角色对象
        Role role = roleService.getRoleByIdService(roleId);
        if (role != null) {
            role.setRoleName(roleName);
            role.setMenus(menus);
        }
        roleService.changeRoleService(role);
        req.getSession().setAttribute("roles", roleService.getRolesService());
        resp.sendRedirect("pages/user/managerole.jsp");
        return;
    }
}
