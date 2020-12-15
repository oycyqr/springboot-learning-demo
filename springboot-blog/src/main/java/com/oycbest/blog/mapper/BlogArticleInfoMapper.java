package com.oycbest.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oycbest.blog.domain.BlogArticle;
import com.oycbest.blog.domain.BlogArticleInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 文章表(BlogArticleInfo)表数据库访问层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public interface BlogArticleInfoMapper extends BaseMapper<BlogArticleInfo> {
}
