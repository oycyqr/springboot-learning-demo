package com.oycbest.springbootredis.controller;

import com.oycbest.springbootredis.entity.OyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: oyc
 * @Description: redis 测试控制类
 * @Since 2020年5月12日 23:35:05
 */
@RestController
@RequestMapping("/redis")
public class OyRedisController {
    /**
     * 依赖注入，注入redisTemplate
     */
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 测试redis string add
     */
    @GetMapping("/string/add")
    public String addStringKeyValue(@RequestParam(value = "key", defaultValue = "key1") String key, @RequestParam(value = "value", defaultValue = "redis value") String value) {
        redisTemplate.opsForValue().set(key, value);
        return (String) redisTemplate.opsForValue().get(key);
    }

    /**
     * 测试redis string add
     */
    @GetMapping("/object/add")
    public Object addObjectKeyValue(@RequestParam(value = "key", defaultValue = "key1") String key) {
        OyUser user = new OyUser(1, "宋江", "18", "male");
        redisTemplate.opsForValue().set(key, user);
        return redisTemplate.opsForValue().get(key);
    }


    /**
     * 测试redis string get
     */
    @GetMapping("/string/get")
    public Object getStringByKey(@RequestParam(value = "key", defaultValue = "key1") String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
