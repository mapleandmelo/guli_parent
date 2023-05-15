package com.ljf.jibinservice.service;

import com.ljf.jibinservice.entity.TestGuanxinbin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liujingfeng
 * @since 2022-03-11
 */
public interface TestGuanxinbinService extends IService<TestGuanxinbin> {

    Map<String, Object> getShowData();
}
