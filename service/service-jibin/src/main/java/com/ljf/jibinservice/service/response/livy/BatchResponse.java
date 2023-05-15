package com.ljf.jibinservice.service.response.livy;

import com.ljf.jibinservice.common.livy.SessionState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Auther:liujingfeng
 * @Date: 2022/3/12
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchResponse {
    private Integer id;
    private String appId;
    private AppInfo appInfo;
    private List<String> log;
    private SessionState state;
}
