package com.ljf.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther:liujingfeng
 * @Date: 2022/2/1
 */
public interface OssService {
    //上传头像到oss
    String uploadFileAvatar(MultipartFile file);
}
