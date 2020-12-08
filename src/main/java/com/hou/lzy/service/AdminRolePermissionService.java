package com.hou.lzy.service;


import com.hou.lzy.dao.AdminRoleDAO;
import com.hou.lzy.dao.AdminRolePermissionDAO;
import com.hou.lzy.pojo.AdminPermission;
import com.hou.lzy.pojo.AdminRole;
import com.hou.lzy.pojo.AdminRolePermission;
import com.hou.lzy.pojo.AdminUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableTransactionManagement(proxyTargetClass = true)

public class AdminRolePermissionService {
    @Resource
    AdminRolePermissionDAO adminRolePermissionDAO;
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminRoleDAO adminRoleDAO;

    public void savePermChanges(int rid, List<AdminPermission> perms) {
        adminRolePermissionDAO.deleteAllByRid(rid);
        List<AdminRolePermission> rps = new ArrayList<>();
        perms.forEach(p -> {
            AdminRolePermission rp = new AdminRolePermission();
            rp.setRid(rid);
            rp.setPid(p.getId());
            rps.add(rp);
        });
        adminRolePermissionDAO.saveAll(rps);
    }

    public List<AdminRole> listRolesByUser(String username) {
        int uid = userService.findByUsername(username).getId();
        List<Integer> rids = adminUserRoleService.listAllByUid(uid)
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());
        return adminRoleDAO.findAllById(rids);
    }


    List<AdminRolePermission> findAllByRid(int rid) {
        return adminRolePermissionDAO.findAllByRid(rid);
    }

}
