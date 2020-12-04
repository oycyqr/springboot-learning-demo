package com.oycbest.springbootelasticsearch.repository;

import com.oycbest.springbootelasticsearch.document.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: oyc
 * @Date: 2020-04-30 9:40
 * @Description: ESBlog Repository
 */
@Repository
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, Integer> {
    /**
     * 根据title或者内容分页查询
     *
     * @param title   标题
     * @param content 内容
     * @param page    分页
     * @return
     */
    Page<EsBlog> findByTitleOrContentLike(String title, String content, Pageable page);
}
