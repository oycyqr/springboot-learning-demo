package com.bestoyc.dao;


import com.bestoyc.entity.OyUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 用户JPA接口类，继承JPA的JpaRepository,利用Spring Data JPA 的JpaRepository实现数据的操作
 * 继承CrudRepository接口 <实体类, 主键类型> JPA根据实体类的类名去对应表名（可以使用@Entity的name属性？@Table进行修改）
 */
public interface OyUserCrudRepository extends CrudRepository<OyUser, Integer> {
	List<OyUser> findByName(String name);
	List<OyUser> findByNameLike(String name);
	List<OyUser> findBySex(String sex);
	List<OyUser> findByAgeBetween(int ageStart,int ageEnd);
	List<OyUser> findByAgeBetweenOrderByAge(int ageStart,int ageEnd);
	List<OyUser> findByAgeLessThan(int age);
	List<OyUser> findByAgeGreaterThan(int age);
	List<OyUser> findByNameLikeOrderByCreateTime(String name);
}
