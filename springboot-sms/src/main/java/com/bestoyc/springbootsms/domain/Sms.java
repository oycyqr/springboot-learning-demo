package com.bestoyc.springbootsms.domain;

import lombok.Data;

/**
 * @ClassName Sms
 * @Description 短信参数
 * @Author oyc
 * @Date 2020/11/22 22:43
 * @Version
 */
@Data
public class Sms {

    /**
     * 签名
     */
    private String sign ;
    /**
     * 模板
     */
    private String templateId;
    /**
     * 手机号
     */
    private String[] mobile;
    /**
     * 模板参数 {}
     */
    private String[] params;
}