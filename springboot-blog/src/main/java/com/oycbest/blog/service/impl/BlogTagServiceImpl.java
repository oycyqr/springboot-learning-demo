package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.dao.BlogTagDao;
import com.oycbest.blog.entity.BlogTag;
import com.oycbest.blog.service.BlogTagService;
import org.springframework.stereotype.Service;

/**
 * 标签表(BlogTag)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 11:17:09
 */
@Service("blogTagService")
public class BlogTagServiceImpl extends ServiceImpl<BlogTagDao, BlogTag> implements BlogTagService {

}