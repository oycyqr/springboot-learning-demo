package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.domain.BlogArticle;
import com.oycbest.blog.mapper.BlogArticleMapper;
import com.oycbest.blog.service.BlogArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章表(BlogArticle)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 00:01:14
 */
@Service("blogArticleService")
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleMapper, BlogArticle> implements BlogArticleService {

}
