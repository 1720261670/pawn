package com.controller;

import com.entity.PawnCart;
import com.service.CartService;
import com.utils.R;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CartController {

    @Resource
    private CartService cartService;
    //添加到购物袋
    @RequestMapping("/pawn/ShoppingCart/save")
    public R saveCart(@RequestBody PawnCart pawnCart){
        return cartService.saveProByCart(pawnCart);
    }
    //根据用户id查询购物袋信息
    @RequestMapping("/pawn/shoppingCart/list")
    public R selectCartPro(){
        return cartService.findProByUserId();
    }
    //批量删除购物袋商品
    @RequestMapping("/pawn/shoppingCart/del")
    public R delProByUserId(@RequestBody List<Integer> ids){
        return cartService.delProByUserId(ids);
    }
    //用户点击数量按钮修改商品数量
    @RequestMapping("/pawn/shoppingCart/number/{number,id}")
    public R updateCartByNumber(@PathVariable int number, @PathVariable int id){
        return cartService.updateCartByNumber(number,id);
    }
    //立即结算跳转到订单填写页查找用户订单信息

    //点击编辑带着商品信息跳转到估算页面
    @RequestMapping("/pawn/shoppingCart/redact ")
    public R redactCart(int proId){
        return cartService.findProByProId(proId);
    }
    //点击结算按钮删除购物袋商品添加到订单
}
