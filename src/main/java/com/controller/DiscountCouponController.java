package com.controller;

import com.entity.PawnUserDiscount;
import com.service.DiscountCouponService;
import com.utils.R;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DiscountCouponController {
    @Resource
    private DiscountCouponService discountCouponService;

    //展示所有优惠券(查询)
    @RequestMapping("/pawn/discount/list")
    public R discountList(){
       return discountCouponService.discountList();
    }
    //用户已有的优惠券
    @RequestMapping("/pawn/discount/user/{userId}")
    public R discountByUser(@PathVariable int userId){
        return discountCouponService.findByUser(userId);
    }
    //用户删除优惠券
    @RequestMapping("/pawn/discount/user/{id}")
    public R delDiscountById(@PathVariable int id){
        return discountCouponService.delDiscountById(id);
    }
    //用户领取优惠券(新增)
    @RequestMapping("/pawn/discount/add")
    public R addDiscountById(@RequestBody PawnUserDiscount pawnUserDiscount){
        return discountCouponService.addDiscountById(pawnUserDiscount);
    }
    //定时任务优惠券到期时间

}
