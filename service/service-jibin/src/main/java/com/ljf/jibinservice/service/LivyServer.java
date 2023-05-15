package com.ljf.jibinservice.service;

import com.ljf.jibinservice.service.request.livy.BatchRequest;
import com.ljf.jibinservice.service.response.livy.BatchResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther:liujingfeng
 * @Date: 2022/3/12
 */
@FeignClient(url = "${livy.url}", name = "livy")
public interface LivyServer {
    @RequestMapping(
            name = "提交至livy",
            value = "/batches",
            method = RequestMethod.POST,
            headers = {
                    "X-Requested-By=admin",
                    "Content-Type=application/json"
            }
    )
    BatchResponse submit(BatchRequest request);
}
