package com.controller;

import com.entity.UserAssetDetails;
import com.service.UserAssetDetailsService;
import com.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class userAssetDetailsController {
    @Resource
    private UserAssetDetailsService userAssetDetailsService;
    //用户的资金流向
    @RequestMapping("/pawn/user/assetDetail")
    public R assetDetailList(){
        return userAssetDetailsService.assetDetailList();
    }
}
