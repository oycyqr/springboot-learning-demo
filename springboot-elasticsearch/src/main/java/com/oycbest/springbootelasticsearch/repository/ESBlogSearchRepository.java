package com.oycbest.springbootelasticsearch.repository;

import com.oycbest.springbootelasticsearch.es.ESBlog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: oyc
 * @Date: 2020-04-30 9:40
 * @Description: ESBlog Repository
 */
@Repository
public interface ESBlogSearchRepository extends ElasticsearchRepository<ESBlog,String> {
}
