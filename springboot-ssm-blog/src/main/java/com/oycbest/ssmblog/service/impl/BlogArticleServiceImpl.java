package com.oycbest.ssmblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.ssmblog.domain.BlogArticle;
import com.oycbest.ssmblog.mapper.BlogArticleMapper;
import com.oycbest.ssmblog.service.BlogArticleService;
import org.springframework.stereotype.Service;

/**
 * (BlogArticle)表服务实现类
 *
 * @author oyc
 * @since 2020-04-29 22:47:13
 */
@Service("blogArticleService")
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleMapper, BlogArticle> implements BlogArticleService {
}
