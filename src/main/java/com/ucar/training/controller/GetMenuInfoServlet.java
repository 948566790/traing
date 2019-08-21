package com.ucar.training.controller;

import com.ucar.training.domain.Menu;
import com.ucar.training.domain.Role;
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
import java.util.ArrayList;
import java.util.List;

/**
 * 通过菜单id获取菜单
 */
@WebServlet(name = "GetMenuInfoServlet", urlPatterns = "/menuinfo")
public class GetMenuInfoServlet extends HttpServlet {
    private MenuService menuService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        menuService = context.getBean("menuService", MenuService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String menuId = req.getParameter("menuid");

        //处理
        Menu menu = menuService.getMenuById(menuId);
        if (menu != null) {
            req.setAttribute("menu", menu);
            req.getRequestDispatcher("pages/user/changemenu.jsp").forward(req, resp);
        }

    }
}
