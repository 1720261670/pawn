package com.controller;

import com.service.BrandService;
import com.service.TypeService;
import com.utils.GetIpAddr;
import com.utils.Pager;
import com.utils.R;
import com.utils.ResultData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class TypeController {
    @Resource
    private TypeService typeService;
    @Resource
    private BrandService brandService;
    //头信息展示全部类型
    @RequestMapping("/pawn/type/header")
    public R typeHeader(HttpServletRequest request){
        System.out.println("用户的ip地址"+GetIpAddr.getIpAddr(request));
        return typeService.typeList();
    }
    //根据类型id展示响应的品牌
    @RequestMapping("/pawn/type/findBrandByTypeId")
    public ResultData findBrandByTypeId( int typeId, Pager pager){
        return brandService.findBrandByTypeId(typeId,pager);
    }
    //展示类型
    @RequestMapping("/pawn/type/list")
    public R typeList(){
        return typeService.typeList();
    }
    //根据类型id查询出品牌下的响应商品

}
