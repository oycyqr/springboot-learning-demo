package com.bestoyc.springbootsms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName SendSmsProperties
 * @Description 腾讯云短信
 * @Author oyc
 * @Date 2020/11/22 22:40
 * @Version 1.0.1
 */
@Data
@ConfigurationProperties(prefix = "tencentcloud.sms")
public class SendSmsProperties {
    private String secretId;
    private String secretKey;
    private String appId;
    private String sign;
    private String templateId;
}