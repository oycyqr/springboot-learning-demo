package com.oycbest.springbootelasticsearch.service;

import com.oycbest.springbootelasticsearch.document.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: oyc
 * @Date: 2020-04-30 9:38
 * @Description: Blog服务接口
 */
public interface EsBlogService {
    /**
     * 保存blog到ES
     * @param blog
     */
    void save(EsBlog blog);

    void save(List<EsBlog> blogs);

    void delete(int id);

    EsBlog getById(int id);

    Page<EsBlog> getByKey(String key, Pageable pageable);

    Page<EsBlog> getByKeyWord(String key, Pageable pageable);
}
