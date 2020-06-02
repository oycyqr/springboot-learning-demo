package com.oycbest.ssmblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.ssmblog.domain.Blog;
import com.oycbest.ssmblog.mapper.BlogMapper;
import com.oycbest.ssmblog.service.BlogService;
import org.springframework.stereotype.Service;

/**
 * (SsmBlog)表服务实现类
 *
 * @author oyc
 * @since 2020-04-28 23:36:00
 */
@Service("blogService")
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
}
