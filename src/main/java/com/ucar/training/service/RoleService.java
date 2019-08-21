package com.ucar.training.service;

import com.ucar.training.domain.Menu;
import com.ucar.training.domain.Role;

import java.util.List;

public interface RoleService {
    /**
     * 获取所有角色
     *
     * @return
     */
    public List<Role> getRolesService();

    /**
     * 通过id查询并返回角色
     *
     * @param id 角色id
     * @return 对应的角色
     */
    public Role getRoleByIdService(String id);

    /**
     * 通过角色名称查询并返回角色
     *
     * @param roleName 角色名称
     * @return 对应的角色
     */
    Role getRoleByNameService(String roleName);


    /**
     * 增加角色和角色权限
     *
     * @param role 增加的角色对象
     * @return 更新行数
     */
    public int addRoleService(Role role);

    /**
     * 通过id删除角色
     *
     * @param id 角色id
     * @return 更新行数
     */
    public int delRoleService(String id);

    /**
     * 修改角色信息
     *
     * @param role 角色对象
     * @return 更新行数
     */
    public int changeRoleService(Role role);

}
