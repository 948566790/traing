package com.ucar.training.dao;

import com.ucar.training.domain.Menu;
import com.ucar.training.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RoleMapper {
    /**
     * 返回所有角色
     *
     * @return 所有角色列表
     */
    List<Role> getRoles();

    /**
     * 通过id查询并返回角色
     *
     * @param id 角色id
     * @return 对应的角色
     */
    Role getRoleById(String id);

    /**
     * 通过角色名称查询并返回角色
     *
     * @param roleName 角色名称
     * @return 对应的角色
     */
    Role getRoleByName(String roleName);

    /**
     * 增加角色
     *
     * @param role 增加的角色对象
     * @return 更新行数
     */
    int addRole(Role role);

    /**
     * 通过id删除角色
     *
     * @param id 角色id
     * @return 更新行数
     */
    int delRole(String id);

    /**
     * 通过id删除角色权限
     *
     * @param id 角色id
     * @return 更新行数
     */
    int delRoleMenu(String id);

    /**
     * 修改角色信息
     *
     * @param role 角色对象
     * @return 更新行数
     */
    int changeRole(Role role);

    /**
     * 增加角色权限
     *
     * @param roleId 角色对象ID
     * @param menuId 菜单对象ID
     * @return 更新行数
     */
    int addRoleMenu(long roleId, long menuId);
}
