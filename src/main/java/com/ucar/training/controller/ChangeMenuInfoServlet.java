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
 * 修改菜单信息
 */
@WebServlet(name = "ChangeMenuInfoServlet", urlPatterns = "/savemenu")
public class ChangeMenuInfoServlet extends HttpServlet {
    private MenuService menuService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        menuService = context.getBean("menuService", MenuService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求数据
        String menuId = req.getParameter("menuid");
        String menuName = req.getParameter("menuname");
        String url = req.getParameter("url");
        //处理
        //保存
        Menu menu = menuService.getMenuById(menuId);
        if (menu != null) {
            menu.setMenuName(menuName);
            menu.setUrl(url);
        }
        menuService.changeMenu(menu);
        req.getSession().setAttribute("allmenus", menuService.getMenusService());
        resp.sendRedirect("pages/user/managemenu.jsp");
        return;
    }
}
