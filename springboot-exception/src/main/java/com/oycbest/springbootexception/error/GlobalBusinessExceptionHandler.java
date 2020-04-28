package com.oycbest.springbootexception.error;

import com.oycbest.springbootexception.exception.ServiceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述：统一业务异常处理类
 *
 * @author Ay
 * @date 2017/12/3
 */
@ControllerAdvice(basePackages = {"com.oycbest.springbootexception",})
public class GlobalBusinessExceptionHandler {

    /**
     * 全局异常处理类
     *
     * @author yangwei
     * <p>
     * 用于全局返回json，如需返回ModelAndView请使用ControllerAdvice
     * 继承了ResponseEntityExceptionHandler，对于一些类似于请求方式异常的异常进行捕获
     */
    @RestControllerAdvice
    public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


        /**
         * 重写handleExceptionInternal，自定义处理过程
         **/

        @ExceptionHandler(value = Exception.class)

        @ResponseBody

        public ErrorInfo defaultException(HttpServletRequest request, Exception e) {

            e.printStackTrace();
            ErrorInfo returnVO = new ErrorInfo();
            String errorName = e.getClass().getName();
            errorName = errorName.substring(errorName.lastIndexOf(".") + 1);
            //如果没有定义异常，而是直接抛出一个运行时异常，需要进入以下分支
            if (e.getClass() == ServiceException.class) {
                returnVO.setMessage("" + ": " + e.getMessage()+ReturnCode.FAIL.code());
                returnVO.setCode(ReturnCode.FAIL.code());
            }

            return returnVO;

        }

        /**
         * 异常捕获
         *
         * @param e 捕获的异常
         * @return 封装的返回对象
         **/
        @ExceptionHandler(ServiceException.class)
        public ErrorInfo handlerException(ServiceException e) {

            e.printStackTrace();
            Integer code = e.getCode();
            String message = e.getMessage();
            if (e.getCode() == null) {
                code = ReturnCode.FAIL.code();
            }
            if (e.getMessage() == null) {
                message = ReturnCode.FAIL.msg();
            }
            ErrorInfo returnVO = new ErrorInfo();
            String errorName = e.getClass().getName();
            errorName = errorName.substring(errorName.lastIndexOf(".") + 1);
            //如果没有定义异常，而是直接抛出一个运行时异常，需要进入以下分支
            if (e.getClass() == ServiceException.class) {
                returnVO.setMessage("" + ": " + e.getMessage());
                returnVO.setCode(code);
            } else {
                returnVO.setMessage("oyc");
                returnVO.setCode(201);
            }
            return returnVO;
        }
    }
}
