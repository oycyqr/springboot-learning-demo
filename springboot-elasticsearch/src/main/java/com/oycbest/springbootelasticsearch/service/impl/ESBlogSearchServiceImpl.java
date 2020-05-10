package com.oycbest.springbootelasticsearch.service.impl;

import com.oycbest.springbootelasticsearch.es.ESBlog;
import com.oycbest.springbootelasticsearch.repository.ESBlogSearchRepository;
import com.oycbest.springbootelasticsearch.service.ESBlogSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

/**
 * @Author: oyc
 * @Date: 2020-04-30 9:39
 * @Description:
 */
@Service
public class ESBlogSearchServiceImpl implements ESBlogSearchService {

    @Autowired
    private ESBlogSearchRepository blogSearchRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public void save(ESBlog esBlog) {
        ESBlog save = blogSearchRepository.save(esBlog);
        System.out.println(save.toString());
    }

    @Override
    public void delete(String id) {
        blogSearchRepository.deleteById(id);
    }

    @Override
    public ESBlog getById(String id) {
        ESBlog esBlog = blogSearchRepository.findById(id).orElse(new ESBlog());
        System.out.println(esBlog.toString());
        return esBlog;

    }

    @Override
    public List<ESBlog> getByKeyWord(String key) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("title", key)).withQuery(matchQuery("content", key)).build();
        List<ESBlog> esBlogs = elasticsearchTemplate.queryForList(searchQuery, ESBlog.class);
        esBlogs.forEach(e -> System.out.println(e.toString()));
        return esBlogs;
    }
}
