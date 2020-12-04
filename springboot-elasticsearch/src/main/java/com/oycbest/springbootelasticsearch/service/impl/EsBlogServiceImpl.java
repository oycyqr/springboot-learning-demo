package com.oycbest.springbootelasticsearch.service.impl;

import com.oycbest.springbootelasticsearch.document.EsBlog;
import com.oycbest.springbootelasticsearch.repository.EsBlogRepository;
import com.oycbest.springbootelasticsearch.service.EsBlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

/**
 * @Author: oyc
 * @Date: 2020-04-30 9:39
 * @Description: Blog服务实现类
 */
@Service
public class EsBlogServiceImpl implements EsBlogService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EsBlogRepository blogSearchRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public void save(EsBlog blog) {
        blogSearchRepository.save(blog);
        logger.debug("saved");
    }
    @Override
    public void save(List<EsBlog> blogs) {
        blogSearchRepository.saveAll(blogs);
        logger.debug("saved");
    }

    @Override
    public void delete(int id) {
        blogSearchRepository.deleteById(id);
    }

    @Override
    public EsBlog getById(int id) {
        EsBlog esBlog = blogSearchRepository.findById(id).orElse(new EsBlog());
        logger.debug(esBlog.toString());
        return esBlog;

    }

    @Override
    public Page<EsBlog> getByKey(String key, Pageable pageable) {
        if(StringUtils.isEmpty(key)){
            return blogSearchRepository.findAll(pageable);
        }
        return blogSearchRepository.findByTitleOrContentLike(key, key, pageable);
    }

    @Override
    public Page<EsBlog> getByKeyWord(String key, Pageable pageable) {
        if(StringUtils.isEmpty(key)){
            return blogSearchRepository.findAll(pageable);
        }
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQuery("title", key))
                .withQuery(matchQuery("content", key))
                .withPageable(pageable)
                .build();
        Page<EsBlog> esBlogs = elasticsearchTemplate.queryForPage(searchQuery, EsBlog.class);
        esBlogs.forEach(e -> logger.debug(e.toString()));
        return esBlogs;
    }
}
