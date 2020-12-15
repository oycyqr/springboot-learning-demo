package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.domain.BlogArticleTag;
import com.oycbest.blog.mapper.BlogArticleTagMapper;
import com.oycbest.blog.service.BlogArticleTagService;
import org.springframework.stereotype.Service;

/**
 * 文章标签表(BlogArticleTag)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@Service("blogArticleTagService")
public class BlogArticleTagServiceImpl extends ServiceImpl<BlogArticleTagMapper, BlogArticleTag> implements BlogArticleTagService {

}
