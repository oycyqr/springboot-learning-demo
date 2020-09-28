package com.oycbest.springbootredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author: oyc
 * @date: 2020/9/28 14:58
 */
@RestController
@RequestMapping("/test")
public class OyRedisTestController {
    /**
     * 依赖注入，注入redisTemplate
     */
    @Autowired
    private RedisTemplate redisTemplate;

    private static String KEY_STRING_PREFIX = "oyc:redis:string:";
    private static String KEY_LIST_PREFIX = "oyc:redis:list:";
    private static String KEY_HASH_PREFIX = "oyc:redis:hash:";
    private static String KEY_SET_PREFIX = "oyc:redis:set:";
    private static String KEY_ZSET_PREFIX = "oyc:redis:zset:";

    @RequestMapping("string")
    public String stringTest(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "value", required = false) String value) {
        key = !StringUtils.isEmpty(key) ? KEY_STRING_PREFIX + key : KEY_STRING_PREFIX + "k1";
        redisTemplate.opsForValue().set(key, KEY_STRING_PREFIX + "value:" + value);
        return (String) redisTemplate.opsForValue().get(key);
    }

    @RequestMapping("list")
    public Object listTest(@RequestParam(value = "key", required = false) String key) {
        key = !StringUtils.isEmpty(key) ? KEY_LIST_PREFIX + key : KEY_LIST_PREFIX + "k1";
        ListOperations listOperations = redisTemplate.opsForList();
        listOperations.rightPushAll(key, KEY_LIST_PREFIX + "value:1", KEY_LIST_PREFIX + "value:2", KEY_LIST_PREFIX + "value:3");
        List range = listOperations.range(key, 0, -1);
        //listOperations.rightPop(key);
        System.out.println(range.toArray());
        return range;
    }

    @RequestMapping("hash")
    public Object hashTest(@RequestParam(value = "key", required = false) String key) {
        key = !StringUtils.isEmpty(key) ? KEY_HASH_PREFIX + key : KEY_HASH_PREFIX + "k1";
        HashOperations hashOperations = redisTemplate.opsForHash();
        HashMap<String, Object> user1 = new HashMap<String, Object>() {{
            put("name", "ouyang");
            put("age", 18);
            put("sex", "male");
            put("email", "1456682842@qq.com");
            put("adress", "China:GuangZhou");
        }};
        HashMap<String, Object> user2 = new HashMap<String, Object>() {{
            put("name", "oyc");
            put("age", 20);
            put("sex", "male");
            put("email", "1456682842@qq.com");
            put("adress", "GuangZhou");
        }};
        HashMap<String, Object> user3 = new HashMap<String, Object>() {{
            put("name", "oo");
            put("age", 21);
            put("sex", "male");
            put("email", "1456682842@qq.com");
            put("adress", "China");
        }};

        hashOperations.putAll(key, user1);
        hashOperations.putAll("hash1", user1);
        hashOperations.putAll("hash2", user2);
        hashOperations.putAll("hash3", user3);
        Object name = hashOperations.get(key, "name");
        Object age = hashOperations.get(key, "age");
        Object sex = hashOperations.get(key, "sex");
        Object email = hashOperations.get(key, "email");
        Object adress = hashOperations.get(key, "adress");

        HashMap<Object, Object> user = new HashMap<>();
        user.put("name", name);
        user.put("age", age);
        user.put("sex", sex);
        user.put("email", email);
        user.put("adress", adress);

        hashOperations.increment(key, "age", 10);
        Set keys = hashOperations.keys(key);
        System.out.print("\nkeys:");
        keys.stream().forEach(k -> System.out.print(k + " "));
        String finalKey = key;
        System.out.print("\nvalues:");
        keys.stream().forEach(k -> System.out.print(hashOperations.get(finalKey, k) + " "));
        return user;
    }


    @RequestMapping("set")
    public Object setTest(@RequestParam(value = "key", required = false) String key) {
        //key = !StringUtils.isEmpty(key) ? KEY_HASH_PREFIX + key : KEY_HASH_PREFIX + "k1";
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add(key, 1, 2, 3, 5, 6, 4, 1, 1, 2, 5, 6);

        Set members = setOperations.members(key);
        System.out.print("\nmembers:");
        members.stream().forEach(k -> System.out.print(k + " "));

        System.out.println("\n是否存在1：" + setOperations.isMember(key, 1));
        System.out.println("size：" + setOperations.size(key));
        setOperations.add(key, 11, 12);
        System.out.println("size：" + setOperations.size(key));
        System.out.println("randomMember：" + setOperations.randomMember(key));

        members = setOperations.members(key);
        System.out.print("\nmembers:");
        members.stream().forEach(k -> System.out.print(k + " "));


        setOperations.add("set1", 1, 2, 3);
        setOperations.add("set2", "a", "b", "c");
        System.out.print("\nset1 - members:");
        setOperations.members("set1").stream().forEach(k -> System.out.print(k + " "));
        System.out.print("\nset2 - members:");
        setOperations.members("set2").stream().forEach(k -> System.out.print(k + " "));

        setOperations.move("set1", 1, "set2");
        System.out.print("\nafter move ---- members:");
        setOperations.members("set1").stream().forEach(k -> System.out.print(k + " "));
        System.out.print("\nafter move ---- members:");
        setOperations.members("set2").stream().forEach(k -> System.out.print(k + " "));

        return members;
    }

    @RequestMapping("zset")
    public Object zSetTest(@RequestParam(value = "key", required = false) String key) {
        //key = !StringUtils.isEmpty(key) ? KEY_HASH_PREFIX + key : KEY_HASH_PREFIX + "k1";
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add(key, 1, 10);
        zSetOperations.add(key, 4, 40);
        zSetOperations.add(key, 2, 20);
        zSetOperations.add(key, 2, 25);
        zSetOperations.add(key, 8, 80);
        zSetOperations.add(key, 3, 30);
        zSetOperations.add(key, 9, 90);
        zSetOperations.add(key, 10, 100);
        Set range = zSetOperations.range(key, 0, -1);

        System.out.print("\nset range:");
        range.stream().forEach(k -> System.out.print(k + " "));

        Set set = zSetOperations.rangeByScore(key, 85, 300);
        System.out.print("\nset rangeByScore(85,300):");
        set.forEach(k -> System.out.print(k + " "));

        System.out.println("\nset rangeByScore(85,300) count:" + zSetOperations.count(key, 85, 300));

        zSetOperations.remove(key, 7);
        System.out.print("\nafter remove 7:");
        zSetOperations.range(key, 0, -1).forEach(k -> System.out.print(k + " "));

        System.out.println("\n9 score:" + zSetOperations.score(key, 9));


        return range;
    }
}
