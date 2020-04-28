package com.oycbest.springbootjpa.service.Impl;

import com.oycbest.springbootjpa.dao.OyUserRepository;
import com.oycbest.springbootjpa.entity.OyUser;
import com.oycbest.springbootjpa.service.OyUserService;
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
		return oyUserRepository.findAll();
    }

    @Override
    public OyUser getUserById(Integer userId) {
        return oyUserRepository.getOne(userId);
    }

    @Override
    public OyUser addUser(OyUser user) {
        return oyUserRepository.save(user);
    }

    @Override
    public OyUser updateUser(OyUser user) {
        return oyUserRepository.save(user);
    }

    @Override
    public void delUser(Integer userId) {
        oyUserRepository.deleteById(userId);
    }
}
