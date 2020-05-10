package com.oycbest.springbootelasticsearch.service;

import com.oycbest.springbootelasticsearch.es.ESBlog;

import java.util.List;

/**
 * @Author: oyc
 * @Date: 2020-04-30 9:38
 * @Description:
 */
public interface ESBlogSearchService {
    void save(ESBlog esBlog);

    void delete(String id);

    ESBlog getById(String id);

    List<ESBlog> getByKeyWord(String key);
}
