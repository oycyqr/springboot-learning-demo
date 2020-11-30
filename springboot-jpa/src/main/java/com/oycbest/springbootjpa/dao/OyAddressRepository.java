package com.oycbest.springbootjpa.dao;


import com.oycbest.springbootjpa.entity.OyAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 用户JPA接口类，继承JPA的JpaRepository,利用Spring Data JPA 的JpaRepository实现数据的操作
 * 继承JpaRepository接口 <实体类, 主键类型> JPA根据实体类的类名去对应表名（可以使用@Entity的name属性？@Table进行修改）
 *
 * @author oyc
 */
public interface OyAddressRepository extends JpaRepository<OyAddress,Integer> , JpaSpecificationExecutor {
}
