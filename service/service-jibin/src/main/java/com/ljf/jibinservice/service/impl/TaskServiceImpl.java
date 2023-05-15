package com.ljf.jibinservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ljf.jibinservice.dao.mysql.TaskMapper;
import com.ljf.jibinservice.entity.StreamTaskInfo;
import com.ljf.jibinservice.service.LivyServer;
import com.ljf.jibinservice.service.TaskService;
import com.ljf.jibinservice.service.request.task.TaskCreateRequest;
import com.ljf.jibinservice.service.response.livy.BatchResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Auther:liujingfeng
 * @Date: 2022/3/12
 */

@Service
@Log4j2
public class TaskServiceImpl implements TaskService {

    @Resource
    LivyServer livyServer;

    @Value("${spark.task.jar.url}")
    private String jarUrl;


    @Resource
    TaskMapper taskMapper;


    @Override
    @Transactional(rollbackFor = Throwable.class)
    public int create(TaskCreateRequest taskCreateRequest) {
        taskCreateRequest.getBatchRequest().setFile(jarUrl);

        log.info("创建Livy任务:" + JSONObject.toJSONString(taskCreateRequest));
        BatchResponse batchResponse = livyServer.submit(taskCreateRequest.getBatchRequest());
        StreamTaskInfo taskInfo = new StreamTaskInfo();
        taskInfo.setTaskId(batchResponse.getId());
        taskInfo.setTaskState(batchResponse.getState());
        taskInfo.setTaskStartTime(new Date());
        taskInfo.setTaskType(taskCreateRequest.getTaskType());
        taskInfo.setBizId(taskCreateRequest.getBizId());
        log.info("创建任务:" + JSONObject.toJSONString(taskInfo));
        return taskMapper.insertSelective(taskInfo);
    }
}
