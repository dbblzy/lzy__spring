package com.hou.lzy.exception;


import com.hou.lzy.result.Result;
import com.hou.lzy.result.ResultFactory;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 23868
 */
@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleAuthorizationException(UnauthenticatedException e){
        String message="权限认证失败";
        return ResultFactory.buildFailResult(message);
    }
}
