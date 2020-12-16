package com.oycbest.blog.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: MybatisPlusConfig
 * @Description: MybatisPlus 配置类
 * @Author oyc
 * @Date 2020年12月16日 14:55
 * @Version 1.0
 */
@EnableTransactionManagement
@Configuration
@MapperScan(value = "com.oycbest.blog.dao")
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
