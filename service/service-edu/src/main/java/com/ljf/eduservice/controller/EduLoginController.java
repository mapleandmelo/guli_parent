package com.ljf.eduservice.controller;

import com.ljf.commonutils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther:liujingfeng
 * @Date: 2022/1/30
 */

@RestController
@RequestMapping(path="/eduservice/user", method={RequestMethod.GET, RequestMethod.POST})
@CrossOrigin
public class EduLoginController {
    //login
    @PostMapping(path="login")
    public R login() {
        return R.ok().data("token","admin");
    }

    //info
    @GetMapping(path="info")
    public R info() {
        return R.ok().data("roles","[admin]").data("name", "admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
