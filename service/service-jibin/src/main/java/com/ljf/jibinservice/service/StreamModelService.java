package com.ljf.jibinservice.service;

import com.ljf.jibinservice.service.request.model.TrainModelRequest;

/**
 * @Auther:liujingfeng
 * @Date: 2022/3/12
 */
public interface StreamModelService {
    int trainModel(TrainModelRequest trainModelRequest);
}
