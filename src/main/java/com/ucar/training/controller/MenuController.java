package com.ucar.training.controller;


import com.ucar.training.domain.Menu;
import com.ucar.training.domain.User;
import com.ucar.training.service.MenuService;
import com.ucar.training.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class MenuController {
    @Resource
    private MenuService menuServiceImpl;

    @Resource
    private UserService userServiceImpl;

    @RequestMapping("managemenu/{uname}")
    public String manageMenu(@PathVariable String uname, HttpServletRequest request) {
        User user = userServiceImpl.getUserInfoService(uname);
        request.setAttribute("menus", menuServiceImpl.selMenuByIdService(user.getRoleId()));
        request.setAttribute("allmenus", menuServiceImpl.getMenusService());
        return "managemenu";
    }

    @RequestMapping("menuinfo/{menuid}")
    public String menuInfo(@PathVariable String menuid, HttpServletRequest request) {
        request.setAttribute("menu", menuServiceImpl.getMenuById(menuid));
        return "changemenu";
    }

    @RequestMapping("updmenu")
    public String updMenu(Menu menu, HttpServletRequest request) {
        menuServiceImpl.changeMenu(menu);
        return "forward:/managemenu/" + request.getSession().getAttribute("username");
    }

    @RequestMapping("delmenu/{menuid}")
    public String delMenu(@PathVariable String menuid, HttpServletRequest request) {
        menuServiceImpl.delMenuService(menuid);
        return "forward:/managemenu/" + request.getSession().getAttribute("username");
    }

    @RequestMapping("addmenu")
    public void addMenu(Menu menu, HttpServletResponse response) throws IOException {
        menuServiceImpl.addMenuService(menu);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<h3>添加成功，即将返回！！!</h3>");
        response.setHeader("refresh", "1;url=pages/user/addmenu.jsp");
    }

}
