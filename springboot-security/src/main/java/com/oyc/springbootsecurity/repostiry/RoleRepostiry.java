package com.oyc.springbootsecurity.repostiry;

import com.oyc.springbootsecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName: UserRepostiry
 * @Description: UserRepostiry
 * @Author oyc
 * @Date 2020/12/21 15:30
 * @Version 1.0
 */
public interface RoleRepostiry extends JpaRepository<Role, Integer> {
}