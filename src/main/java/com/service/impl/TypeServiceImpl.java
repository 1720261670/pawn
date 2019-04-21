package com.service.impl;

import com.entity.Type;
import com.mapper.TypeMapper;
import com.service.TypeService;
import com.utils.R;
import com.utils.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Resource
    private TypeMapper typeMapper;

    @Override
    public R typeList() {
        List<Type> list = typeMapper.selectByExample(null);
        return R.ok().put("data",list);
    }
}
