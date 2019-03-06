package com.hs.core.controller.exception;

import com.hs.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 统一异常处理
 */
@ControllerAdvice
@Slf4j
public class ControllerErrorHandler {

    /**
     * 无数据接口访问权限
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    public Result<?> noAuth(Exception e) {
        log.debug(e.getMessage());
        Result<Object> result = new Result<>();
        result.setCode(404);
        result.setMsg("异常");
        return result;
    }

}
