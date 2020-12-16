package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.dao.BlogArticleInfoDao;
import com.oycbest.blog.entity.BlogArticleInfo;
import com.oycbest.blog.service.BlogArticleInfoService;
import org.springframework.stereotype.Service;

/**
 * 文章表(BlogArticleInfo)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 11:16:54
 */
@Service("blogArticleInfoService")
public class BlogArticleInfoServiceImpl extends ServiceImpl<BlogArticleInfoDao, BlogArticleInfo> implements BlogArticleInfoService {

}