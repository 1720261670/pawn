package com.service;

import com.entity.SysMenu;
import com.utils.R;
import com.utils.ResultData;

import java.util.List;

public interface SysMenuService {
    public List<String> findPermsByPawnUserId(int userId);
    public List<String> findPermsByUserId(long userId);
}
