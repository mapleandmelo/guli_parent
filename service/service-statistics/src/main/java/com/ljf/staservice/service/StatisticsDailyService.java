package com.ljf.staservice.service;

import com.ljf.staservice.entity.StatisticsDaily;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 服务类
 * </p>
 *
 * @author 刘净枫
 * @since 2022-02-24
 */
public interface StatisticsDailyService extends IService<StatisticsDaily> {

    //统计某一天注册人数，生成统计数据
    void registerCount(String day);

    //图表显示 返回两部分数据 日期json数组和数量json数组
    Map<String, Object> getShowData(String type, String begin, String end);
}
