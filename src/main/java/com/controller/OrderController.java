package com.controller;

import com.entity.OrderProducts;
import com.service.OrderService;
import com.utils.R;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;
    //展示用户个人订单
    @RequestMapping("/pawn/personalOrder/list")
    public R selectOrder(){
        return orderService.findOrderByUserId();
    }
    //删除订单，批量删除订单信息
    @RequestMapping("/pawn/personalOrder/del")
    public R delOrderByUserId(@RequestBody List<Integer> orderId){
        return orderService.delOrderByUserId(orderId);
    }
    //点击结算按钮
    //添加多个商品到关联表，创建订单
    @RequestMapping("/pawn/personalOrder/save")
    public R saveOrder(@RequestBody List<OrderProducts> orderProducts, Integer addressId, Integer status){
        return orderService.saveOrder(orderProducts,addressId,status);
    }
    //未完成数量
    @RequestMapping("/pawn/personalOrder/unfinished")
    public R orderUnfinished(){
        return orderService.findOrderUnfinished();
    }
    //已完成数量
    @RequestMapping("/pawn/personalOrder/accomplish")
    public R orderAccomplish(){
        return orderService.findOrderAccomplish();
    }
    //未完成的订单
    @RequestMapping("/pawn/personalOrder/unfinishedList")
    public R orderUnfinishedList(){
        return orderService.findOrderUnfinishedList();
    }
    //已完成的订单
    @RequestMapping("/pawn/personalOrder/accomplishList")
    public R orderAccomplishList(){
        return orderService.findOrderAccomplishList();
    }
}
