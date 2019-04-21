package com.controller;

import com.dto.ProductsDto;
import com.entity.Products;
import com.service.ProductsService;
import com.utils.Pager;
import com.utils.R;
import com.utils.ResultData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProductsController {
    @Resource
    private ProductsService productsService;
    //分页展示搜索内容(搜索功能)
    @RequestMapping("/pawn/products")
    public ResultData findByProducts(Pager pager,String search){
        return productsService.findByProducts(pager, search);
    }
    //根据商品id展示商品详情
    @RequestMapping("/pawn/products/findById")
    public R findByProductsId(int proId){
        return productsService.findByProId(proId);
    }
    //计算商品的估价价格
    @RequestMapping("/pawn/evaluate")
    public R addOrder(@RequestBody ProductsDto productsDto){
        Double peakPrice = productsDto.getPeakPrice();
        double percent = productsDto.getPercent();
        productsDto.setPrice(peakPrice*percent);
        return R.ok().put("data",productsDto);
    }
    //修改商品的点击数量
    @RequestMapping("/pawn/products/updatePageView/{proId}")
    public R updatePageView(@PathVariable int proId){
        return productsService.updatePageView(proId);
    }
}
