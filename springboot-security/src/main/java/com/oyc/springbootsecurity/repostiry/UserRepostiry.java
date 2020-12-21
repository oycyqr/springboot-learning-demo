package com.oyc.springbootsecurity.repostiry;

import com.oyc.springbootsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @ClassName: UserRepostiry
 * @Description: UserRepostiry
 * @Author oyc
 * @Date 2020/12/21 15:30
 * @Version 1.0
 */
public interface UserRepostiry extends JpaRepository<User, Integer> {
    /**
     * 根据用户账号获取用户信息
     * @param account
     * @return
     */
    User findByAccount(@Param("account") String account);
}