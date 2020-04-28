package com.oycbest.springbootssm.controller;

import com.oycbest.springbootssm.domain.SsmUser;
import com.oycbest.springbootssm.service.SsmUserService;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Delete;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SsmUser)表控制层
 *
 * @author oyc
 * @since 2020-04-28 23:24:43
 */
@RestController
@RequestMapping("ssmUser")
public class SsmUserController {
    /**
     * 服务对象
     */
    @Resource
    private SsmUserService ssmUserService;
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public SsmUser selectOne(@PathVariable("id") Integer id) {
        return ssmUserService.queryById(id);
    }
    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("all")
    public List<SsmUser> all() {
        return ssmUserService.queryAll();
    }
    
    /**
     * 列表数据
     *
     * @return 列表数据
     */
    @GetMapping("list")
    public List<SsmUser> list() {
        return ssmUserService.queryAllByLimit(1,10);
    }
    
    /**
    * 修改数据
    *
    * @param ssmUser 实例对象
    * @return 实例对象
    */
    @PostMapping
    public SsmUser save(SsmUser ssmUser) {
        return ssmUserService.insert(ssmUser);
    }
    
    /**
     * 新增或修改数据
     *
     * @param ssmUser 实例对象
     * @return 实例对象
     */
    @PutMapping
    public SsmUser saveOrUpdate(SsmUser ssmUser) {
        if (ssmUser.getId() != null) {
            return ssmUserService.update(ssmUser);
        } else {
            return ssmUserService.insert(ssmUser);
        }
    }
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
     @Delete("{id}")
    public Boolean delete(@PathVariable("id")  Integer id) {
        return ssmUserService.deleteById(id);
    }

}