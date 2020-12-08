package com.hou.lzy.controller;


import com.hou.lzy.pojo.User;
import com.hou.lzy.result.Result;
import com.hou.lzy.result.ResultFactory;
import com.hou.lzy.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {


    @Autowired
    UserService userService;


    @GetMapping("/api/admin/user")
    public Result listUsers() {
        return ResultFactory.buildSuccessResult(userService.list());
    }




    @PutMapping("/api/admin/user")
    public Result editUser(@RequestBody @Valid User requestUser) {
        userService.editUser(requestUser);
        String message="修改用户休息成功";
        return ResultFactory.buildSuccessResult(message);
    }




}
