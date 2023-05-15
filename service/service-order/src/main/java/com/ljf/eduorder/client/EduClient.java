package com.ljf.eduorder.client;

import com.ljf.commonutils.ordervo.CourseWebVoOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Auther:liujingfeng
 * @Date: 2022/2/23
 */

@Component
@FeignClient("service-edu")
public interface EduClient {

    //根据课程id查询课程（用于订单页面生成）
    @PostMapping("/eduservice/coursefront/getCourseInfoOrder/{id}")
    public CourseWebVoOrder getCourseInfoOrder(@PathVariable("id") String id);
}
