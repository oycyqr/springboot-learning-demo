package com.oycbest.blog.controller;

import com.oycbest.blog.domain.SysServiceLog;
import com.oycbest.blog.service.SysServiceLogService;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Delete;

import javax.annotation.Resource;
import java.util.List;

/**
 * API日志表(SysServiceLog)表控制层
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@RestController
@RequestMapping("sysServiceLog")
public class SysServiceLogController {
    /**
     * 服务对象
     */
    @Resource
    private SysServiceLogService sysServiceLogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public SysServiceLog selectOne(@PathVariable("id") Integer id) {
        return sysServiceLogService.getById(id);
    }


    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<SysServiceLog> list() {
        return sysServiceLogService.list();
    }

    /**
     * 修改数据
     *
     * @param sysServiceLog 实例对象
     * @return 实例对象
     */
    @PostMapping
    public Boolean save(SysServiceLog sysServiceLog) {
        return sysServiceLogService.save(sysServiceLog);
    }

    /**
     * 新增或修改数据
     *
     * @param sysServiceLog 实例对象
     * @return 实例对象
     */
    @PutMapping
    public Boolean saveOrUpdate(SysServiceLog sysServiceLog) {
        return sysServiceLogService.saveOrUpdate(sysServiceLog);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Delete("{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return sysServiceLogService.removeById(id);
    }

}
