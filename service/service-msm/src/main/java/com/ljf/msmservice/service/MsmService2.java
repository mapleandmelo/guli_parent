package com.ljf.msmservice.service;

import java.util.Map;

public interface MsmService2 {


    //阿里云第三方的方法
    boolean sendSms(String phone, String code);
}
