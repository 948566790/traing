package com.ucar.training.service;

import com.ucar.training.domain.Menu;

import java.util.List;

public interface MenuService {
    /**
     * 根据角色id从角色_权限表中获取菜单对象
     *
     * @param id 角色id
     * @return 角色对应的菜单列表
     */
    public List<Menu> selMenuByIdService(String id);

    /**
     * 获取全部菜单
     *
     * @return 菜单列表
     */
    public List<Menu> getMenusService();

    /**
     * 根据菜单id删除所有菜单
     *
     * @param menuId 菜单id
     * @return 更新行数
     */
    public int delMenuService(String menuId);

    /**
     * 添加菜单
     *
     * @param menu 菜单对象
     * @return 更新行数
     */
    public int addMenuService(Menu menu);

    /**
     * 修改菜单
     *
     * @param menu 菜单对象
     * @return 更新行数
     */
    public int changeMenu(Menu menu);

    /**
     * 根据菜单id返回菜单
     *
     * @param menuId 菜单id
     * @return 返回的菜单
     */
    public Menu getMenuById(String menuId);
}
