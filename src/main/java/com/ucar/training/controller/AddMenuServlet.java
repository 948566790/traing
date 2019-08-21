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
 * 增加菜单
 */


@WebServlet(name = "AddMenuServlet", urlPatterns = "/addmenu")
public class AddMenuServlet extends HttpServlet {
    private MenuService menuService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        menuService = context.getBean("menuService", MenuService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //接受请求数据
        String menuName = req.getParameter("menuname");
        String url = req.getParameter("url");
        //将请求数据保存在Menu
        Menu menu = new Menu();
        menu.setMenuName(menuName);
        menu.setUrl(url);
        //创建业务层对象,处理请求数据
        menuService.addMenuService(menu);
        req.getSession().setAttribute("allmenus", menuService.getMenusService());
        //定时刷新，跳转页面
        resp.getWriter().write("<h3>添加成功，即将返回！！!</h3>");
        resp.setHeader("refresh", "1;url=pages/user/addmenu.jsp");
    }
}
