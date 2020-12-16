package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.dao.BlogUserDao;
import com.oycbest.blog.entity.BlogUser;
import com.oycbest.blog.service.BlogUserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(BlogUser)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 11:17:11
 */
@Service("blogUserService")
public class BlogUserServiceImpl extends ServiceImpl<BlogUserDao, BlogUser> implements BlogUserService {

}