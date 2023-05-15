package com.ljf.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljf.eduservice.entity.EduSubject;
import com.ljf.eduservice.entity.excel.SubjectData;
import com.ljf.eduservice.entity.subject.OneSubject;
import com.ljf.eduservice.entity.subject.TwoSubject;
import com.ljf.eduservice.listener.SubjectExcelListener;
import com.ljf.eduservice.mapper.EduSubjectMapper;
import com.ljf.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-02-02
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void saveSubject(MultipartFile file, EduSubjectService subjectService) {
        try {
            //文件输入流
            InputStream in = file.getInputStream();
            //调用方法进行读取
            EasyExcel.read(in, SubjectData.class, new SubjectExcelListener(subjectService)).sheet().doRead();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //课程分类列表（树形）
    @Override
    public List<OneSubject> getAllOneTwoSubject() {
        //1 查询所有一级分类 parentid=0
        QueryWrapper<EduSubject> wrapperOne = new QueryWrapper<>();
        wrapperOne.eq("parent_id", "0");
        List<EduSubject> oneSubjectList = baseMapper.selectList(wrapperOne);
        //2 查询所有二级分类 parentid != 0
        QueryWrapper<EduSubject> wrapperTwo = new QueryWrapper<>();
        wrapperTwo.ne("parent_id", "0");
        List<EduSubject> twoSubjectList = baseMapper.selectList(wrapperTwo);

        //3 封装一级分类
        //查询出来所有的一级分类list集合遍历，得到每个一级分类对象，获取每个一级分类对象值
        //封装到要求的list集合里面List<OneSubject> finalSubjectList
        List<OneSubject> finalSubjectList = new ArrayList<>();
        for (int i = 0; i < oneSubjectList.size(); i++) { //遍历oneSubjectList集合
            //得到oneSubjectList每个eduSubject对象
            EduSubject eduSubject = oneSubjectList.get(i);

            //把eduSubject里边的值获取出来，放到OneSubject对象中

            OneSubject oneSubject = new OneSubject();

            BeanUtils.copyProperties(eduSubject, oneSubject);

            //这里组成也可以，因为oneSubject动态变化。。
            //finalSubjectList.add(oneSubject);

            //4 封装二级分类

            //在一级分类循环遍历查询所有二级分类
            //创建list集合封装每个一级分类的二级分类
            List<TwoSubject> twoFinalSubjectList = new ArrayList<>();
            //遍历二级分类list集合
            for (int j = 0; j < twoSubjectList.size(); j++) {
                //获取每个二级分类
                EduSubject eduSubjectOfTwo = twoSubjectList.get(j);
                //判断二级分类的parentid是否和当前一级分类id一致
                if(eduSubjectOfTwo.getParentId().equals(eduSubject.getId())) {
                    //赋值并放入
                    TwoSubject twoSubject = new TwoSubject();
                    BeanUtils.copyProperties(eduSubjectOfTwo, twoSubject);
                    twoFinalSubjectList.add(twoSubject);
                }
            }

            //把一级分类下所有二级分类放入一级分类
            oneSubject.setChildren(twoFinalSubjectList);

            //一个完整的一级分类数据组成成功！
            finalSubjectList.add(oneSubject);
        }



        return finalSubjectList;
    }
}
