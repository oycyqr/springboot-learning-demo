package com.oycbest.demo.springautowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: oyc
 * @date: 2020/8/20 14:30
 */
@Configuration
public class AutoWiredConfig {

    @Autowired
    private Address address;

    @Bean
    public User user1(){
        User user = new User();
        address.setCity("beijing1");
        user.setAddress(address);
        return user;
    }

    @Bean
    public User user2(@Autowired Address address){
        User user = new User();
        address.setCity("beijing2");
        user.setAddress(address);
        return user;
    }
}
