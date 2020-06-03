package com.oycbest.ssmblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.ssmblog.domain.SsmBlog;
import com.oycbest.ssmblog.mapper.SsmBlogMapper;
import com.oycbest.ssmblog.service.SsmBlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (SsmBlog)表服务实现类
 *
 * @author oyc
 * @since 2020-04-28 23:36:00
 */
@Service("ssmBlogService")
public class SsmBlogServiceImpl extends ServiceImpl<SsmBlogMapper, SsmBlog> implements SsmBlogService {
    @Resource
    private SsmBlogMapper ssmBlogMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SsmBlog queryById(Integer id) {
        return ssmBlogMapper.selectById(id);
    }

    @Override
    public IPage<SsmBlog> queryByBlogPage(Page page, SsmBlog student) {
        QueryWrapper<SsmBlog> wrapper = new QueryWrapper<>();
        wrapper.setEntity(student);
        return this.page(page,wrapper);
    }

    @Override
    public IPage<SsmBlog> queryByPage(Page page) {
        return this.page(page);
    }


    /**
     * 新增数据
     *
     * @param ssmBlog 实例对象
     * @return 实例对象
     */
    @Override
    public SsmBlog insert(SsmBlog ssmBlog) {
        ssmBlogMapper.insert(ssmBlog);
        return ssmBlog;
    }

    /**
     * 修改数据
     *
     * @param ssmBlog 实例对象
     * @return 实例对象
     */
    @Override
    public SsmBlog update(SsmBlog ssmBlog) {
        ssmBlogMapper.updateById(ssmBlog);
        return null;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return ssmBlogMapper.deleteById(id) > 0;
    }
}
