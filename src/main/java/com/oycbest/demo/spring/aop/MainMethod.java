package com.oycbest.demo.spring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/8/31 10:12 下午
 */
@Component
public class MainMethod {

    Logger logger = LoggerFactory.getLogger(MainMethod.class);

    /**
     * 除法操作
     *
     * @param i 被除数
     * @param j 除数
     * @return
     * @throws Exception
     */
    public int div(int i, int j) throws Exception {
        logger.info("执行div：{}/{}", i, j);
        return i / j;
    }
}
