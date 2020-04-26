package com.oycbest.springbootexception.error;

/**
 * 描述：错误信息类
 *
 * @author Ay
 * @date 2017/12/3
 */
public class ErrorInfo<T> {

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 默认构造，返回操作正确的返回代码和信息
     */
    public ErrorInfo() {
        this.setCode(ReturnCode.SUCCESS.code());
        this.setMessage(ReturnCode.SUCCESS.msg());
    }

    /**
     * 返回代码，这里需要在枚举中去定义
     * @param code
     */
    public ErrorInfo(ReturnCode code) {
        this.setCode(code.code());
        this.setMessage(code.msg());
    }

    /**
     * 返回数据，默认返回正确的code和message
     * @param data
     */
    public ErrorInfo(Object data) {
        this.setCode(ReturnCode.SUCCESS.code());
        this.setMessage(ReturnCode.SUCCESS.msg());
        this.setData(data);
    }

    /**
     * 返回错误的代码，以及自定义的错误信息
     * @param code
     * @param message
     */
    public  ErrorInfo(ReturnCode code, String message) {
        this.setCode(code.code());
        this.setMessage(message);
    }

    /**
     * 返回自定义的code，message，以及data
     * @param code
     * @param message
     * @param data
     */
    public  ErrorInfo(ReturnCode code, String message, Object data) {
        this.setCode(code.code());
        this.setMessage(message);
        this.setData(data);
    }

    @Override
    public String toString() {
        return " ErrorInfo{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
