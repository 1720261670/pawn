package com.service;

import com.entity.PawnCart;
import com.utils.R;

import java.util.List;

public interface CartService {

    public R findProByUserId();
    public R delProByUserId(List<Integer> id);
    public R saveProByCart(PawnCart pawnCart);
    public R updateCartByNumber(int number,int id);
    public R findProByProId(int proId);

}
