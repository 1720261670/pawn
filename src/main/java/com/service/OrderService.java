package com.service;

import com.entity.OrderProducts;
import com.utils.R;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderService {

    public R findOrderByUserId();
    public R delOrderByUserId(List<Integer> orderId);
    public R saveOrder(List<OrderProducts> orderProducts, Integer addressId, Integer status);
    public R findOrderUnfinished();
    public R findOrderAccomplish();
    public R findOrderUnfinishedList();
    public R findOrderAccomplishList();
}
