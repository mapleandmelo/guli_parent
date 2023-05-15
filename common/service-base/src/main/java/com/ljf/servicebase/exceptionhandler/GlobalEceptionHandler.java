package com.ljf.servicebase.exceptionhandler;

import com.ljf.commonutils.R;
import com.ljf.servicebase.handler.liujingfengException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther:liujingfeng
 * @Date: 2022/1/28
 */
@ControllerAdvice
@Slf4j
public class GlobalEceptionHandler {
    //指定出现什么异常的时候执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody//返回数据
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("执行了全局异常处理");
    }

    //特定异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody //返回数据
    public R error(ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException的异常处理");
    }

    //自定义异常
    @ExceptionHandler(liujingfengException.class)
    @ResponseBody
    public R error(liujingfengException e){
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error().message(e.getMsg()).code(e.getCode());
    }
}
