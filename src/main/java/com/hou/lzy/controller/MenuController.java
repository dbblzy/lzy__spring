package com.hou.lzy.controller;

import com.hou.lzy.dto.UserDTO;
import com.hou.lzy.pojo.AdminMenu;
import com.hou.lzy.service.AdminMenuService;
import com.hou.lzy.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    UserService userService;
    @Autowired
    AdminMenuService adminMenuService;



    @GetMapping("/api/menu")
    public List<AdminMenu> menu() {
        return adminMenuService.getMenusByCurrentUser();
    }

    @GetMapping("/api/admin/role/menu")
    public List<AdminMenu> listAllMenus(){
        List<AdminMenu> menus = adminMenuService.getMenusByRoleId(1);
        return menus;
    }

//    @RequiresPermissions("/api/admin/user")
//    @GetMapping("/api/admin/user")
//    public List<UserDTO> listUsers2() throws Exception{
//        return userService.list();
//    }

}
