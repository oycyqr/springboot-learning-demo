package com.oycbest.springbootexception.error;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/4/26 10:14 下午
 */
public enum ReturnCode {

    /**
     * 操作成功
     */
    SUCCESS(2000, "操作成功"),

    /**
     * 操作失败
     */
    FAIL(5000, "操作失败"),

    /**
     * 空指针异常
     */
    NullPointerException(5001, "空指针异常"),

    /**
     * 自定义异常之返回值为空
     */
    NullResponseException(5002, "返回值为空"),

    /**
     * 运行时异常
     */
    RuntimeException(5001, "运行时异常"),

    /**
     * 请求方式错误异常
     */
    HttpRequestMethodNotSupportedException(404, "页面路径有误"),

    /**
     * INTERNAL_ERROR
     */
    BindException(4000, "请求方式异常"),

    /**
     * 页面路径不对
     */
    UrlError(4001, "请求参数绑定失败");

    private ReturnCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    private Integer code;
    private String msg;
}