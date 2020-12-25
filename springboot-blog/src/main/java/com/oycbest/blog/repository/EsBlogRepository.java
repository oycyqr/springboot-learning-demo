package com.oycbest.blog.repository;


import com.oycbest.blog.vo.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: EsBlogRepository
 * @Description: EsBlogRepository
 * @Author oyc
 * @Date 2020/12/25 17:07
 * @Version 1.0
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