package com.oycbest.ssmblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oycbest.ssmblog.domain.SsmBlog;
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
public interface SsmBlogMapper  extends BaseMapper<SsmBlog> {

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */

    List<SsmBlog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param ssmBlog 实例对象
     * @return 对象列表
     */
    List<SsmBlog> queryAll(SsmBlog ssmBlog);

}
