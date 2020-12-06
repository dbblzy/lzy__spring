package com.hou.lzy.result;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor

public class Result {
    //响应码
    private int code;
    private String message;
    private Object result;

}
