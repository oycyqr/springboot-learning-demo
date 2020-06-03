package com.oycbest.ssmblog.service.impl;

import com.oycbest.ssmblog.domain.SsmUser;
import com.oycbest.ssmblog.mapper.SsmUserMapper;
import com.oycbest.ssmblog.service.SsmUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SsmUser)表服务实现类
 *
 * @author oyc
 * @since 2020-04-28 23:21:54
 */
@Service("ssmUserService")
public class SsmUserServiceImpl implements SsmUserService {
    @Resource
    private SsmUserMapper ssmUserMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SsmUser queryById(Integer id) {
        return this.ssmUserMapper.queryById(id);
    }

    @Override
    public List<SsmUser> queryAll() {
        return ssmUserMapper.queryAll(new SsmUser());
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SsmUser> queryAllByLimit(int offset, int limit) {
        return this.ssmUserMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param ssmUser 实例对象
     * @return 实例对象
     */
    @Override
    public SsmUser insert(SsmUser ssmUser) {
        this.ssmUserMapper.insert(ssmUser);
        return ssmUser;
    }

    /**
     * 修改数据
     *
     * @param ssmUser 实例对象
     * @return 实例对象
     */
    @Override
    public SsmUser update(SsmUser ssmUser) {
        this.ssmUserMapper.update(ssmUser);
        return this.queryById(ssmUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.ssmUserMapper.deleteById(id) > 0;
    }
}
