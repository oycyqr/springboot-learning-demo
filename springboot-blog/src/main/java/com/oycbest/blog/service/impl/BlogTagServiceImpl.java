package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.domain.BlogTag;
import com.oycbest.blog.mapper.BlogTagMapper;
import com.oycbest.blog.service.BlogTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 标签表(BlogTag)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@Service("blogTagService")
public class BlogTagServiceImpl extends ServiceImpl<BlogTagMapper,BlogTag> implements BlogTagService {
}
