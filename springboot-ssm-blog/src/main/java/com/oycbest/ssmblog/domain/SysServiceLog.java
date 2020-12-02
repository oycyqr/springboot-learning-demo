package com.oycbest.ssmblog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 系统日志实体类
 * @Author oyc
 * @Date 2020/11/19 11:11 下午
 */
@Data
public class SysServiceLog {

    /**
     * 主键ID
     */
    private Integer id;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 请求耗时
     */
    private Integer spendTime;
    /**
     * 请求时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date requestTime;
    /**
     * 响应时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date responseTime;
    /**
     * 是否成功（0失败 1成功)
     */
    private Boolean successStatus;
    /**
     * 接口名称
     */
    private String apiName;
    /**
     * 请求参数
     */
    private String requestMessage;
    /**
     *
     */
    private String responseMessage;
}
