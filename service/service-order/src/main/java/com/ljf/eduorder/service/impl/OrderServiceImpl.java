package com.ljf.eduorder.service.impl;

import com.ljf.commonutils.ordervo.CourseWebVoOrder;
import com.ljf.commonutils.ordervo.UcenterMemberOrder;
import com.ljf.eduorder.client.EduClient;
import com.ljf.eduorder.client.UcenterClient;
import com.ljf.eduorder.entity.Order;
import com.ljf.eduorder.mapper.OrderMapper;
import com.ljf.eduorder.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljf.eduorder.utils.OrderNoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author ljf
 * @since 2022-02-23
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private EduClient eduClient;

    @Autowired
    private UcenterClient ucenterClient;

    // 1 生成订单的方法
    @Override
    public String createOrders(String courseId, String memberId) {
        //通过远程调用 根据用户id获取用户信息
        UcenterMemberOrder userInfoOrder = ucenterClient.getUserInfoOrder(memberId);

        //通过远程调用 根据课程id获取课程信息
        CourseWebVoOrder courseInfoOrder = eduClient.getCourseInfoOrder(courseId);

        System.out.println("***********8");
        System.out.println(courseInfoOrder.getTeacherName());
        System.out.println("***********8");

        //创建Order对象，向order对象里面设置需要数据
        Order order = new Order();
        order.setOrderNo(OrderNoUtil.getOrderNo());//订单号
        order.setCourseId(courseId); //课程id
        order.setCourseTitle(courseInfoOrder.getTitle());
        order.setCourseCover(courseInfoOrder.getCover());
        order.setTeacherName(courseInfoOrder.getTeacherName());
        order.setTotalFee(courseInfoOrder.getPrice());
        order.setMemberId(memberId);
        order.setMobile(userInfoOrder.getMobile());
        order.setNickname(userInfoOrder.getNickname());
        order.setStatus(0);  //订单状态（0：未支付 1：已支付）
        order.setPayType(1);  //支付类型 ，微信1

        System.out.println("***********现在看看订单生成以后的情况：");
        System.out.println(order.getTeacherName());
        System.out.println(order.getOrderNo());
        System.out.println("***********订单生成以后！！！！！");


        baseMapper.insert(order);

        System.out.println("***********现在看看订单生成以后的情况：");
        System.out.println(order.getTeacherName());
        System.out.println(order.getOrderNo());
        System.out.println("***********订单生成以后！！！！！");
        //返回订单号
        return order.getOrderNo();
    }
}
