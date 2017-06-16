package com.example.demo.controller;

import com.example.demo.common.Response;
import com.example.demo.exception.InvalidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianxianglan on 2017/6/17.
 */
@RestController
@ControllerAdvice
public class ExceptionController {

    private static Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(value = InvalidException.class)
    public Response doException(Exception e){
        LOGGER.error("无效操作!");
        return new Response(e.getMessage());
    }

}
