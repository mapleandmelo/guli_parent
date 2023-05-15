package com.ljf.eduorder.controller;


import com.ljf.commonutils.R;
import com.ljf.eduorder.service.PayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 支付日志表 前端控制器
 * </p>
 *
 * @author ljf
 * @since 2022-02-23
 */
@RestController
@RequestMapping("/eduorder/paylog")
@CrossOrigin
public class PayLogController {

    @Autowired
    private PayLogService payLogService;

    //生成微信支付二维码的接口
    //参数是订单号
    @GetMapping("createNative/{orderNo}")
    public R createNative(@PathVariable String orderNo) {
        //返回相关的信息，包含二维码的地址和其他信息
        //为了后面取值方便，我们建议是返回map
        Map map = payLogService.createNatvie(orderNo);
        System.out.println("****返回二维码map集合:"+map);

        //map包含二维码信息和其他需要的信息，根据订单号生成的
        return R.ok().data(map);
    }

    //参数：订单号，根据订单号查询支付状态
    //查询支付状态调用的也是官方的提供的地址哈
    @GetMapping("queryPayStatus/{orderNo}")
    public R queryPayStatus(@PathVariable String orderNo) {
        Map<String, String> map = payLogService.queryPayStatus(orderNo);
        //查询订单状态的map集合
        System.out.println("*************************查询订单状态的map集合" + map);


        if(map == null) {
            return R.error().message("支付出错了");
        }

        //如果返回map里面不为空，通过map获取订单状态
        if(map.get("trade_state").equals("SUCCESS")) { //支付成功
            //添加记录到支付表，更新订单表的订单状态
            payLogService.updateOrdersStatus(map);
            return R.ok().message("支付成功！");

        }

        return R.ok().code(25000).message("支付中");
    }



}

