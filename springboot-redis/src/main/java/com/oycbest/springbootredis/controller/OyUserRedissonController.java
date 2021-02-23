package com.oycbest.springbootredis.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author oyc
 * @Description: 用户控制类
 * @date 2018/7/1615:10
 */
@RestController
@RequestMapping("/redisson")
public class OyUserRedissonController {

    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping(value = "test")
    public ResponseEntity test() {
        RLock rLock = redissonClient.getLock("test");
        //获取分布式锁
        rLock.lock();
        System.out.println("rLock.getHoldCount() = " + rLock.getHoldCount());
        System.out.println("rLock.isLocked() = " + rLock.isLocked());
        //获取分布式锁
        System.out.println("rLock.tryLock() = " + rLock.tryLock());
        System.out.println("rLock.getHoldCount() = " + rLock.getHoldCount());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rLock.unlock();
            rLock.unlock();
        }
        return ResponseEntity.ok("响应成功");
    }
}
