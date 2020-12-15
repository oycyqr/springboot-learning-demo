package com.oycbest.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oycbest.blog.domain.BlogArticleTag;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 文章标签表(BlogArticleTag)表数据库访问层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public interface BlogArticleTagMapper extends BaseMapper<BlogArticleTag>{

}
