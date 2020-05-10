package com.oycbest.springbootelasticsearch.controller;

import com.oycbest.springbootelasticsearch.es.ESBlog;
import com.oycbest.springbootelasticsearch.service.ESBlogSearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/5/10 10:35 下午
 */
@RestController
@RequestMapping("es")
public class ESBLogController {

    @Resource
    private ESBlogSearchService searchService;

    /**
     * @param name
     * @return
     */
    @GetMapping("save")
    public void save(String id, String name) {
        searchService.save(new ESBlog(id, name + "name", "1", "1", "1", "1"));
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("getById")
    public Object getById(String id) {
        return searchService.getById(id);
    }


    /**
     * @param key
     * @return
     */
    @GetMapping("getByKeyWord")
    public List<ESBlog> getByKeyWord(String key) {
        return searchService.getByKeyWord(key);
    }
}
