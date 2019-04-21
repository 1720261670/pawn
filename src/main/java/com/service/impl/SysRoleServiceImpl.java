package com.service.impl;

import com.entity.SysRole;
import com.entity.SysRoleExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.SysRoleMapper;
import com.service.SysRoleService;
import com.utils.Pager;
import com.utils.ResultData;
import com.utils.Sorter;
import com.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Override
    public List<String> findRolesByPawnUserId(int userId) {
        return sysRoleMapper.findRolesByPawnUserId(userId);
    }

    @Override
    public List<String> findRolesByUserId(long userId) {
        return sysRoleMapper.findRolesByUserId(userId);
    }
    @Override
    public List<SysRole> findRole() {
        List<SysRole> list = sysRoleMapper.selectByExample(null);
        return list;
    }

    @Override
    public ResultData roleList(Pager pager, String search, Sorter sorter) {
        PageHelper.offsetPage(pager.getOffset(),pager.getLimit());
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();
        if(search!=null&&!"".equals(search)){
            criteria.andRoleNameLike("%"+search+"%");
        }
        if(sorter!=null&& StringUtils.isNotEmpty(sorter.getSort())){
            example.setOrderByClause("role_id"+sorter.getOrder());
        }
        List<SysRole> list = sysRoleMapper.selectByExample(example);
        PageInfo info = new PageInfo(list);
        ResultData data = new ResultData(info.getTotal(),info.getList());
        return data;
    }
}
