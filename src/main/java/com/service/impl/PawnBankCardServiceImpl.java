package com.service.impl;

import com.entity.PawnAccount;
import com.entity.PawnBankCard;
import com.entity.UserAssetDetails;
import com.mapper.PawnAccountMapper;
import com.mapper.PawnBankCardMapper;
import com.mapper.UserAssetDetailsMapper;
import com.service.PawnBankCardService;
import com.utils.R;
import com.utils.ShiroUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PawnBankCardServiceImpl implements PawnBankCardService {
    @Resource
    private PawnBankCardMapper pawnBankCardMapper;
    @Resource
    private UserAssetDetailsMapper userAssetDetailsMapper;
    @Resource
    private PawnAccountMapper pawnAccountMapper;
    @Override
    //根据用户id查询银行卡
    public List<PawnBankCard> findBankCardByUser() {
        return pawnBankCardMapper.findBankCardByUser(ShiroUtils.getUserId());
    }

    @Override
    //提现
    public R withdrawCash(int id, Double money) {
        PawnBankCard pawnBankCard = new PawnBankCard();
        pawnBankCard.setId(id);
        pawnBankCard.setMoney(money);

        int i = pawnBankCardMapper.updateCardByid(pawnBankCard);
        if(i>0){

            UserAssetDetails userAssetDetails = new UserAssetDetails();
            userAssetDetails.setUserId(ShiroUtils.getUserId());
            //查询用户钱包余额
            PawnAccount pawnAccount =pawnAccountMapper.findByUserId(ShiroUtils.getUserId());

            userAssetDetails.setBalance(pawnAccount.getUsableMoney()-money);

            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");

            String newDate=sdf.format(new Date());

            String orderNumber="#GU"+newDate;
            //订单号
            userAssetDetails.setOrderNumber(orderNumber);

            userAssetDetails.setStatus(0);
            //添加资金明细
            userAssetDetailsMapper.insert(userAssetDetails);
            //返回存储的银行及银行卡号
            Map<String, Object> map = pawnBankCardMapper.selectBankName(id);
            String bankName=(String) map.get("bankName");
            String cardNo=(String)map.get("cardNo");
            return R.ok("提现成功").put("bankName",bankName).put("cardNo",cardNo);
        }
        //返回银行及卡号
        return R.error("提现失败");
    }

    @Override
    public R bankCardSave(String cardNo,int bankId ) {
        PawnBankCard pawnBankCard = new PawnBankCard();
        pawnBankCard.setCardNo(cardNo);
        pawnBankCard.setUserId(ShiroUtils.getUserId());
        pawnBankCard.setBankId(bankId );
        int i = pawnBankCardMapper.insert(pawnBankCard);
        return i>0?R.ok("添加银行卡成功"):R.error("添加银行卡失败");
    }
}
