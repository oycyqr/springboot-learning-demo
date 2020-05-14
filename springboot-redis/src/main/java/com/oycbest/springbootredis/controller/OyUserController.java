package com.oycbest.springbootredis.controller;

import com.oycbest.springbootredis.entity.OyUser;
import com.oycbest.springbootredis.service.OyUserService;
import com.oycbest.springbootredis.util.RedisUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author oyc
 * @Description: 用户控制类
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

    public static final String USER_KEY_ONE_PREFIX = "oyUser:";
    public static final String USER_KEY_ALL_PREFIX = "oyUserList:";
    public static final String USER_KEY_HASH_PREFIX = "oyUserHash:";


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Object selectOne(@PathVariable("id") Integer id) {
        // 先从缓存中查询用户，找不到再从数据库查询
        Object user = redisTemplate.opsForHash().get(USER_KEY_HASH_PREFIX, USER_KEY_ONE_PREFIX + id);
        if (user == null) {
            // 从数据库查询并记录到缓存
            user = oyUserService.getUserById(id);
            redisTemplate.opsForHash().put(USER_KEY_HASH_PREFIX, USER_KEY_ONE_PREFIX + id, user);
        }
        return user;
    }

    /**
     * 查询用户列表
     *
     * @return 用户列表
     */
    @GetMapping("list")
    public List<OyUser> list() {
        // 先从缓存中查询用户，找不到再从数据库查询
        List<OyUser> list = redisTemplate.opsForList().range(USER_KEY_ALL_PREFIX, 0, -1);
        if (list == null || list.isEmpty()) {
            // 从数据库查询并记录到缓存
            list = oyUserService.getUserList();
            redisTemplate.opsForList().leftPushAll(USER_KEY_ALL_PREFIX, list);
        }
        return list;
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
        OyUser sUser = null, hUser = null, zSuer = null;
        System.out.println(user.toString());


        /**
         * string
         *
         */
        try {
            redisUtil.set("oyc1", user);
            sUser = (OyUser) redisUtil.get("oyc1");
        } catch (Exception e) {
            e.printStackTrace();
        }


        /**
         * List
         */
        Object obj = null;
        try {
            redisUtil.lSet("user1", user);
            redisUtil.lSet("user2", user);
            redisUtil.lSet("user3", user);
            redisUtil.lSet("user4", user);
            OyUser lUser = (OyUser) redisUtil.lGetIndex("user1", 0);
            System.out.println(lUser.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * hash
         */
        try {
            redisUtil.hset("user", "oyc1", user);
            redisUtil.hset("user", "oyc2", user);
            redisUtil.hset("user", "oyc3", user);
            hUser = (OyUser) redisUtil.hget("user", "user1");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            HashMap<String, Object> userHashMap = new HashMap<>();
            userHashMap.put("oyc1", user);
            userHashMap.put("oyc2", user);
            userHashMap.put("oyc3", user);
            redisUtil.hmset("oyc", userHashMap);

            Map<Object, Object> hashMap = redisUtil.hmget("oyc");
            for (Object key : hashMap.keySet()) {
                System.out.println(key + "----" + hashMap.get(key).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * set
         */
        try {
            redisUtil.sSet("oyc1", user);
            redisUtil.sSet("oyc2", user);
            sUser = (OyUser) redisUtil.sGet("oyc1");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (sUser != null) {
            System.out.println(sUser.toString());
        }
        if (hUser != null) {
            System.out.println(hUser.toString());
        }
        if (zSuer != null) {
            System.out.println(zSuer.toString());
        }
        return (String) redisTemplate.opsForValue().get("user");
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
