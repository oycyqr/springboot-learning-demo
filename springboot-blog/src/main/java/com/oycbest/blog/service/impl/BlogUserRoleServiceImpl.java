package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.domain.BlogUserRole;
import com.oycbest.blog.mapper.BlogUserRoleMapper;
import com.oycbest.blog.service.BlogUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户与角色对应关系(BlogUserRole)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@Service("blogUserRoleService")
public class BlogUserRoleServiceImpl extends ServiceImpl<BlogUserRoleMapper,BlogUserRole> implements BlogUserRoleService {
}
