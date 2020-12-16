package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.dao.BlogPermissionDao;
import com.oycbest.blog.entity.BlogPermission;
import com.oycbest.blog.service.BlogPermissionService;
import org.springframework.stereotype.Service;

/**
 * 权限表(BlogPermission)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 11:17:03
 */
@Service("blogPermissionService")
public class BlogPermissionServiceImpl extends ServiceImpl<BlogPermissionDao, BlogPermission> implements BlogPermissionService {

}