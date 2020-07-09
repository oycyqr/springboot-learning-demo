package com.oycbest.ssmblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.ssmblog.domain.BlogArticleTag;
import com.oycbest.ssmblog.mapper.BlogArticleTagMapper;
import com.oycbest.ssmblog.service.BlogArticleTagService;
import org.springframework.stereotype.Service;

/**
 * (BlogArticleTag)表服务实现类
 *
 * @author oyc
 * @since 2020-04-29 22:47:13
 */
@Service("blogListService")
public class BlogArticleTagServiceImpl extends ServiceImpl<BlogArticleTagMapper, BlogArticleTag> implements BlogArticleTagService {
}
