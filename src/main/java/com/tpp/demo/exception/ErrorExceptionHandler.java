/**
 * Copyright 2015-2016 广州市领课网络科技有限公司
 */
package com.tpp.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理类
 *
 * @author hugovon
 * @version 1.0
 */
@ControllerAdvice
@ResponseBody
public class ErrorExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ErrorExceptionHandler.class);

    /**
     * 统一异常处理
     *
     * @param exception exception
     * @return
     */
    @ExceptionHandler({RuntimeException.class})
    public String processException(RuntimeException exception) {
        return exception.getMessage();
    }

    /**
     * 统一异常处理
     *
     * @param exception exception
     * @return
     */
    @ExceptionHandler({Exception.class})
    public String processException(Exception exception) {
        logger.info("自定义异常处理-Exception");
        return exception.getMessage();
    }

}
