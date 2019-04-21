package com.service.impl;

import com.entity.Products;
import com.entity.ProductsExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.ProductsMapper;
import com.service.ProductsService;
import com.utils.Pager;
import com.utils.R;
import com.utils.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Resource
    private ProductsMapper productsMapper;
    @Override
    public ResultData findByProducts(Pager pager, String search) {
        PageHelper.offsetPage(pager.getOffset(),pager.getLimit());
        ProductsExample example = new ProductsExample();
        ProductsExample.Criteria criteria = example.createCriteria();
        if(search!=null&&!"".equals(search)){
            criteria.andModelLike("%"+search+"%");
        }
        List<Products> list = productsMapper.selectByExample(example);
        PageInfo info = new PageInfo(list);
        List<Products> list1 = info.getList();
        long total=info.getTotal();
        ResultData resultData = new ResultData(total,list1);
        return resultData;
    }

    @Override
    public R findByProId(int proId) {
        Products products = productsMapper.selectByPrimaryKey(proId);
        if(products!=null){
            return R.ok().put("data",products);
        }
        return R.error();
    }
    @Override
    public R updatePageView(int proId) {
        int i = productsMapper.updatePageView(proId);
        return i>0?R.ok():R.error();
    }
}
