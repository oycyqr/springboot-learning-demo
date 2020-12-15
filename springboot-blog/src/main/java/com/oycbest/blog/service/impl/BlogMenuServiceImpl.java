package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.domain.BlogMenu;
import com.oycbest.blog.mapper.BlogMenuMapper;
import com.oycbest.blog.service.BlogMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单权限表(BlogMenu)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@Service("blogMenuService")
public class BlogMenuServiceImpl extends ServiceImpl<BlogMenuMapper,BlogMenu> implements BlogMenuService {
}
