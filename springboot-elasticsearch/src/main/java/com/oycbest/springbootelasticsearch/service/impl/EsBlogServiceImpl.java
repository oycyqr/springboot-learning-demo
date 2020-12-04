package com.oycbest.springbootelasticsearch.service.impl;

import com.oycbest.springbootelasticsearch.document.EsBlog;
import com.oycbest.springbootelasticsearch.repository.EsBlogRepository;
import com.oycbest.springbootelasticsearch.service.EsBlogService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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
        if (StringUtils.isEmpty(key)) {
            return blogSearchRepository.findAll(pageable);
        }
        return blogSearchRepository.findByTitleOrContentLike(key, key, pageable);
    }

    @Override
    public Page<EsBlog> getByKeyWord(String key, Pageable pageable) {
        if (StringUtils.isEmpty(key)) {
            return blogSearchRepository.findAll(pageable);
        }
        //高亮显示
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("title");
        highlightBuilder.field("content");
        //多个单词高亮的话，要把这个设置为trues
        highlightBuilder.requireFieldMatch(true);
        //前置元素
        highlightBuilder.preTags("<span style='color:red'>");
        //后置元素
        highlightBuilder.postTags("</span>");

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQuery("title", key))
                .withQuery(matchQuery("content", key))
                .withPageable(pageable)
                .withHighlightBuilder(highlightBuilder)
                .build();
        Page<EsBlog> esBlogs1 = elasticsearchTemplate.queryForPage(searchQuery, EsBlog.class);
        // 高亮字段
        Page<EsBlog> esBlogs = elasticsearchTemplate.queryForPage(searchQuery, EsBlog.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {
                List<EsBlog> chunk = new ArrayList<>();
                for (SearchHit searchHit : response.getHits()) {
                    if (response.getHits().getHits().length <= 0) {
                        return null;
                    }
                    EsBlog blog = new EsBlog();
                    //name or memoe
                    HighlightField blogTitle = searchHit.getHighlightFields().get("title");
                    if (blogTitle != null) {
                        blog.setTitle(blogTitle.fragments()[0].toString());
                    }
                    HighlightField blogContent = searchHit.getHighlightFields().get("content");
                    if (blogContent != null) {
                        blog.setContent(blogContent.fragments()[0].toString());
                    }
                    chunk.add(blog);
                }
                if (chunk.size() > 0) {
                    return new AggregatedPageImpl<>((List<T>) chunk);
                }
                return null;
            }

            @Override
            public <T> T mapSearchHit(SearchHit searchHit, Class<T> aClass) {
                return null;
            }
        });
        esBlogs.forEach(e -> logger.debug(e.toString()));
        return esBlogs;
    }
}
