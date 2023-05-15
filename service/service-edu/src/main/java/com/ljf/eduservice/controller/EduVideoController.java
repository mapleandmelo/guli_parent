package com.ljf.eduservice.controller;


import com.ljf.commonutils.R;
import com.ljf.eduservice.client.VodClient;
import com.ljf.eduservice.entity.EduVideo;
import com.ljf.eduservice.service.EduVideoService;
import com.ljf.servicebase.handler.liujingfengException;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author liujingfeng
 * @since 2022-02-07
 */
@RestController
@RequestMapping("/eduservice/video")
@CrossOrigin
public class EduVideoController {

    @Autowired
    private EduVideoService videoService;

    @Autowired
    private VodClient vodClient;

    //添加小节
    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo) {
        videoService.save(eduVideo);

        return R.ok();
    }

    //删除小节
    //todo 后面完善 删除小节同时删除视频
    @DeleteMapping("{id}")
    public R deleteVideo(@PathVariable String id){
        //根据小节id获取视频id，调用方法实现视频删除
        EduVideo eduVideo = videoService.getById(id);
        String videoSourceId = eduVideo.getVideoSourceId();
        // 判断小节里面是否有视频id
        if(!StringUtils.isEmpty(videoSourceId)) {
            //根据视频id，远程调用实现视频删除
            R result = vodClient.removeAlyvideo(videoSourceId);
            if(result.getCode() == 20001) {
                throw new liujingfengException(20001,"删除视频失败,熔断器将执行");
            }
        }
        //删除小节
        videoService.removeById(id);

        return R.ok();
    }





}

