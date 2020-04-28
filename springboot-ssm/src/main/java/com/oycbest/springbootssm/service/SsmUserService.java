package com.oycbest.springbootssm.service;

import com.oycbest.springbootssm.domain.SsmUser;
import java.util.List;

/**
 * (SsmUser)表服务接口
 *
 * @author oyc
 * @since 2020-04-28 23:21:53
 */
public interface SsmUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SsmUser queryById(Integer id);

    List<SsmUser> queryAll();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SsmUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param ssmUser 实例对象
     * @return 实例对象
     */
    SsmUser insert(SsmUser ssmUser);

    /**
     * 修改数据
     *
     * @param ssmUser 实例对象
     * @return 实例对象
     */
    SsmUser update(SsmUser ssmUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}