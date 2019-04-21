package com.service.impl;

import com.entity.PawnAccount;
import com.mapper.PawnAccountMapper;
import com.service.PawnAccountService;
import com.utils.R;
import com.utils.ShiroUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PawnAccountServiceImpl implements PawnAccountService {
    @Resource
    private PawnAccountMapper pawnAccountMapper;
    @Override
    public R accountList() {
        PawnAccount pawnAccount =pawnAccountMapper.findByUserId(ShiroUtils.getUserId());
        return R.ok().put("account",pawnAccount);
    }

    @Override
    public R selectMoney(String money) {
        PawnAccount pawnAccount=pawnAccountMapper.findByUserId(ShiroUtils.getUserId());
        if(pawnAccount.getUsableMoney()>Double.valueOf(money)){
            return R.ok();
        }
        return R.error("账户余额不足");
    }
}
