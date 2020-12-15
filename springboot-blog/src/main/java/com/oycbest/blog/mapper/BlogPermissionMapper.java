package com.oycbest.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oycbest.blog.domain.BlogPermission;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 权限表(BlogPermission)表数据库访问层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public interface BlogPermissionMapper extends BaseMapper<BlogPermission>{

}
