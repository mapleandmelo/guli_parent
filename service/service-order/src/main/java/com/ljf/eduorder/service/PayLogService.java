package com.ljf.eduorder.service;

import com.ljf.eduorder.entity.PayLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 支付日志表 服务类
 * </p>
 *
 * @author ljf
 * @since 2022-02-23
 */
public interface PayLogService extends IService<PayLog> {

    //生成微信支付二维码
    Map createNatvie(String orderNo);

    Map<String, String> queryPayStatus(String orderNo);

    void updateOrdersStatus(Map<String, String> map);
}
