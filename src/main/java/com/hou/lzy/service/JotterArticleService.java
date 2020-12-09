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

    public JotterArticle findById(int id) {
        JotterArticle article;
        String key = "article:" + id;
        article = jotterArticleDAO.findById(id);
        return article;
    }
    public void addOrUpdate(JotterArticle article) {
        jotterArticleDAO.save(article);
       // redisService.delete("article" + article.getId());
       // Set<String> keys = redisService.getKeysByPattern("articlepage*");
        //redisService.delete(keys);
    }

    public void delete(int id) {
        jotterArticleDAO.deleteById(id);

     //   redisService.delete("article:" + id);
      //  Set<String> keys = redisService.getKeysByPattern("articlepage*");
      //  redisService.delete(keys);
    }




//    用于复现异常
//    @Cacheable(value = RedisConfig.REDIS_KEY_DATABASE)
//    public Page list(int page, int size) {
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        return jotterArticleDAO.findAll(PageRequest.of(page, size, sort));
//    }



}
