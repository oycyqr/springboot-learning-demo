package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.dao.BlogCategoryDao;
import com.oycbest.blog.entity.BlogCategory;
import com.oycbest.blog.service.BlogCategoryService;
import org.springframework.stereotype.Service;

/**
 * 文章类别表(BlogCategory)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 11:16:56
 */
@Service("blogCategoryService")
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryDao, BlogCategory> implements BlogCategoryService {

}