package com.oycbest.ssmblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oycbest.ssmblog.domain.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SsmBlog)表数据库访问层
 *
 * @author oyc
 * @since 2020-04-28 23:36:00
 */
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {
}
