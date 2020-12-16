package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.dao.SysServiceLogDao;
import com.oycbest.blog.entity.SysServiceLog;
import com.oycbest.blog.service.SysServiceLogService;
import org.springframework.stereotype.Service;

/**
 * API日志表(SysServiceLog)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 11:17:14
 */
@Service("sysServiceLogService")
public class SysServiceLogServiceImpl extends ServiceImpl<SysServiceLogDao, SysServiceLog> implements SysServiceLogService {

}