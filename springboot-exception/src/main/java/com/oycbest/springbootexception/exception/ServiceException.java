package com.oycbest.springbootexception.exception;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/4/26 9:47 下午
 */
public class ServiceException extends RuntimeException {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ServiceException(String msg){
           super(msg);
     }
 
 
 
     public ServiceException(Integer code,String msg){
           super(msg);
           this.code=code;
     }
}
