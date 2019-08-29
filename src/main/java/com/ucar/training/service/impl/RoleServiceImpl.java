package com.ucar.training.service.impl;

import com.ucar.training.dao.RoleMapper;
import com.ucar.training.domain.Menu;
import com.ucar.training.domain.Role;
import com.ucar.training.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRolesService() {
        return roleMapper.getRoles();
    }

    @Override
    public Role getRoleByIdService(String id) {
        return roleMapper.getRoleById(id);
    }

    @Override
    public Role getRoleByNameService(String roleName) {
        return roleMapper.getRoleByName(roleName);
    }

    @Override
    public int addRoleService(Role role) {
        //增加角色
        int i = roleMapper.addRole(role);
        if (i != 0) {
            //获取角色id
            long roidId = roleMapper.getRoleByName(role.getRoleName()).getRoleId();
            //增加角色权限
            List<Menu> menus = role.getMenus();
            for (Menu menu : menus) {
                roleMapper.addRoleMenu(roidId, menu.getMenuId());
            }
        }
        return 1;
    }

    @Override
    public int delRoleService(String id) {
        //删除角色
        roleMapper.delRole(id);
        //删除角色权限
        roleMapper.delRoleMenu(id);
        return 1;
    }

    @Override
    public int changeRoleService(Role role) {
        roleMapper.delRoleMenu(String.valueOf(role.getRoleId()));
        roleMapper.changeRole(role);
        List<Menu> menus = role.getMenus();
        for (Menu menu : menus) {
            roleMapper.addRoleMenu(role.getRoleId(), menu.getMenuId());
        }
        return 1;
    }
}
