package com.oycbest.oyc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.oyc.domain.SsmUser;
import com.oycbest.oyc.mapper.SsmUserMapper;
import com.oycbest.oyc.service.SsmUserService;
import org.springframework.stereotype.Service;

/**
 * (SsmUser)表服务实现类
 *
 * @author oyc
 * @since 2020-04-28 23:21:54
 */
@Service("ssmUserService")
public class SsmUserServiceImpl extends ServiceImpl<SsmUserMapper, SsmUser> implements SsmUserService {
}
