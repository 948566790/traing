package com.ucar.training;

import com.ucar.training.domain.Role;
import com.ucar.training.service.RoleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.List;

public class test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = ac.getBean("roleService", RoleService.class);
        /*List<Role> roles = roleService.getRolesService();
        System.out.println(roles);*/
        System.out.println(roleService.getRoleByIdService("1"));

    }
}
