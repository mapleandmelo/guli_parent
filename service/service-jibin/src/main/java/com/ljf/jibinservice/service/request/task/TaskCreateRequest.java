package com.ljf.jibinservice.service.request.task;


import com.ljf.jibinservice.common.task.TaskType;
import com.ljf.jibinservice.service.request.livy.BatchRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskCreateRequest {
    TaskType taskType;
    Integer bizId;
    BatchRequest batchRequest=new BatchRequest();
}
