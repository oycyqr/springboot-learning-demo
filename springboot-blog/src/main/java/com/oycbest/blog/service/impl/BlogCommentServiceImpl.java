package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.dao.BlogCommentDao;
import com.oycbest.blog.entity.BlogComment;
import com.oycbest.blog.service.BlogCommentService;
import org.springframework.stereotype.Service;

/**
 * 评论表(BlogComment)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 11:16:58
 */
@Service("blogCommentService")
public class BlogCommentServiceImpl extends ServiceImpl<BlogCommentDao, BlogComment> implements BlogCommentService {

}