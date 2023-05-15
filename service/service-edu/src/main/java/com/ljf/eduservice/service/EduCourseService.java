package com.ljf.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ljf.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljf.eduservice.entity.vo.CourseInfoVo;
import com.ljf.eduservice.entity.vo.CoursePublishVo;
import com.ljf.eduservice.entity.vo.frontvo.CourseFrontVo;
import com.ljf.eduservice.entity.vo.frontvo.CourseWebVo;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author liujingfeng
 * @since 2022-02-07
 */
public interface EduCourseService extends IService<EduCourse> {

    String saveCourseInfo(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseInfo(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);

    CoursePublishVo publishCourseInfo(String id);

    void removeCourse(String courseId);

    Map<String, Object> getCourseFrontList(Page<EduCourse> pageCourse, CourseFrontVo courseFrontVo);

    CourseWebVo getBaseCourseInfo(String courseId);
}
