package com.ljf.jibinservice.service.impl;

import com.ljf.jibinservice.common.model.ModelState;
import com.ljf.jibinservice.common.task.TaskType;
import com.ljf.jibinservice.dao.mysql.StreamModelMapper;
import com.ljf.jibinservice.entity.StreamModel;
import com.ljf.jibinservice.service.StreamModelService;
import com.ljf.jibinservice.service.TaskService;
import com.ljf.jibinservice.service.request.livy.BatchRequest;
import com.ljf.jibinservice.service.request.model.TrainModelRequest;

import com.ljf.jibinservice.service.request.task.TaskCreateRequest;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Auther:liujingfeng
 * @Date: 2022/3/12
 */
public class StreamModelServiceImpl implements StreamModelService {

    @Resource
    TaskService taskService;
    @Resource
    StreamModelMapper streamModelMapper;

    @Value("${spark.task.modelTrain.className}")
    private String modelTrainClassName;
    @Value("${spark.task.modelTrain.dependencyJar}")
    private String modelTrainDependencyJar;
    @Value("${spark.task.modelTrain.tFile.url}")
    private String modelTrainTFile;
    @Value("${spark.task.modelTrain.fFile.url}")
    private String modelTrainFFile;
    @Value("${spark.task.modelTrain.modelSavePath}")
    private String modelSavePath;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public int trainModel(TrainModelRequest trainModelRequest) {
        //前端的请求，来获取某个特定的模型
        String realSavePath = modelSavePath + "/" + trainModelRequest.getModelType() + "/" + UUID.randomUUID();

        //构造spark job参数
        BatchRequest batchRequest = new BatchRequest();
        List<Object> args = new ArrayList<>();
        batchRequest.setClassName(modelTrainClassName);
        batchRequest.setJars(Arrays.asList(modelTrainDependencyJar.split(",")));
        /*
            val tFilePath = args.apply(0)
            val fFilePath = args.apply(1)
            val modelType = args.apply(2)
            val modelFilePath = args.apply(3)
         */
        args.add(modelTrainTFile);
        args.add(modelTrainFFile);
        args.add(trainModelRequest.getModelType());
        args.add(realSavePath);
        batchRequest.setArgs(args);

        //保存模型，主要就是设置一下哪个模型正在训练，这个在数据库体现
        StreamModel streamModel = new StreamModel();
        streamModel.setModelName(trainModelRequest.getModelName());
        streamModel.setModelType(trainModelRequest.getModelType());
        streamModel.setCreateTime(new Date());
        streamModel.setModelUrl(realSavePath);
        //streamModel.setAdminId(adminUserService.queryByToken(SecurityUtils.getSubject().getPrincipal().toString()).getAdminId());
        streamModel.setState(ModelState.training);
        //直接把模型插入数据库了
        int modelId = streamModelMapper.insert(streamModel);

        //创建任务
        TaskCreateRequest request = new TaskCreateRequest();
        request.setBatchRequest(batchRequest);
        request.setTaskType(TaskType.model_train);
        request.setBizId(streamModel.getStreamModelId());
        taskService.create(request);

        return modelId;

    }
}
