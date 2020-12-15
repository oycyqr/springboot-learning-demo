package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.domain.BlogRole;
import com.oycbest.blog.mapper.BlogRoleMapper;
import com.oycbest.blog.service.BlogRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色信息表(BlogRole)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@Service("blogRoleService")
public class BlogRoleServiceImpl extends ServiceImpl<BlogRoleMapper,BlogRole> implements BlogRoleService {
}
