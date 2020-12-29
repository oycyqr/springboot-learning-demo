package com.oyc.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @ClassName: SpringBootSecurityTokenApplication
 * @Description: SpringBootSecurityTokenApplication
 * @Author oyc
 * @Date 2020/12/29 10:26
 * @Version 1.0
 */
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SpringBootSecurityTokenApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityTokenApplication.class, args);
    }
}
