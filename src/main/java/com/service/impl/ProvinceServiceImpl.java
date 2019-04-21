package com.service.impl;

import com.entity.Province;
import com.mapper.ProvinceMapper;
import com.service.ProvinceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Resource
    private ProvinceMapper provinceMapper;
    @Override
    public List<Province> provinceList() {
        return provinceMapper.selectByExample(null);
    }

}
