package com.oycbest.springbootvalidated.limit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 访问拦截器
 * @Author oyc
 * @Date 2020/10/22 11:20 下午
 */
@Component
public class AccessLimitInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {// Handler 是否为 HandlerMethod 实例
            if (handler instanceof HandlerMethod) {
                // 强转
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                // 获取方法
                Method method = handlerMethod.getMethod();
                // 是否有AccessLimit注解
                if (!method.isAnnotationPresent(AccessLimit.class)) {
                    return true;
                }
                // 获取注解内容信息
                AccessLimit accessLimit = method.getAnnotation(AccessLimit.class);
                if (accessLimit == null) {
                    return true;
                }
                int seconds = accessLimit.second();
                int maxCount = accessLimit.maxCount();

                // 存储key
                String key = request.getRemoteAddr() + ":" + request.getContextPath() + ":" + request.getServletPath();

                // 已经访问的次数
                Long count = redisTemplate.opsForValue().increment(key, 1);
                System.out.println("已经访问的次数:" + count);
                if (count == 1) {
                    redisTemplate.expire(key,seconds,TimeUnit.SECONDS);
                    return true;
                }

                if (count > maxCount) {
                    logger.warn("请求过于频繁请稍后再试");
                    render(response,"请求过于频繁请稍后再试");
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            logger.warn("请求过于频繁请稍后再试");
            e.printStackTrace();
        }
        return true;
    }
    private void render(HttpServletResponse response, String msg)throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        out.write(msg.getBytes("UTF-8"));
        out.flush();
        out.close();
    }

}
