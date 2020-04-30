package com.oycbest.springbootelasticsearch.repository;

import com.oycbest.springbootelasticsearch.es.ESDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: oyc
 * @Date: 2020-04-30 9:40
 * @Description:
 */
@Repository
public interface DocumentSearchRepository extends ElasticsearchRepository<ESDocument,String> {
}
