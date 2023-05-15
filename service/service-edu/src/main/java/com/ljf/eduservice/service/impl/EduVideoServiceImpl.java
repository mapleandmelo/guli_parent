package com.ljf.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljf.eduservice.client.VodClient;
import com.ljf.eduservice.entity.EduVideo;
import com.ljf.eduservice.mapper.EduVideoMapper;
import com.ljf.eduservice.service.EduVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author liujingfeng
 * @since 2022-02-07
 */
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

    //注入vodClient
    @Autowired
    private VodClient vodClient;
    //根据课程id删除小节
    //todo 删除对应的视频文件
    @Override
    public void removeVideoByCourseId(String courseId) {
        //1 据课程id，查询课程的所有视频的id
        QueryWrapper<EduVideo> wrapperVideo = new QueryWrapper<>();
        wrapperVideo.eq("course_id", courseId);
        wrapperVideo.select("video_source_id");
        List<EduVideo> eduVideoList = baseMapper.selectList(wrapperVideo);
        // List<EduVideo>变成List<String>
        ArrayList<String> videoIds = new ArrayList<>();
        for (int i = 0; i < eduVideoList.size(); i++) {
            EduVideo eduVideo = eduVideoList.get(i);
            String videoSourceId = eduVideo.getVideoSourceId();
            //放到videoIds集合里边
            videoIds.add(videoSourceId);
        }
        //2 根据多个视频id删除多个视频（即完成删除课程同时删除课程下多个小节的视频）
        if(videoIds.size() > 10) {
            vodClient.deleteBatch(videoIds);
        }


        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);
        baseMapper.delete(wrapper);
    }

    //
}
