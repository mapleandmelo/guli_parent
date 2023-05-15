package com.ljf.educenter.controller;

import com.google.gson.Gson;
import com.ljf.commonutils.JwtUtils;
import com.ljf.educenter.entity.UcenterMember;
import com.ljf.educenter.service.UcenterMemberService;
import com.ljf.educenter.utils.ConstantWxUtils;
import com.ljf.educenter.utils.HttpClientUtils;
import com.ljf.servicebase.handler.liujingfengException;
import javafx.collections.MapChangeListener;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * @Auther:liujingfeng
 * @Date: 2022/2/19
 */

@CrossOrigin
@Controller //不返回数据R，返回的是地址，不加@REQUESTBody
@RequestMapping("/api/ucenter/wx")
public class WxApiController {


    @Autowired
    private UcenterMemberService memberService;

    //2 获取扫描人的信息 不需要返回数据
    @GetMapping("callback")
    public String callback(String code, String state){
        //得到授权临时票据code
        System.out.println("code" + code);
        System.out.println("state" + state);
        //1 向认证服务器发送请求换取access_token
        String baseAccessTokenUrl =
                "https://api.weixin.qq.com/sns/oauth2/access_token" +
                        "?appid=%s" +
                        "&secret=%s" +
                        "&code=%s" +
                        "&grant_type=authorization_code";
        String accessTokenUrl = String.format(baseAccessTokenUrl,
                ConstantWxUtils.WX_OPEN_APP_ID,
                ConstantWxUtils.WX_OPEN_APP_SECRET,
                code);

        //2 请求这个拼接好的地址，得到返回的两个值 access_token 和 openid
        //使用httpclient发送请求 得到返回的结果
        try {
            String accessTokenInfo = HttpClientUtils.get(accessTokenUrl);
            //从accessTokenInfo字符串返回两个值 access_token 和 openid
            //把JSON字符串转换成map 使用Gson工具
            Gson gson = new Gson();
            HashMap mapAccessToken = gson.fromJson(accessTokenInfo, HashMap.class);
            String access_token = (String) mapAccessToken.get("access_token");
            String openid = (String) mapAccessToken.get("openid");

            //把扫描人的信息添加到数据库中
            //使用openid判断数据表里边是否存在相同的微信信息
            UcenterMember member = memberService.getOpenIdMember(openid);
            if(member == null) { //如果member为空，表示表没有相同的微信数据，此时进行添加
            //3 拿着得到的两个值 access_token 和 openid，再去请求微信提供的固定地址，获取扫描人的信息
            //访问微信的资源服务器，获取用户信息
            String baseUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo" +
                    "?access_token=%s" +
                    "&openid=%s";
            String userInfoUrl = String.format(baseUserInfoUrl, access_token, openid);
            //获取请求
            String userInfo = HttpClientUtils.get(userInfoUrl);
            //返回获取userinfo字符串的扫描人信息
            HashMap userInfoMap = gson.fromJson(userInfo, HashMap.class);
            String nickname = (String) userInfoMap.get("nickname");
            String headimgurl = (String) userInfoMap.get("headimgurl");



                 member = new UcenterMember();
                 member.setOpenid(openid);
                 member.setNickname(nickname);
                 member.setAvatar(headimgurl);
                 memberService.save(member);
            }
            //使用jwt根据member对象生辰个token字符串
            String jwtToken = JwtUtils.getJwtToken(member.getId(), member.getNickname());

            //最后返回首页，通过路径传递token字符串
            return "redirect:http://localhost:3000?token=" + jwtToken;


        } catch (Exception e) {
            throw new liujingfengException(20001, "获取access_token失败");
        }



    }

    //1 生成微信二维码
    @GetMapping("login")
    public String getWxCode(){
        //请求微信地址
        // 微信开放平台授权baseUrl
        String baseUrl = "https://open.weixin.qq.com/connect/qrconnect" +
                "?appid=%s" +
                "&redirect_uri=%s" +
                "&response_type=code" +
                "&scope=snsapi_login" +
                "&state=%s" +
                "#wechat_redirect";
        //对redirect_url进行URLEncoder编码
        String redirectUrl = ConstantWxUtils.WX_OPEN_REDIRECT_URL;
        try {
            redirectUrl = URLEncoder.encode(redirectUrl, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //设置%s里面的值
        String url = String.format(
                baseUrl,
                ConstantWxUtils.WX_OPEN_APP_ID,
                redirectUrl,
                "atguigu"
        );

        //重定向到请求微信地址里面


        return "redirect:" + url;
    }






}
