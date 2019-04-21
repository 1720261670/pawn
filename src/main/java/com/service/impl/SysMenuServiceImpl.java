package com.service.impl;

import com.entity.SysMenu;
import com.entity.SysMenuExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.SysMenuMapper;
import com.service.SysMenuService;
import com.utils.R;
import com.utils.ResultData;
import com.utils.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;
    @Override
    public List<String> findPermsByPawnUserId(int userId) {
        return sysMenuMapper.findPermsByPawnUserId(userId);
    }

    @Override
    public List<String> findPermsByUserId(long userId) {
        return sysMenuMapper.findPermsByUserId(userId);
    }
}
