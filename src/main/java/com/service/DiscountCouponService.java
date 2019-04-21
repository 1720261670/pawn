package com.service;

import com.entity.PawnUserDiscount;
import com.utils.R;

public interface DiscountCouponService {
    public R discountList();
    public R findByUser(int userId);
    public R delDiscountById(int id);
    public R addDiscountById(PawnUserDiscount pawnUserDiscount);
}
