package com.oycbest.blog.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * API日志表(SysServiceLog)实体类
 *
 * @author oyc
 * @since 2020-12-16 00:02:35
 */
public class SysServiceLog implements Serializable {
    private static final long serialVersionUID = 508605408655839206L;
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
    private Date requestTime;
    /**
    * 响应时间
    */
    private Date responseTime;
    /**
    * 是否成功（0失败 1成功）
    */
    private Integer successStatus;
    /**
    * 接口名称
    */
    private String apiName;
    /**
    * 请求参数
    */
    private String requestMessage;
    /**
    * 返回报文
    */
    private String responseMessage;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Integer spendTime) {
        this.spendTime = spendTime;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public Integer getSuccessStatus() {
        return successStatus;
    }

    public void setSuccessStatus(Integer successStatus) {
        this.successStatus = successStatus;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

}