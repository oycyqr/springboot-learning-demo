package com.oycbest.demo.redis;

import org.junit.Test;
import redis.clients.jedis.*;

import java.util.List;
import java.util.Set;

/**
 * @author: oyc
 * @date: 2020/9/16 10:47
 */
public class JedisDemo {
    public static void main(String[] args) {
        System.out.println("Jedis Demo");
        Jedis jedis = new Jedis("192.168.14.95",6379,3000);
        jedis.auth("123456");
        Set<String> keys = jedis.keys("*");
        keys.stream().forEach(k -> System.out.println(k));
        System.out.println("匹配以 user 为前缀的 key");
        // 游标初始值为0
        String cursor = ScanParams.SCAN_POINTER_START;
        String key = "user*";
        ScanParams scanParams = new ScanParams();
        // 匹配以 user 为前缀的 key
        scanParams.match(key);
        scanParams.count(1000);
        while (true){
            //使用scan命令获取数据，使用cursor游标记录位置，下次循环使用
            ScanResult<String> scanResult = jedis.scan(cursor, scanParams);
            // 返回0 说明遍历完成//getStringCursor();
            cursor = scanResult.getCursor();
            List<String> list = scanResult.getResult();
            long t1 = System.currentTimeMillis();
            for(int m = 0;m < list.size();m++){
                String mapentry = list.get(m);
                System.out.println(mapentry);
            }
            long t2 = System.currentTimeMillis();
            System.out.println("获取" + list.size()+ "条数据，耗时: " + (t2-t1) + "毫秒,cursor:" + cursor);
            if ("0".equals(cursor)){
                break;
            }
        }
    }

    @Test
    public  void poolTest() {
        JedisPool jedisPoolInstance = getJedisPoolInstance();
        Jedis jedis = jedisPoolInstance.getResource();
        System.out.println(jedis.ping());
        jedis.select(1);
        jedis.set("k1", "v1111");
        String k1 = jedis.get("k1");
        System.out.println(k1);
        System.out.println(jedis.get("k2"));
        System.out.println(jedis.get("k3"));
        System.out.println(jedis.get("k4"));
    }
    private static JedisPool jedisPool = null;
    public static JedisPool getJedisPoolInstance() {
        if (null == jedisPool) {
            synchronized (JedisDemo.class) {
                if (null == jedisPool) {
                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    poolConfig.setMaxTotal(1000);
                    poolConfig.setMaxIdle(32);
                    poolConfig.setMaxWaitMillis(100 * 1000);
                    poolConfig.setTestOnBorrow(true);

                    jedisPool = new JedisPool(poolConfig, "192.168.14.95", 6379,3000, "123456", false);
                }
            }
        }
        return jedisPool;
    }
    public static void release(JedisPool jedisPool, Jedis jedis) {
        if (null != jedis) {
            Jedis jedis2 = null;
            try {
                jedis2 = jedisPool.getResource();
            } finally {
                jedis2.close();
            }
        }
    }
}
