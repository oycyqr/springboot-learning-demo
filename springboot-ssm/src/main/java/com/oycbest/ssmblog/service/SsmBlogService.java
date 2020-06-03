package com.oycbest.ssmblog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oycbest.ssmblog.domain.SsmBlog;

/**
 * (SsmBlog)表服务接口
 *
 * @author oyc
 * @since 2020-04-28 23:36:00
 */
public interface SsmBlogService extends IService<SsmBlog> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SsmBlog queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    IPage<SsmBlog> queryByBlogPage(Page page, SsmBlog student);
    IPage<SsmBlog> queryByPage(Page page);

    /**
     * 新增数据
     *
     * @param ssmBlog 实例对象
     * @return 实例对象
     */
    SsmBlog insert(SsmBlog ssmBlog);

    /**
     * 修改数据
     *
     * @param ssmBlog 实例对象
     * @return 实例对象
     */
    SsmBlog update(SsmBlog ssmBlog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
