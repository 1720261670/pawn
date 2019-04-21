package com.service.impl;

import com.entity.OrderProducts;
import com.entity.PawnOrder;
import com.entity.PawnOrderExample;
import com.mapper.OrderProductsMapper;
import com.mapper.PawnOrderMapper;
import com.service.OrderService;
import com.utils.R;
import com.utils.ShiroUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service(value = "orderServiceImpl")
public class OrderServiceImpl implements OrderService {

    @Resource
    private PawnOrderMapper pawnOrderMapper;
    @Resource
    private OrderProductsMapper orderProductsMapper;

    @Override
    public R findOrderByUserId() {
        List<Map<String,Object>> orderList = pawnOrderMapper.findOrderByUserId(ShiroUtils.getUserId());
        return R.ok().put("orderList",orderList);
    }

    @Override
    public R delOrderByUserId(List<Integer> orderId) {
        PawnOrderExample example = new PawnOrderExample();
        PawnOrderExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdIn(orderId);
        int i = pawnOrderMapper.deleteByExample(example);
        if (i>0){
            return R.ok();
        }
        return R.error("删除失败");
    }

    @Override
    public R saveOrder(List<OrderProducts> orderProducts, Integer addressId, Integer status) {
        PawnOrder pawnOrder = new PawnOrder();
        pawnOrder.setAddressId(addressId);
        pawnOrder.setStatus(status);
        pawnOrder.setOrderTime(new Date());

        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");

        String newDate=sdf.format(new Date());

        String orderRef="#OF"+newDate;
        pawnOrder.setOrderRef(orderRef);
        pawnOrder.setUserId(ShiroUtils.getUserId());
        int i = pawnOrderMapper.insert(pawnOrder);
        int orderId=pawnOrder.getOrderId();

        for (OrderProducts orderProduct : orderProducts) {
            orderProduct.setOrderId(orderId);
            orderProductsMapper.insert(orderProduct);
        }

        return i>0?R.ok():R.error();
    }

    @Override
    public R findOrderUnfinished() {
        return R.ok().put("unfinished",pawnOrderMapper.selectOrderUnfinished());
    }

    @Override
    public R findOrderAccomplish() {
        return R.ok().put("accomplish",pawnOrderMapper.selectOrderAccomplish());
    }

    @Override
    public R findOrderUnfinishedList() {
        List<PawnOrder> pawnOrder = pawnOrderMapper.findOrderUnfinishedList();
        return R.ok().put("unfinishedList",pawnOrder);
    }

    @Override
    public R findOrderAccomplishList() {
        List<PawnOrder> pawnOrder = pawnOrderMapper.findOrderAccomplishList();
        return R.ok().put("accomplishList",pawnOrder);
    }
}
