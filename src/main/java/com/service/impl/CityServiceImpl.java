package com.service.impl;

import com.entity.City;
import com.entity.CityExample;
import com.mapper.CityMapper;
import com.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CityServiceImpl implements CityService {
    @Resource
    private CityMapper cityMapper;
    @Override
    public List<City> findCityByProvinceID(String provinceID) {
        CityExample example = new CityExample();
        CityExample.Criteria criteria = example.createCriteria();
        criteria.andFatherEqualTo(provinceID);
        List<City> city = cityMapper.selectByExample(example);
        return city;
    }
}
