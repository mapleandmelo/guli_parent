package com.ljf.jibinservice.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljf.jibinservice.entity.TestGuanxinbin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liujingfeng
 * @since 2022-03-11
 */

@Mapper
public interface TestGuanxinbinMapper extends BaseMapper<TestGuanxinbin> {

    Integer countNumOfEveryAge(String strPerAge);
}
