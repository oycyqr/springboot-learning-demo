package com.oyc.sso;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//启动CAS @EnableCasClient
@EnableCasClient
@SpringBootApplication
public class SpringBootSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSsoApplication.class, args);
    }

}
