package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.domain.BlogComment;
import com.oycbest.blog.mapper.BlogCommentMapper;
import com.oycbest.blog.service.BlogCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论表(BlogComment)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@Service("blogCommentService")
public class BlogCommentServiceImpl extends ServiceImpl<BlogCommentMapper,BlogComment> implements BlogCommentService {
}
