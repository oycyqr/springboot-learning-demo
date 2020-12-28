package com.oycbest.blog.service.impl;

import com.oycbest.blog.repository.EsBlogRepository;
import com.oycbest.blog.service.EsBlogService;
import com.oycbest.blog.vo.EsBlog;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
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
import java.util.Map;

/**
 * @ClassName: EsBlogService
 * @Description: EsBlogService
 * @Author oyc
 * @Date 2020/12/25 17:08
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
        //自定义查询
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("title", key))
                .withQuery(QueryBuilders.matchQuery("content", key))
                .withPageable(pageable)
                .withSort(SortBuilders.fieldSort("id").order(SortOrder.ASC))
                .build();
        Page<EsBlog> esBlogs = elasticsearchTemplate.queryForPage(searchQuery, EsBlog.class);
        return esBlogs;
    }

    /**
     * 根据搜索结果创建esdoc对象
     *
     * @param smap
     * @param hmap
     * @return
     */
    private EsBlog createEsDoc(Map<String, Object> smap, Map<String, HighlightField> hmap) {
        EsBlog esBlog = new EsBlog();
        if (hmap.get("title") != null) {
            esBlog.setTitle(hmap.get("title").fragments()[0].toString());
        } else if (smap.get("title") != null) {
            esBlog.setTitle(smap.get("title").toString());
        }
        if (hmap.get("content") != null) {
            esBlog.setContent(hmap.get("content").fragments()[0].toString());
        } else if (smap.get("content") != null) {
            esBlog.setContent(smap.get("content").toString());
        }
        if (smap.get("id") != null) {
            esBlog.setId((Integer) smap.get("id"));
        }
        return esBlog;
    }

    @Override
    public Page<EsBlog> queryForPage(String key, Pageable pageable) {
        // 如果输入的查询条件为空，则查询所有数据
        if (StringUtils.isEmpty(key)) {
            return blogSearchRepository.findAll(pageable);
        }
        String preTag = "<font color='#dd4b39'>";
        String postTag = "</font>";
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(
                QueryBuilders.boolQuery()
                        .should(QueryBuilders.matchQuery("title", key))
                        .should(QueryBuilders.matchQuery("content", key))
        )
                .withPageable(pageable)
                .withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC))
                //多字段高亮
                .withHighlightFields(
                        new HighlightBuilder.Field("title").preTags(preTag).postTags(postTag),
                        new HighlightBuilder.Field("content").preTags(preTag).postTags(postTag)
                )
                .build();


        Page<EsBlog> esBlogs = elasticsearchTemplate.queryForPage(searchQuery, EsBlog.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {
                List<EsBlog> chunk = new ArrayList<>();
                for (SearchHit searchHit : response.getHits().getHits()) {
                    // 普通查询结果
                    Map<String, Object> smap = searchHit.getSourceAsMap();
                    // 高亮查询结果
                    Map<String, HighlightField> hmap = searchHit.getHighlightFields();
                    chunk.add(createEsDoc(smap, hmap));
                }
                AggregatedPage<T> result = new AggregatedPageImpl<T>((List) chunk, pageable, response.getHits().getTotalHits());
                return result;
            }

            @Override
            public <T> T mapSearchHit(SearchHit searchHit, Class<T> aClass) {
                List<EsBlog> chunk = new ArrayList<>();
                // 普通查询结果
                Map<String, Object> smap = searchHit.getSourceAsMap();
                // 高亮查询结果
                Map<String, HighlightField> hmap = searchHit.getHighlightFields();
                chunk.add(createEsDoc(smap, hmap));
                return null;
            }
        });

        esBlogs.forEach(e -> logger.debug(e.toString()));
        return esBlogs;
    }

}