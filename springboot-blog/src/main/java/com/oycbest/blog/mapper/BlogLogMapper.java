package com.oycbest.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oycbest.blog.domain.BlogLog;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户操作日志表(BlogLog)表数据库访问层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public interface BlogLogMapper extends BaseMapper<BlogLog>{

}
