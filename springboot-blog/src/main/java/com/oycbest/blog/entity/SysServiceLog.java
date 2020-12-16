package com.oycbest.blog.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * API日志表(SysServiceLog)表实体类
 *
 * @author oyc
 * @since 2020-12-16 11:29:12
 */
@SuppressWarnings("serial")
@Data
public class SysServiceLog extends Model<SysServiceLog> {

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date requestTime;

    /**
     * 响应时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}