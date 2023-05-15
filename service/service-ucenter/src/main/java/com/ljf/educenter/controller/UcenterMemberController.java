package com.ljf.educenter.controller;


import com.ljf.commonutils.JwtUtils;
import com.ljf.commonutils.R;
import com.ljf.commonutils.ordervo.UcenterMemberOrder;
import com.ljf.educenter.entity.UcenterMember;
import com.ljf.educenter.entity.vo.RegisterVo;
import com.ljf.educenter.service.UcenterMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author liujingfeng
 * @since 2022-02-16
 */
@RestController
@RequestMapping("/educenter/member")
@CrossOrigin
public class UcenterMemberController {
    @Autowired
    private UcenterMemberService ucenterMemberService;

    //登录
    @PostMapping("login")
    public R loginUser(@RequestBody UcenterMember member) {
        //member对象封装手机号和密码
        //调用service实现登录
        //返回token 使用的是jwt生成的
        String token = ucenterMemberService.login(member);
        return R.ok().data("token", token);
    }

    //注册
    @PostMapping("register")
    public R registerUser(@RequestBody RegisterVo registerVo) {
        ucenterMemberService.register(registerVo);
        return R.ok();
    }

    //根据token获取用户信息
    @GetMapping("getMemberInfo")
    public R getMemberInfo(HttpServletRequest request) {
        //调用jwt工具类的方法。根据request对象获取头信息，返回用户id
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        //查询数据库根据用户id获取用户信息
        UcenterMember member = ucenterMemberService.getById(memberId);
        System.out.println("**************"+member.getMobile()+"****************");
        System.out.println("**************"+member.getMobile()+"****************");
        System.out.println("**************"+member.getMobile()+"****************");
        System.out.println("**************"+member.getMobile()+"****************");
        System.out.println("**************"+member.getMobile()+"****************");

        return R.ok().data("userInfo",member);
    }

    //根据用户id获取用户信息
    @PostMapping("getUserInfoOrder/{id}")
    public UcenterMemberOrder getUserInfoOrder(@PathVariable String id) {
        UcenterMember member = ucenterMemberService.getById(id);
        //把member对象里边的值 复制给 UcenterMemberOrder对象
        //因为UcenterMemberOrder对象才是两个服务共有的对象
        UcenterMemberOrder ucenterMemberOrder = new UcenterMemberOrder();
        BeanUtils.copyProperties(member, ucenterMemberOrder);

        return ucenterMemberOrder;

    }


    //查询某一天的注册人数（后台统计模块使用）
    @GetMapping("countRegister/{day}")
    public R countRegister(@PathVariable String day) {
        Integer count = ucenterMemberService.countRegisterDay(day);
        return R.ok().data("countRegister", count);
    }
}

