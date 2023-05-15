package com.ljf.educenter.service;

import com.ljf.educenter.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljf.educenter.entity.vo.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author liujingfeng
 * @since 2022-02-16
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    String login(UcenterMember member);

    void register(RegisterVo registerVo);

    //根据openid判断是否存在member
    UcenterMember getOpenIdMember(String openid);

    //查询某一天的注册人数（后台统计模块使用）
    Integer countRegisterDay(String day);
}
