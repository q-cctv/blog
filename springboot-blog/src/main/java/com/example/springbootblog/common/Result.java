package com.example.springbootblog.common;

import lombok.Data;

@Data
public class Result {
    private static final String SUCCESS_CODE="200";
    private static final String ERROR_CODE="-1";
    private String code;
    private String msg;
    private Object data;
    public static Result success(){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        return result;
    }
    public static Result success(Object data){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setData(data);
        return result;
    }
    public static Result error(String msg){
        Result result = new Result();
        result.setCode(ERROR_CODE);
        result.setData(msg);
        return result;
    }
}
