package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.domain.BlogPermission;
import com.oycbest.blog.mapper.BlogPermissionMapper;
import com.oycbest.blog.service.BlogPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限表(BlogPermission)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@Service("blogPermissionService")
public class BlogPermissionServiceImpl extends ServiceImpl<BlogPermissionMapper,BlogPermission> implements BlogPermissionService {
}
