package com.oycbest.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oycbest.blog.dao.ToBlogUserTokenDao;
import com.oycbest.blog.entity.ToBlogUserToken;
import com.oycbest.blog.service.ToBlogUserTokenService;
import org.springframework.stereotype.Service;

/**
 * 系统用户Token(ToBlogUserToken)表服务实现类
 *
 * @author oyc
 * @since 2020-12-16 11:17:15
 */
@Service("toBlogUserTokenService")
public class ToBlogUserTokenServiceImpl extends ServiceImpl<ToBlogUserTokenDao, ToBlogUserToken> implements ToBlogUserTokenService {

}