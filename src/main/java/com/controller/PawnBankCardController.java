package com.controller;

import com.service.PawnBankCardService;
import com.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PawnBankCardController {
    @Resource
    private PawnBankCardService pawnBankCardService;
    //点击提现按钮查询出用户的所有银行卡号
    @RequestMapping("/pawn/user/cardList")
    public R bankCardByUser(){
        return R.ok().put("cardList",pawnBankCardService.findBankCardByUser());
    }
    //提现,传入银行卡的id和金额
    @RequestMapping("/pawn/user/withdraw")
    public R withdraw(int id,Double money){
        return pawnBankCardService.withdrawCash(id,money);
    }
    //添加银行卡,输入银行卡号和银行id
    @RequestMapping("/pawn/user/cardSave")
    public R bankCradSave(String cardNo,int bankId ){
        return pawnBankCardService.bankCardSave(cardNo,bankId );
    }
}
