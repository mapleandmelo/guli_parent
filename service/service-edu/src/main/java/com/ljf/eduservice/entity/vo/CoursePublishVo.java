package com.ljf.eduservice.entity.vo;

import lombok.Data;

/**
 * @Auther:liujingfeng
 * @Date: 2022/2/9
 */
@Data
public class CoursePublishVo {
    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;//只用于显示
}
