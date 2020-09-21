package com.oycbest.springbootredis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author: oyc
 * @date: 2020/9/16 10:47
 */
@SpringBootTest
public class JedisDemo {

    private static RedisTemplate redisTemplate = new RedisTemplate();

    @Test
    public  void poolTest() {
        redisTemplate.opsForValue().set("k1", "v1");
        Object k1 = redisTemplate.opsForValue().get("k1");
        System.out.println(k1);
    }

    @Test
    public void poolTest1() {
       /* JedisPool jedisPoolInstance = getJedisPoolInstance();
        Jedis jedis = jedisPoolInstance.getResource();
        System.out.println(jedis.ping());
        jedis.select(2);

        //String
        System.out.println("\n*************************String*************************");
        jedis.set("k1", "v1");
        String k1 = jedis.get("k1");
        System.out.println(k1);
        jedis.mset("key1","value1","key2","value2","key3","value3","key4","value4");
        System.out.println(jedis.get("key1"));
        System.out.println(jedis.mget("key1","key2","key3"));
        //List
        System.out.println("\n*************************List*************************");
        jedis.lpush("mylist","v1","v2","v3","v4");
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        mylist.forEach(item -> System.out.print(item+" "));
        System.out.println("\nlpush - lpop:");
        for (int i = 0; i < mylist.size(); i++) {
            System.out.print(jedis.lpop("mylist")+" ");
        }
        System.out.println("\nlpush - rpop:");
        jedis.lpush("mylist","v1","v2","v3","v4");
        for (int i = 0; i < mylist.size(); i++) {
            System.out.print(jedis.rpop("mylist")+" ");
        }
        //Hash
        System.out.println("\n\n*************************Hash*************************");
        jedis.hset("myHash1","username","ouyang");
        System.out.println(jedis.hget("myHash1","username"));
        Map<String,String> map = new HashMap<>();
        map.put("username","ouyang");
        map.put("telPhone","18888888888");
        map.put("sex","male");
        map.put("height","180");
        map.put("adress","guangzhou");
        jedis.hmset("myHash2",map);
        System.out.println("");
        List<String> myHash2 = jedis.hmget("myHash2", "username", "telPhone", "sex", "height", "adress");
        myHash2.stream().forEach(item -> System.out.print(item + " "));

        //Set
        System.out.println("\n\n*************************Set*************************");
        jedis.sadd("set","set0001");
        jedis.sadd("set","set0002");
        jedis.sadd("set","set0003");
        jedis.sadd("set","set0004");
        jedis.sadd("set","set0003");
        Set<String> set = jedis.smembers("set");
        set.stream().forEach(s -> System.out.print(s+" "));

        //SortSet
        *//**
         * zset数据类型方法
         * zadd：向指定集合zset中添加元素member，score用于排序，如果该元素已经存在，则更新其顺序
         * zrange：查看sourted sets里面的所有元素
         * zrem：删除名称为key的zset中的元素member(即删除指定zset里面的指定元素)
         * zincrby：如果在某一个zset中已经存在元素member，则该元素的score增加increment。否则向该集合中添加该元素，其score的值就为指定的increment值
         * zrank：返回某一个zset中指定元素的索引值(不是插入的时候指定的那个顺序值，是元素的下标)。这个索引值是按照元素的score值从小到大排列的，score值越小，索引值(下标)就越小，score值越大，索引值(下标)就越大
         * zrevrank：返回某一个zset中指定元素的索引值(不是插入的时候指定的那个顺序值，是元素的下标)。这个索引值是按照元素的score值从大到小排列的，score值越小，索引值(下标)就越大，score值越大，索引值(下标)就越小
         * zrevrange：返回某一个zset集合中的指定区间的元素及其顺序值，按照score值从大到小降序排列，与zrange相反
         * zrangebyscore：返回集合中指定顺序值区间的元素
         * zcount：返回集合中指定顺序值区间的元素总数量
         * zcard：返回集合中的所有元素个数
         * zremrangebyrank：删除在集合中排名在给定索引值(下标)区间的元素(注意：是按照索引值删除，这里不是顺序值)
         * zremrangebyscore：删除在集合中排名在给定顺序值区间的元素(注意：是按照顺序值删除，这里不是索引值)
         *//*
        System.out.println("\n\n*************************SortSet*************************");
        jedis.zadd("zset",10d,"zset0001");
        jedis.zadd("zset",20d,"zset0002");
        jedis.zadd("zset",30d,"zset0003");
        jedis.zadd("zset",40d,"zset0004");
        jedis.zadd("zset",30d,"zset0003");
        Set<String> zset = jedis.zrange("zset",0,-1);
        zset.stream().forEach(s -> System.out.print(s+" "));

        Long zrevrank = jedis.zrevrank("zset", "zset0001");
        System.out.println(zrevrank);*/
    }

}
