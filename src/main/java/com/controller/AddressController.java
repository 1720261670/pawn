package com.controller;

import com.service.AreaService;
import com.service.CityService;
import com.service.ProvinceService;
import com.utils.R;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AddressController {
    @Resource
    private ProvinceService provinceService;
    @Resource
    private CityService cityService;
    @Resource
    private AreaService areaService;

    @RequestMapping("/pawn/address/provinceList")
    public R provinceList(){
       return R.ok().put("province",provinceService.provinceList());
    }
    @RequestMapping("/pawn/address/city/{provinceid}")
    public R cityByProvinceId(@PathVariable String provinceid){
        return R.ok().put("city",cityService.findCityByProvinceID(provinceid));

    }
    @RequestMapping("/pawn/address/area/{cityid}")
    public R areaByCityId(@PathVariable String cityid){
        return R.ok().put("area",areaService.findAreaByCityID(cityid));
    }
}
