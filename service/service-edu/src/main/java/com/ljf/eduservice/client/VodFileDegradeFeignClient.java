package com.ljf.eduservice.client;

import com.ljf.commonutils.R;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther:liujingfeng
 * @Date: 2022/2/15
 */
@Component
public class VodFileDegradeFeignClient implements VodClient{
    @Override
    public R removeAlyvideo(String id) {
        return R.error().message("删除视频出错了");
    }

    @Override
    public R deleteBatch(List<String> videoIdList) {
        return R.error().message("删除多个视频出错了");
    }
}
