package com.hou.lzy.service;


import com.hou.lzy.dao.AdminRolePermissionDAO;
import com.hou.lzy.pojo.AdminPermission;
import com.hou.lzy.pojo.AdminRolePermission;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@EnableTransactionManagement(proxyTargetClass = true)

public class AdminRolePermissionService {
    @Resource
    AdminRolePermissionDAO adminRolePermissionDAO;

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

    List<AdminRolePermission> findAllByRid(int rid) {
        return adminRolePermissionDAO.findAllByRid(rid);
    }

}
