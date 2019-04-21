package com.service.impl;

import com.entity.Area;
import com.entity.AreaExample;
import com.mapper.AreaMapper;
import com.service.AreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AreaServiceImpl implements AreaService {
    @Resource
    private AreaMapper areaMapper;
    @Override
    public List<Area> findAreaByCityID(String cityID) {
        AreaExample example = new AreaExample();
        AreaExample.Criteria criteria = example.createCriteria();
        criteria.andFatherEqualTo(cityID);
        List<Area> area = areaMapper.selectByExample(example);
        return area;
    }
}
