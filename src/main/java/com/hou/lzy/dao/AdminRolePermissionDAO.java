package com.hou.lzy.dao;


import com.hou.lzy.pojo.AdminRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Evan
 * @date 2019/11
 */


public interface AdminRolePermissionDAO extends JpaRepository<AdminRolePermission, Integer> {
    List<AdminRolePermission> findAllByRid(int rid);
    List<AdminRolePermission> findAllByRidIn(List<Integer> rids);
    void deleteAllByRid(int rid);
}
