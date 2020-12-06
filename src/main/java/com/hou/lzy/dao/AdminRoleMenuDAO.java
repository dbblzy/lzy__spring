package com.hou.lzy.dao;


import com.hou.lzy.pojo.AdminRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Evan
 * @date 2019/11
 */


@Component
public interface AdminRoleMenuDAO extends JpaRepository<AdminRoleMenu,Integer> {
    List<AdminRoleMenu> findAllByRid(int rid);
    List<AdminRoleMenu> findAllByRidIn(List<Integer> rids);
    void deleteAllByRid(int rid);
}
