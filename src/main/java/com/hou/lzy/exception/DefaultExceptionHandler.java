package com.hou.lzy.exception;


import com.hou.lzy.result.Result;
import com.hou.lzy.result.ResultFactory;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 23868
 */
@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(value = Exception.class)//处理访问方法时权限不足问题
    public Result exceptionHandler(Exception e) {
        String message = null;

        if (e instanceof IllegalArgumentException) {
            message = "传入了错误的参数";
        }


        if (e instanceof UnauthorizedException) {
            message = "权限认证失败";
        }

        return ResultFactory.buildFailResult(message);
    }
}
