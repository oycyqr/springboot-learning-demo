package com.oycbest.springbootvalidated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName LimitController
 * @Description 限流控制类
 * @Author oyc
 * @Date 2020/10/22 17:04
 * @Version
 */
@RestController
@RequestMapping("limit")
public class LimitController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * @Title: limitTest
     * @Description: 限流测试
     */
    @GetMapping
    public String limitTest(HttpServletRequest request) {
        logger.debug("limitTest");
        String key = request.getRemoteAddr();
        Object o = redisTemplate.opsForValue().get(key);
        logger.debug("get key:", o);
        if (o == null) {
            // 增加请求次数，保留60秒
            redisTemplate.opsForValue().set(key, 1, 60, TimeUnit.SECONDS);
        } else {
            int count = (int) o;
            if (count < 5) {
                // 请求次数增加，保留60秒
                redisTemplate.opsForValue().set(key, count + 1, 60, TimeUnit.SECONDS);
            } else {
                return "请求太频繁，请稍后重试";
            }
        }
        return "limitTest";
    }


}
