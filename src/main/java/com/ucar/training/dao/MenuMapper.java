package com.ucar.training.dao;

import com.ucar.training.domain.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MenuMapper {
    /**
     * 根据角色id从角色_权限表中获取菜单对象
     *
     * @param id 角色id
     * @return 角色对应的菜单列表
     */
    List<Menu> selMenuById(String id);

    /**
     * 获取全部菜单
     *
     * @return 菜单列表
     */
    List<Menu> getMenus();

    /**
     * 根据菜单id删除菜单
     *
     * @param menuId 菜单id
     * @return 更新行数
     */
    int delMenu(String menuId);

    /**
     * 根据菜单id删除角色权限表中的菜单
     *
     * @param menuId 菜单id
     * @return 更新行数
     */
    int delMenuRole(String menuId);

    /**
     * 添加菜单
     *
     * @param menu 菜单对象
     * @return 更新行数
     */
    int addMenu(Menu menu);

    /**
     * 修改菜单
     *
     * @param menu 菜单对象
     * @return 更新行数
     */
    int changeMenu(Menu menu);

    /**
     * 根据菜单id返回菜单
     *
     * @param menuId 菜单id
     * @return 返回的菜单
     */
    Menu getMenuById(String menuId);
}
