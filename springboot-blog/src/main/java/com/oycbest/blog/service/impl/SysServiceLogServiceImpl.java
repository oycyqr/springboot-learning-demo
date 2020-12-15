package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.domain.SysServiceLog;
import com.oycbest.blog.mapper.SysServiceLogMapper;
import com.oycbest.blog.service.SysServiceLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * API日志表(SysServiceLog)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
@Service("sysServiceLogService")
public class SysServiceLogServiceImpl extends ServiceImpl<SysServiceLogMapper,SysServiceLog> implements SysServiceLogService {
}
