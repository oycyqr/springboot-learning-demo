package com.oycbest.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oycbest.blog.domain.BlogArticle;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 文章表(BlogArticle)表数据库访问层
 *
 * @author oyc
 * @since 2020-12-16 00:01:13
 */
public interface BlogArticleMapper extends BaseMapper<BlogArticle> {

}
