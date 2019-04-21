package com.service;

import com.entity.PawnBankCard;
import com.utils.R;

import java.util.List;

public interface PawnBankCardService {
    public List<PawnBankCard> findBankCardByUser();
    public R withdrawCash(int id,Double money);
    public R bankCardSave(String cardNo,int bankId );
}
