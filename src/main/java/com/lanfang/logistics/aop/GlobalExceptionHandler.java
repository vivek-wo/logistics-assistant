package com.lanfang.logistics.aop;

import com.lanfang.logistics.exception.LogisticsAssistantException;
import com.lanfang.logistics.vo.ResultVo;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = LogisticsAssistantException.class)
    public ResultVo<Void> handlerLogisticsAssistantException(LogisticsAssistantException e) {
        return ResultVo.error(-1, e.getCode() + "-" + e.getMessage());
    }

    /*拦截表单绑定异常*/
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = BindException.class)
    public ResultVo<Void> handlerBindException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        return ResultVo.error(-1, Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
    }
}
