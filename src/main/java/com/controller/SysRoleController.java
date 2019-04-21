package com.controller;

import com.entity.SysRole;
import com.service.SysRoleService;
import com.utils.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;

    @RequestMapping("sys/role/info/{roleId}")
    public R findRole(@PathVariable long roleId){
        List<SysRole> list = sysRoleService.findRole();
        return R.ok().put("roleList",list);
    }

    @RequestMapping("/sys/role/list")
    public ResultData roleList(Pager pager,String search,Sorter sorter){
        return sysRoleService.roleList(pager,search,sorter);
    }
}
