package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.dao.BlogArticleTagDao;
import com.oycbest.blog.entity.BlogArticleTag;
import com.oycbest.blog.service.BlogArticleTagService;
import org.springframework.stereotype.Service;

/**
 * 文章标签表(BlogArticleTag)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 11:16:55
 */
@Service("blogArticleTagService")
public class BlogArticleTagServiceImpl extends ServiceImpl<BlogArticleTagDao, BlogArticleTag> implements BlogArticleTagService {

}