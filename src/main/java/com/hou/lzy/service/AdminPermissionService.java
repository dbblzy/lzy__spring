package com.hou.lzy.service;


import com.hou.lzy.dao.AdminPermissionDAO;
import com.hou.lzy.dao.AdminRolePermissionDAO;
import com.hou.lzy.pojo.AdminPermission;
import com.hou.lzy.pojo.AdminRole;
import com.hou.lzy.pojo.AdminRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 23868
 */
@Service
public class AdminPermissionService {

    @Autowired
    AdminRoleService adminRoleService;
    @Resource
    AdminRolePermissionDAO adminRolePermissionDAO;
    @Resource
    AdminPermissionDAO adminPermissionDAO;
    @Autowired
    AdminRolePermissionService adminRolePermissionService;

    public Set<String> listPermissionURLsByUser(String username) {
        List<Integer> rids = adminRoleService.listRolesByUser(username)
                .stream().map(AdminRole::getId).collect(Collectors.toList());

        List<Integer> pids = adminRolePermissionDAO.findAllByRidIn(rids)
                .stream().map(AdminRolePermission::getPid).collect(Collectors.toList());

        List<AdminPermission> perms = adminPermissionDAO.findAllById(pids);

        Set<String> URLs = perms.stream().map(AdminPermission::getUrl).collect(Collectors.toSet());

        return URLs;
    }

    public boolean needFilter(String requestAPI) {
        List<AdminPermission> ps = adminPermissionDAO.findAll();
        for (AdminPermission p: ps) {
            if (p.getUrl().equals(requestAPI)) {
                return true;
            }
        }
        return false;
    }

    public List<AdminPermission> listPermsByRoleId(int rid) {
        List<Integer> pids = adminRolePermissionService.findAllByRid(rid)
                .stream().map(AdminRolePermission::getPid).collect(Collectors.toList());
        return adminPermissionDAO.findAllById(pids);
    }

    public List<AdminPermission> list() {return adminPermissionDAO.findAll();}




}
