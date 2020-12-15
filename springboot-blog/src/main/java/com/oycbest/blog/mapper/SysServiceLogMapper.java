package com.oycbest.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oycbest.blog.domain.BlogArticleInfo;
import com.oycbest.blog.domain.SysServiceLog;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * API日志表(SysServiceLog)表数据库访问层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public interface SysServiceLogMapper extends BaseMapper<SysServiceLog> {

}
