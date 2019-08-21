package com.ucar.training.service.impl;

import com.ucar.training.dao.MenuMapper;
import com.ucar.training.domain.Menu;
import com.ucar.training.service.MenuService;

import java.util.List;

public class MenuServiceImpl implements MenuService {
    private MenuMapper menuMapper;

    public MenuMapper getMenuMapper() {
        return menuMapper;
    }

    public void setMenuMapper(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }


    @Override
    public List<Menu> selMenuByIdService(String id) {
        return menuMapper.selMenuById(id);
    }

    @Override
    public List<Menu> getMenusService() {
        return menuMapper.getMenus();
    }

    @Override
    public int delMenuService(String menuId) {
        //根据id删除菜单表中的菜单
        menuMapper.delMenu(menuId);
        //根据id删除角色权限表中的菜单
        menuMapper.delMenuRole(menuId);
        return 0;
    }

    @Override
    public int addMenuService(Menu menu) {
        return menuMapper.addMenu(menu);
    }

    @Override
    public int changeMenu(Menu menu) {
        return menuMapper.changeMenu(menu);
    }

    @Override
    public Menu getMenuById(String menuId) {
        return menuMapper.getMenuById(menuId);
    }

}
