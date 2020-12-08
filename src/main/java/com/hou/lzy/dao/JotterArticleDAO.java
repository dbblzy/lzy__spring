package com.hou.lzy.dao;


import com.hou.lzy.pojo.JotterArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Evan
 * @date 2020/1/14 20:40
 */

public interface JotterArticleDAO  extends JpaRepository<JotterArticle,Integer> {
    JotterArticle findById(int id);
}
