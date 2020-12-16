package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.dao.BlogArticleDao;
import com.oycbest.blog.entity.BlogArticle;
import com.oycbest.blog.service.BlogArticleService;
import org.springframework.stereotype.Service;

/**
 * 文章表(BlogArticle)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 11:16:52
 */
@Service("blogArticleService")
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleDao, BlogArticle> implements BlogArticleService {

}