package com.service;

import com.entity.Products;
import com.utils.Pager;
import com.utils.R;
import com.utils.ResultData;

public interface ProductsService {
    public ResultData findByProducts(Pager pager, String search);
    public R findByProId(int proId);
    public R updatePageView(int proId);
}
