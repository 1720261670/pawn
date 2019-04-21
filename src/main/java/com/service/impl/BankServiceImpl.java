package com.service.impl;

import com.mapper.BankMapper;
import com.service.BankService;
import com.utils.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BankServiceImpl implements BankService {
    @Resource
    private BankMapper bankMapper;
    @Override
    public R bankList() {
        return R.ok().put("bankList",bankMapper.selectByExample(null));
    }
}
