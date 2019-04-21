package com.service.impl;

import com.entity.PawnCart;
import com.entity.PawnCartExample;
import com.entity.Products;
import com.mapper.PawnCartMapper;
import com.mapper.ProductsMapper;
import com.service.CartService;
import com.utils.R;
import com.utils.ShiroUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service(value = "cartServiceImpl")
public class CartServiceImpl implements CartService {

    @Resource
    private PawnCartMapper pawnCartMapper;
    @Resource
    private ProductsMapper productsMapper;

    @Override
    public R findProByUserId() {

        List<Map<String,Object>> prolist = pawnCartMapper.findProByUserId(ShiroUtils.getUserId());
        return R.ok().put("shoppingCart",prolist);
    }

    @Override
    public R delProByUserId(List<Integer> ids) {
        PawnCartExample example = new PawnCartExample();
        PawnCartExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        int i = pawnCartMapper.deleteByExample(example);
        if (i>0){
            return R.ok();
        }
        return R.error("删除失败");
    }

    @Override
    public R saveProByCart(PawnCart pawnCart) {
        int i = pawnCartMapper.insert(pawnCart);
        return i>0?R.ok("添加购物袋成功"):R.error("添加购物袋失败");
    }

    @Override
    public R updateCartByNumber(int number, int id) {
        PawnCart pawnCart = new PawnCart();
        pawnCart.setId(id);
        pawnCart.setProNumber(number);
        int i = pawnCartMapper.updateCartByNumber(pawnCart);
        return i>0?R.ok():R.error();
    }

    @Override
    public R findProByProId(int proId) {
        Products products=productsMapper.selectByPrimaryKey(proId);
        return R.ok().put("product",products);
    }
}
