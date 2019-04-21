package com.controller;

import com.service.BankService;
import com.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BankController {
    @Resource
    private BankService bankService;
    //查询出所有的银行卡号头信息，判断是不是银行卡号
    @RequestMapping("/pawn/bank/list")
    public R bankList(){
        return bankService.bankList();
    }
}
