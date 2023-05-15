package com.ljf.jibinservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.ljf.jibinservice.service.StreamModelService;
import com.ljf.jibinservice.service.request.model.TrainModelRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther:liujingfeng
 * @Date: 2022/3/12
 */

@RestController
@RequestMapping("/api/v1/model/")
@Log4j2
@Api(tags = "model")
public class ModelController {
    @Resource
    StreamModelService streamModelService;

    @ApiOperation("训练模型")
    @PostMapping("/train")
    public int trainModel(@RequestBody @Validated TrainModelRequest trainModelRequest) {
        log.info("训练模型,value:" + JSONObject.toJSONString(trainModelRequest));
        return streamModelService.trainModel(trainModelRequest);
    }

}
