package com.ljf.vod.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VodService {
    //上传视频到阿里云
    String uploadVideoAly(MultipartFile file);

    //删除课程同时删除多个视频
    void removeMoreAlyVideo(List<String> videoIdList);
}
