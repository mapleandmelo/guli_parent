package com.ljf.eduservice.entity.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:liujingfeng
 * @Date: 2022/2/8
 */
@Data
public class ChapterVo {
    private String id;
    private String title;

    //表示小节
    private List<VideoVo> children = new ArrayList<>();
}
