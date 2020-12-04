package com.oycbest.springbootelasticsearch.repository;

import com.oycbest.springbootelasticsearch.document.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName BlogRepository
 * @Description TODO
 * @Author oyc
 * @Date 2020/12/4 22:32
 * @Version
 */
public interface BlogRepository extends JpaRepository<Blog, Integer>, JpaSpecificationExecutor {
}