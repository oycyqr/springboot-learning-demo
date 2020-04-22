package com.oycbest.springbootredis.controller;

import com.oycbest.springbootredis.entity.OyUser;
import com.oycbest.springbootredis.service.OyUserService;
import com.oycbest.springbootredis.util.RedisUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author oyc
 * @Title:
 * @Description:用户控制类
 * @date 2018/7/1615:10
 */
@RestController
@RequestMapping("/user")
public class OyUserController {
    /**
     * 依赖注入，注入用户服务类
     */
    @Resource
    private OyUserService oyUserService;

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private RedisUtil redisUtil;


    /**
     * 测试redis
     */
    @GetMapping("/test/redis")
    public String testRedis() {
        redisTemplate.opsForValue().set("userName", "ouyang");
        return (String) redisTemplate.opsForValue().get("userName");
    }

    /**
     * 测试redis1
     */
    @GetMapping("/test/redis1")
    public String testRedis1() {
        redisUtil.set("user", "ouyangcheng");

        String userStr = (String) redisUtil.get("user");
        System.out.println("get UserStr From Redis:" + userStr);
        OyUser user = new OyUser(1, "oyc", "18", "male");
        redisUtil.hset("oyc","user", user);
        redisUtil.lSet("oyc1", user);

        System.out.println(user.toString());

        List<Object> userList = redisUtil.lGet("oyc1",0,-1);
        Object obj = redisUtil.hget("oyc","user");
        OyUser user1 = (OyUser) obj;
        System.out.println(user1.toString());

        return (String) redisTemplate.opsForValue().get("user");
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public OyUser selectOne(@PathVariable("id") Integer id) {
        return oyUserService.getUserById(id);
    }

    /**
     * 查询用户列表
     *
     * @return 用户列表
     */
    @GetMapping("list")
    public List<OyUser> list(ModelMap model) {
        return oyUserService.getUserList();
    }

    /**
     * 新增用户
     */
    @PostMapping
    public OyUser addUser(OyUser user) {
        return oyUserService.addUser(user);
    }

    /**
     * 修改用户
     */
    @PutMapping
    public OyUser updateUser(OyUser user) {
        return oyUserService.updateUser(user);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("{userId}")
    public void delUser(@PathVariable("userId") Integer userId) {
        oyUserService.delUser(userId);
    }
}
