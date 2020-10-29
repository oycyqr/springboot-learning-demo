package com.oycbest.springbootshardingsphere.controller;

import com.oycbest.springbootshardingsphere.domain.TEncrypt;
import com.oycbest.springbootshardingsphere.mapper.TEncryptMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName TEncryptController
 * @Description TEncryptController
 * @Author oyc
 * @Date 2020/10/24 16:56
 * @Version
 */
@RestController
@RequestMapping("tencrypt")
public class TEncryptController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TEncryptMapper tEncryptMapper;

    /**
     * 列表
     *
     * @return
     */
    @RequestMapping
    public List List() {
        logger.info("********TestController tEncryptMapper()");
        List tEncrypts = tEncryptMapper.selectList(null);
        return tEncrypts;
    }

    /**
     * 保存
     *
     * @return
     */
    @PostMapping
    public Object save(TEncrypt tEncrypt) {
        logger.info("********save User");
        int insert = tEncryptMapper.insert(tEncrypt);
        return tEncrypt;
    }
}