package com.service;

import com.utils.Pager;
import com.utils.ResultData;

public interface BrandService {
    public ResultData findBrandByTypeId(int typeId,Pager pager);
}
