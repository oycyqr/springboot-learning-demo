package com.oycbest.ssmblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.ssmblog.domain.BlogCategory;
import com.oycbest.ssmblog.mapper.BlogCategoryMapper;
import com.oycbest.ssmblog.service.BlogCategoryService;
import org.springframework.stereotype.Service;

/**
 * (BlogCategory)表服务实现类
 *
 * @author oyc
 * @since 2020-04-29 22:47:13
 */
@Service("blogCategoryService")
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements BlogCategoryService {
}
