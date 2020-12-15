package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.domain.BlogArticleInfo;
import com.oycbest.blog.mapper.BlogArticleInfoMapper;
import com.oycbest.blog.service.BlogArticleInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章表(BlogArticleInfo)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public class BlogArticleInfoServiceImpl extends ServiceImpl<BlogArticleInfoMapper, BlogArticleInfo> implements BlogArticleInfoService {
}
