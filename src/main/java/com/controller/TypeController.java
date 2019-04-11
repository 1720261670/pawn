package com.controller;

import com.service.TypeService;
import com.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TypeController {
    @Resource
    private TypeService typeService;
    @RequestMapping("/pawn/type/header")
    public R typeList(){
        return typeService.typeList();
    }
}
