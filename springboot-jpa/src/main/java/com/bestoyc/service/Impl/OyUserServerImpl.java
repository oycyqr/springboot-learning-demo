package com.bestoyc.service.Impl;

import com.bestoyc.dao.OyUserRepository;
import com.bestoyc.entity.OyUser;
import com.bestoyc.service.OyUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author oyc
 * @Description: 用户服务实现类
 * @date 2018/7/1 615:07
 */
@Service
public class OyUserServerImpl implements OyUserService {
    /**
     * 依赖注入，注入用户JPA接口类
     */
    @Resource
    private OyUserRepository oyUserRepository;

    @Override
    public List<OyUser> getUserList() {
        List<OyUser> list = oyUserRepository.findAll();
        return list;
    }

    @Override
    public OyUser getUserById(String userId) {
        return oyUserRepository.getOne(userId);
    }
}
