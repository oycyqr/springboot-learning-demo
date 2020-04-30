package com.oycbest.springbootelasticsearch.service;

import com.oycbest.springbootelasticsearch.es.ESDocument;

/**
 * @Author: oyc
 * @Date: 2020-04-30 9:38
 * @Description:
 */
public interface DocumentSearchService {
	void save(ESDocument esDocument);
	void delete(String id);
	void getById(String id);
	void getByName(String name,String projectId);
}
