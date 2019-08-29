package com.ucar.training.controller;


import com.ucar.training.domain.Menu;
import com.ucar.training.domain.Role;
import com.ucar.training.domain.User;
import com.ucar.training.service.MenuService;
import com.ucar.training.service.RoleService;
import com.ucar.training.service.UserService;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RoleController {
    @Resource
    private RoleService roleServiceImpl;

    @Resource
    private MenuService menuServiceImpl;

    @Resource
    private UserService userServiceImpl;

    @RequestMapping("managerole/{uname}")
    public String managerole(@PathVariable String uname, HttpServletRequest request) {
        User user = userServiceImpl.getUserInfoService(uname);
        request.setAttribute("menus", menuServiceImpl.selMenuByIdService(user.getRoleId()));
        request.setAttribute("roles", roleServiceImpl.getRolesService());
        return "managerole";
    }

    @RequestMapping("getroles2")
    public String getRoles(HttpServletRequest req) {
        req.setAttribute("roles", roleServiceImpl.getRolesService());
        return "register2";
    }

    @RequestMapping("delrole/{roleId}")
    public String delRole(@PathVariable String roleId, HttpServletRequest request) {
        roleServiceImpl.delRoleService(roleId);
        return "forward:/managerole/" + request.getSession().getAttribute("username");
    }

    @RequestMapping("updrole")
    public String updRole(Role role, @RequestParam("menu") List<String> menu, HttpServletRequest request) {
        List<Menu> menus = new ArrayList<Menu>();
        for (String m : menu) {
            Menu mm = new Menu();
            mm.setMenuId(Integer.parseInt(m));
            menus.add(mm);
        }
        role.setMenus(menus);
        roleServiceImpl.changeRoleService(role);
        return "forward:/managerole/" + request.getSession().getAttribute("username");
    }

    @RequestMapping("befaddrole")
    public String befAddRole(HttpServletRequest request) {
        request.setAttribute("allmenus", menuServiceImpl.getMenusService());
        return "addrole";
    }

    @RequestMapping("addrole")
    public String addRole(Role role, @RequestParam("menu") List<String> menu, HttpServletRequest request) {
        List<Menu> menus = new ArrayList<Menu>();
        for (String m : menu) {
            Menu mm = new Menu();
            mm.setMenuId(Integer.parseInt(m));
            menus.add(mm);
        }
        role.setMenus(menus);
        System.out.println("role:" + role);
        roleServiceImpl.addRoleService(role);
        return "forward:/managerole/" + request.getSession().getAttribute("username");
    }

    @RequestMapping("roleinfo/{roleId}")
    public String roleInfo(@PathVariable String roleId, HttpServletRequest request) {
        Role role = roleServiceImpl.getRoleByIdService(roleId);
        //获取角色的菜单名称
        List<String> menusName = new ArrayList<String>();
        for (Menu menu : role.getMenus()) {
            menusName.add(menu.getMenuName());
        }
        request.setAttribute("menusName", menusName);
        request.setAttribute("role", roleServiceImpl.getRoleByIdService(roleId));
        request.setAttribute("allmenus", menuServiceImpl.getMenusService());
        return "changerole";
    }
}
