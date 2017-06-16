package com.example.demo.exception;

/**
 * Created by tianxianglan on 2017/6/17.
 */
public class InvalidException extends RuntimeException {

    private int code;

    public InvalidException(int code, String errmsg){
        super(errmsg);
        this.code = code;
    }
}
