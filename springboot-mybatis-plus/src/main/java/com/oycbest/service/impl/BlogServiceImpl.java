package com.oycbest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.mapper.BlogMapper;
import com.oycbest.entity.Blog;
import com.oycbest.service.BlogService;
import org.springframework.stereotype.Service;

/**
 * 文章表(Blog)表服务实现类
 *
 * @author oyc
 * @since 2021-02-02 11:47:23
 */
@Service("blogService")
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
