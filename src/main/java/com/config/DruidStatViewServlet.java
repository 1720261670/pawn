package com.config;
//登陆账号及黑白名单

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "statViewServlet",urlPatterns = "/druid/*",
initParams = {
        @WebInitParam(name="allow",value = "127.0.0.1"),//白名单
        //@WebInitParam(name="deny",value = ""),//黑名单（共同存在时，优于白名单）
        @WebInitParam(name="loginUsername",value = "xiaobai"),//用户名
        @WebInitParam(name="loginPassword",value = "1234"),//密码
        @WebInitParam(name="resetEnable",value = "false")//禁用html页面的reset all功能
})
public class DruidStatViewServlet extends StatViewServlet {
    //private static final long serialVersionUID=1L;//序列化的版本号
}
