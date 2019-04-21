package com.service;

import com.entity.SysRole;
import com.utils.Pager;
import com.utils.ResultData;
import com.utils.Sorter;
import org.springframework.stereotype.Service;

import java.util.List;
public interface SysRoleService {
    public List<String > findRolesByPawnUserId(int userId);
    public List<String > findRolesByUserId(long userId);
    public List<SysRole> findRole();
    public ResultData roleList(Pager pager, String search, Sorter sorter);
}
