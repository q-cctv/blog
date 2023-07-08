package com.example.springbootblog.exception;

public class ServiceException extends RuntimeException{
//    private String code;
//    public String getCode(){
//        return code;
//    }
    public ServiceException(String message) {
        super(message);
    }
}
