package com.oycbest.ssmblog.controller;

import com.oycbest.ssmblog.service.SysServiceLogService;
import com.oycbest.ssmblog.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 系统日志控制类
 * @Author oyc
 * @Date 2020/11/19 11:19 下午
 */
@RestController
@RequestMapping("service/log")
public class SysServiceLogController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysServiceLogService logService;

    /**
     * 获取系统日志列表
     *
     * @return
     */
    @GetMapping
    public Result list() {
        logger.debug("系统日志列表");
        return Result.ok(logService.list());
    }

    /**
     * 根据日志id获取单条日志
     *
     * @return
     */
    @GetMapping("{id}")
    public Result getLog(@PathVariable("id") String id) {
        logger.debug("根据日志id获取单条日志", id);
        return Result.ok(logService.getById(id));
    }

}
