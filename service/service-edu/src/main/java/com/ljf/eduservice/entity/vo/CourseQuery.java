package com.ljf.eduservice.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther:liujingfeng
 * @Date: 2022/2/10
 */
@ApiModel(value = "Course查询对象", description = "Course查询对象封装")
@Data
public class CourseQuery implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "Course名称,模糊查询")
    private String title;
    @ApiModelProperty(value = "课程状态 未发布和已发布")
    private String status;

}
