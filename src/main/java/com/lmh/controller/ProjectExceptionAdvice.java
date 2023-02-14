package com.lmh.controller;


import com.lmh.Exception.BusinessException;
import com.lmh.Exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//异常处理
//声明异常处理类
@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(SystemException.class)
    public Result SystemException(SystemException ex){

        //记录日志
        //发送消息给运维
        //发送消息给开发


        return new Result(ex.getCode(),null,ex.getMessage());
    }
    @ExceptionHandler(BusinessException.class)
    public Result BusinessException(BusinessException ex){

        //记录日志
        //发送消息给运维
        //发送消息给开发


        return new Result(ex.getCode(),null,ex.getMessage());
    }
    //处理何种异常
    @ExceptionHandler(ArithmeticException.class)
    public Result doException(Exception ex){
        System.out.println("捕获异常");
        return new Result(666,null,"有异常");
    }
}
