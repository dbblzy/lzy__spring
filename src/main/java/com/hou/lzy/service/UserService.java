package com.hou.lzy.service;


import com.hou.lzy.dao.UserDAO;
import com.hou.lzy.dto.UserDTO;
import com.hou.lzy.pojo.AdminRole;
import com.hou.lzy.pojo.User;
import org.hibernate.annotations.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {
    @Autowired
    AdminRoleService adminRoleService;
    @Autowired
    UserDAO userDAO;

    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public User get(String username, String password) {
        return userDAO.getByUsernameAndPassword(username, password);
    }


    public User getByName(String username) {
        return userDAO.findByUsername(username);
    }


    public void add(User user) {
        userDAO.save(user);
    }

    public List<UserDTO> list() {
        List<User> users = userDAO.findAll();

        // Find all roles in DB to enable JPA persistence context.
//        List<AdminRole> allRoles = adminRoleService.findAll();

        List<UserDTO> userDTOS = users
                .stream().map(user -> (UserDTO) new UserDTO().convertFrom(user)).collect(Collectors.toList());

        userDTOS.forEach(u -> {
            List<AdminRole> roles = adminRoleService.listRolesByUser(u.getUsername());
            u.setRoles(roles);
        });

        return userDTOS;
    }
}
