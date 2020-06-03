package com.oycbest.ssmblog.mapper;

import com.oycbest.ssmblog.domain.SsmUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SsmUser)表数据库访问层
 *
 * @author oyc
 * @since 2020-04-28 23:21:52
 */
public interface SsmUserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SsmUser queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SsmUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param ssmUser 实例对象
     * @return 对象列表
     */
    List<SsmUser> queryAll(SsmUser ssmUser);

    /**
     * 新增数据
     *
     * @param ssmUser 实例对象
     * @return 影响行数
     */
    int insert(SsmUser ssmUser);

    /**
     * 修改数据
     *
     * @param ssmUser 实例对象
     * @return 影响行数
     */
    int update(SsmUser ssmUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
