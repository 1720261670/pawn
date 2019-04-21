package com.service;

import com.entity.PawnUser;
import com.utils.R;

public interface PawnUserService {
    public R findByUserName(String uname);
    public R userRegister(PawnUser pawnUser);
    public R findByMobile(String mobile);
    public R forgetPassword(String username,String mobile);
    public R updatePassword(String username,String password);
    public R findPasswordByUsername(String username,String password);
}
