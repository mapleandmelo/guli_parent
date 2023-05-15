package com.ljf.jibinservice.service;

import com.ljf.jibinservice.service.request.task.TaskCreateRequest;

/**
 * @Auther:liujingfeng
 * @Date: 2022/3/12
 */
public interface TaskService {
    int create(TaskCreateRequest taskCreateRequest);
}
