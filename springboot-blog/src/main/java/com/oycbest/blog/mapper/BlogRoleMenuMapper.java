package com.oycbest.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oycbest.blog.domain.BlogRoleMenu;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 角色与菜单对应关系(BlogRoleMenu)表数据库访问层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public interface BlogRoleMenuMapper extends BaseMapper<BlogRoleMenu>{

}
