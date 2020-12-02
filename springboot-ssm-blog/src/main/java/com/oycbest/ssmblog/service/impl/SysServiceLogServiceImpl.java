package com.oycbest.ssmblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.ssmblog.domain.SysServiceLog;
import com.oycbest.ssmblog.mapper.SysServiceLogMapper;
import com.oycbest.ssmblog.service.SysServiceLogService;
import org.springframework.stereotype.Service;

/**
 * @Description: 系统日志服务实现类
 * @Author oyc
 * @Date 2020/11/19 11:28 下午
 */
@Service("sysServiceLogService")
public class SysServiceLogServiceImpl extends ServiceImpl<SysServiceLogMapper, SysServiceLog> implements SysServiceLogService {
}
