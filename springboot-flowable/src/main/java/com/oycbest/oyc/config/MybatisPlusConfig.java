package com.oycbest.oyc.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description: Mybatis-Plus配置类
 * @Author oyc
 * @Date 2020/4/29 7:46 下午
 */
@EnableTransactionManagement
@Configuration
//扫描的mapper文件路径
@MapperScan("com.oycbest.oyc.mapper")
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
