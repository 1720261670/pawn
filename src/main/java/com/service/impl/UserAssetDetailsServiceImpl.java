package com.service.impl;

import com.mapper.UserAssetDetailsMapper;
import com.service.UserAssetDetailsService;
import com.utils.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserAssetDetailsServiceImpl implements UserAssetDetailsService {
    @Resource
    private UserAssetDetailsMapper userAssetDetailsMapper;
    @Override
    public R assetDetailList() {
        return R.ok().put("assetDetailList",userAssetDetailsMapper.selectByExample(null));
    }
}
