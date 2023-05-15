package com.ljf.jibinservice.service.request.livy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther:liujingfeng
 * @Date: 2022/3/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchRequest {
    private String file;//File containing the application to execute
    private String className; // Application Java/Spark main class
    private List<Object> args;
    private List<String> jars;
    private Integer numExecutors;
    private Integer executorCores;
    private String executorMemory;
    private Integer driverCores;
    private Integer driverMemory;
    private Map<String,Object> conf=new HashMap<>();
    //....etc. all of the property show in the docs
}