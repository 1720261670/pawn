package com.utils;

import com.entity.PawnUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

public class ShiroUtils {
    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

    public static void setAttribute(String k,String v){
        getSession().setAttribute(k,v);
    }

    public static Object getAttribute(String k){
        return getSession().getAttribute(k);
    }

    public static String getCaptcha(){
        return getAttribute("code")+"";
    }

    public static PawnUser getCurrentUser(){
        return  (PawnUser) SecurityUtils.getSubject().getPrincipal();
    }

    public static int getUserId(){
       return getCurrentUser().getUserId();
    }

    public static void logout(){
        SecurityUtils.getSubject().logout();
    }

    public static String getUserPassword(){
        return getCurrentUser().getPassword();
    }
}
