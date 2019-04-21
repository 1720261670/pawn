package com.service.impl;

import com.entity.BrandExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.BrandMapper;
import com.service.BrandService;
import com.utils.Pager;
import com.utils.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandMapper brandMapper;
    @Override
    public ResultData findBrandByTypeId(int typeId, Pager pager) {
        PageHelper.offsetPage(pager.getOffset(),pager.getLimit());
        List<Map<String,Object>> list = brandMapper.findBrandByTypeId(typeId);
        PageInfo info=new PageInfo(list);
        List<String > list1 = info.getList();
        long total = info.getTotal();
        ResultData resultData=new ResultData(total,list1);
        return resultData;
    }
}
