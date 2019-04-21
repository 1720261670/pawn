package com.service.impl;

import com.entity.DiscountCoupon;
import com.entity.PawnUserDiscount;
import com.mapper.DiscountCouponMapper;
import com.mapper.PawnUserDiscountMapper;
import com.service.DiscountCouponService;
import com.utils.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DiscountCouponServiceImpl implements DiscountCouponService {
    @Resource
    private DiscountCouponMapper discountCouponMapper;
    @Resource
    private PawnUserDiscountMapper pawnUserDiscountMapper;

    @Override
    public R discountList() {
        return R.ok().put("data",discountCouponMapper.selectByExample(null));
    }

    @Override
    public R findByUser(int userId) {
        List<DiscountCoupon> list = discountCouponMapper.findByUser(userId);
        return R.ok().put("data",list);
    }

    @Override
    public R delDiscountById(int id) {
        int i = pawnUserDiscountMapper.deleteByPrimaryKey(id);
        return i>0?R.ok("删除成功"):R.error("删除失败");
    }

    @Override
    public R addDiscountById(PawnUserDiscount pawnUserDiscount) {
        pawnUserDiscount.setCreateDate(new Date());
        int i = pawnUserDiscountMapper.insert(pawnUserDiscount);
        return i>0?R.ok("新增成功"):R.error("新增失败");
    }
}
