package com.oycbest.springbootvalidated;

import com.oycbest.springbootvalidated.limit.AccessLimit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/10/22 11:36 下午
 */
@RestController
@RequestMapping("access")
public class AccessLimitController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 限流测试
     */
    @GetMapping
    @AccessLimit(maxCount = 3,second = 60)
    public String limit(HttpServletRequest request) {
        logger.error("Access Limit Test");
        return "限流测试";
    }

}