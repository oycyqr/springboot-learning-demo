package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.domain.BlogRoleMenu;
import com.oycbest.blog.mapper.BlogRoleMenuMapper;
import com.oycbest.blog.service.BlogRoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色与菜单对应关系(BlogRoleMenu)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@Service("blogRoleMenuService")
public class BlogRoleMenuServiceImpl extends ServiceImpl<BlogRoleMenuMapper,BlogRoleMenu> implements BlogRoleMenuService {
}
