package com.oyc.security.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName: CasProperties
 * @Description: CAS的配置参数
 * @Author oyc
 * @Date 2020/12/24 16:32
 * @Version 1.0
 */
@Component
@Data
public class CasProperties {

    @Value("${cas.server.url}")
    private String casServerUrl;

    @Value("${cas.server.login_url}")
    private String casServerLoginUrl;

    @Value("${cas.server.logout_url}")
    private String casServerLogoutUrl;

    @Value("${app.server.url}")
    private String appServerUrl;
}
