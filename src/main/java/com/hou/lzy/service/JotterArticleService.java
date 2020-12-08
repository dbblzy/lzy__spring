package com.hou.lzy.service;


import com.hou.lzy.dao.JotterArticleDAO;
import com.hou.lzy.pojo.JotterArticle;
import com.hou.lzy.util.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author Evan
 * @date 2020/1/14 21:00
 */
@Service
public class JotterArticleService {
    @Autowired
    JotterArticleDAO jotterArticleDAO;
//    @Autowired
//    RedisService redisService;

    public Page list(int page, int size) {
        Sort sort =  Sort.by(Sort.Direction.DESC, "id");
        return  jotterArticleDAO.findAll(PageRequest.of(page, size, sort));
    }


//    用于复现异常
//    @Cacheable(value = RedisConfig.REDIS_KEY_DATABASE)
//    public Page list(int page, int size) {
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        return jotterArticleDAO.findAll(PageRequest.of(page, size, sort));
//    }



}
