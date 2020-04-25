package com.bestoyc.dao;


import com.bestoyc.entity.OyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 用户JPA接口类，继承JPA的JpaRepository,利用Spring Data JPA 的JpaRepository实现数据的操作
 * 继承JpaRepository接口 <实体类, 主键类型> JPA根据实体类的类名去对应表名（可以使用@Entity的name属性？@Table进行修改）
 *
 */
public interface OyUserRepository extends JpaRepository<OyUser,Integer> , JpaSpecificationExecutor {

    /**
     * 根据姓名查找
     * @param name
     * @return
     */
    List<OyUser> findByName(String name);

    /**
     * 根据姓名模糊查找
     * @param name
     * @return
     */
    List<OyUser> findByNameLike(String name);

    /**
     * 根据性别查找
     * @param sex
     * @return
     */
    List<OyUser> findBySex(String sex);

    /**
     * 根据年龄区间查找
     * @param ageStart
     * @param ageEnd
     * @return
     */
    List<OyUser> findByAgeBetween(int ageStart,int ageEnd);

    /**
     * 根据年龄区间查找并按年龄排序
     * @param ageStart
     * @param ageEnd
     * @return
     */
    List<OyUser> findByAgeBetweenOrderByAge(int ageStart,int ageEnd);

    /**
     * 根据年龄区间排序查找
     * @param age
     * @return
     */
    List<OyUser> findByAgeLessThan(int age);

    /**
     * 根据年龄查找并且按创建时间排序查找
     * @param age
     * @return
     */
    List<OyUser> findByAgeGreaterThan(int age);

    /**
     * 根据姓名查询，并按创建时间排序查找
     * @param name
     * @return
     */
    List<OyUser> findByNameLikeOrderByCreateTime(String name);
}
