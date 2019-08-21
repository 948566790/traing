package com.ucar.training.controller;

import com.ucar.training.service.MenuService;
import com.ucar.training.service.RoleService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除菜单
 */
@WebServlet(name = "DelMenuServlet", urlPatterns = "/delmenu")
public class DelMenuServlet extends HttpServlet {
    private MenuService menuService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        menuService = context.getBean("menuService", MenuService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求数据
        String menuId = req.getParameter("menuid");
        //处理
        menuService.delMenuService(menuId);
        req.getSession().setAttribute("allmenus", menuService.getMenusService());
        resp.setHeader("refresh", "0.05;url=pages/user/managemenu.jsp");
    }
}
