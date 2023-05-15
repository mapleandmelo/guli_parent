package com.ljf.jibinservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljf.commonutils.R;
import com.ljf.jibinservice.entity.TestGuanxinbin;
import com.ljf.jibinservice.mapper.TestGuanxinbinMapper;
import com.ljf.jibinservice.service.TestGuanxinbinService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liujingfeng
 * @since 2022-03-11
 */
@Service
public class TestGuanxinbinServiceImpl extends ServiceImpl<TestGuanxinbinMapper, TestGuanxinbin> implements TestGuanxinbinService {

    @Override
    public Map<String, Object> getShowData() {
        QueryWrapper<TestGuanxinbin> wrapper = new QueryWrapper<>();
        //HashMap<String, Integer> ageToNumber = new HashMap<>();
        ArrayList<Integer> countAgeList = new ArrayList<>();
        ArrayList<String> indexAgeList = new ArrayList<>();
        for (int i = 0; i < 120; i++) {
            String strPerage = String.valueOf(i);
            //wrapper.eq("age",strPerage);
            int countPerAge = baseMapper.countNumOfEveryAge(strPerage);

            countAgeList.add(countPerAge);
            indexAgeList.add(strPerage);
            //ageToNumber.put(strPerage, countPerAge);
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("indexAgeList",indexAgeList);
        map.put("countAgeList",countAgeList);
        return map;
    }
}
