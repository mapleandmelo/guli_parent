package com.ljf.jibinservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljf.commonutils.R;
import com.ljf.jibinservice.entity.TestGuanxinbin;
import com.ljf.jibinservice.service.TestGuanxinbinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liujingfeng
 * @since 2022-03-11
 *     //设计需求 查询用户的性别、年龄、教育等级
 */
@RestController
@RequestMapping("/jibinservice/jibguanxinbin")
@CrossOrigin
public class TestGuanxinbinController {

    @Autowired(required = false)
    private TestGuanxinbinService testGuanxinbinService;

//    //用一个饼图展示男女比例
//    @GetMapping("getGenderRate")
//    public R getGenderRate(){
//        QueryWrapper<TestGuanxinbin> wrapper = new QueryWrapper<>();
//        wrapper.eq("male","1");
//        int malePatientNum = testGuanxinbinService.count(wrapper);
//
//        int totalPatientNum = testGuanxinbinService.count(null);
//
//        float malePatientRatio = malePatientNum / totalPatientNum;
//        float femalePatientRatio = (1 - malePatientRatio);
//
//        return R.ok().data("malePatientRatio", malePatientRatio).data("femalePatientRatio", femalePatientRatio);
//    }

    //用一个柱状图展示年龄分布
    @GetMapping("getAgeDistribution")
    public R getAgeDistribution(){



        Map<String, Object> map = testGuanxinbinService.getShowData();
        return R.ok().data(map);
    }



}

