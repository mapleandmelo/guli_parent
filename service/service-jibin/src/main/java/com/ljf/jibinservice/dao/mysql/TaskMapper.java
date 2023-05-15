package com.ljf.jibinservice.dao.mysql;

import com.ljf.jibinservice.entity.StreamTaskInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Auther:liujingfeng
 * @Date: 2022/3/12
 */

@Repository
public interface TaskMapper extends Mapper<StreamTaskInfo> {
}
