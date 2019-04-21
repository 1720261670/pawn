package com.controller;

import com.service.PawnAccountService;
import com.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PawnAccountController {
    @Resource
    private PawnAccountService pawnAccountService;
    //查询用户的个人账单
    @RequestMapping("/pawn/user/account")
    public R accountList(){
        return pawnAccountService.accountList();
    }
    //提现查询个人余额是否充足
    @RequestMapping("/pawn/user/judge/{money}")
    public R selectUsableMoney(String money ){
        return pawnAccountService.selectMoney(money);
    }


}
