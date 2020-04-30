package com.oycbest.springbootelasticsearch.service.impl;

import com.oycbest.springbootelasticsearch.es.ESDocument;
import com.oycbest.springbootelasticsearch.repository.DocumentSearchRepository;
import com.oycbest.springbootelasticsearch.service.DocumentSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.elasticsearch.index.query.QueryBuilders.*;
import java.util.List;

/**
 * @Author: oyc
 * @Date: 2020-04-30 9:39
 * @Description:
 */
public class DocumentSearchServiceImpl implements DocumentSearchService {
	@Autowired
	private DocumentSearchRepository documentSearchRepository;

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@Override
	public void save(ESDocument esDocument) {
		ESDocument save = documentSearchRepository.save(esDocument);
		System.out.println(save.toString());
	}

	@Override
	public void delete(String id) {
		documentSearchRepository.deleteById(id);
	}

	@Override
	public void getById(String id) {
		ESDocument esDocument = documentSearchRepository.findById(id).orElse(new ESDocument());
		System.out.println(esDocument.toString());

	}

	@Override
	public void getByName(String name, String projectId) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("name",name)).withQuery(matchQuery("projectId",projectId)).build();
		List<ESDocument> esDocuments = elasticsearchTemplate.queryForList(searchQuery, ESDocument.class);
		esDocuments.forEach(e-> System.out.println(e.toString()));
	}
}
