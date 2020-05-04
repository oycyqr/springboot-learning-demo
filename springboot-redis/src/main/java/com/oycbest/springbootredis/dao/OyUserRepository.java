package com.oycbest.springbootredis.dao;


import com.oycbest.springbootredis.entity.OyUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户JPA接口类，继承JPA的JpaRepository,利用Spring Data JPA 的JpaRepository实现数据的操作
 *
 * @author ouyangcheng
 */
public interface OyUserRepository extends JpaRepository<OyUser,Integer> {
}
