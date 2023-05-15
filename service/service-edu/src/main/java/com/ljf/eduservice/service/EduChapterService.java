package com.ljf.eduservice.service;

import com.ljf.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljf.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author liujingfeng
 * @since 2022-02-07
 */
public interface EduChapterService extends IService<EduChapter> {

    //课程大纲列表，根据课程id'进行查询
    List<ChapterVo> getChapterVideoByCourseId(String courseId);

    //删除章节的方法
    boolean deleteChapter(String chapterId);

    void removeChapterByCourseId(String courseId);
}
