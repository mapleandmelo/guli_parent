package com.ljf.servicebase.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther:liujingfeng
 * @Date: 2022/1/28
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class liujingfengException extends RuntimeException{
    private Integer code;//状态码
    private String msg;//异常提示信息
}
