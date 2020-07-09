package com.oycbest.ssmblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.ssmblog.domain.BlogComment;
import com.oycbest.ssmblog.mapper.BlogCommentMapper;
import com.oycbest.ssmblog.service.BlogCommentService;
import org.springframework.stereotype.Service;

/**
 * (BlogCategory)表服务实现类
 *
 * @author oyc
 * @since 2020-04-29 22:47:13
 */
@Service("blogListService")
public class BlogCommentServiceImpl extends ServiceImpl<BlogCommentMapper, BlogComment> implements BlogCommentService {
}
