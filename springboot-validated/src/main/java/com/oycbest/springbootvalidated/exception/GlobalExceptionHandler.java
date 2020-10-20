package com.oycbest.springbootvalidated.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ValidationException;

/**
 * 全局异常处理
 *
 * @author oyc
 */
@ControllerAdvice
@Component
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handle(ValidationException exception) {
        logger.error("请求异常：" + exception.getMessage());
        return "请求异常： " + exception.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String defaultException(Exception e) {
        if(e instanceof ValidationException){
            System.out.println(123);
        }
        logger.error("请求异常：" + e.getMessage());
        return "请求异常： " + e.getMessage();
    }
    /**
     * 重写handleExceptionInternal，自定义处理过程
     **/
    /*@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo defaultException(HttpServletRequest request, Exception e) {
        ErrorInfo returnVO = new ErrorInfo();
        String errorName = e.getClass().getName();
        errorName = errorName.substring(errorName.lastIndexOf(".") + 1);
        //如果没有定义异常，而是直接抛出一个运行时异常，需要进入以下分支
        if (e.getClass() == ServiceException.class) {
            returnVO.setMessage("" + ": " + e.getMessage()+ReturnCode.FAIL.code());
            returnVO.setCode(ReturnCode.FAIL.code());
        }

        return returnVO;

    }*/
}
