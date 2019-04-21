package com.service.impl;

import com.entity.PawnUser;
import com.entity.PawnUserDiscount;
import com.entity.PawnUserExample;
import com.mapper.DiscountCouponMapper;
import com.mapper.PawnUserDiscountMapper;
import com.mapper.PawnUserMapper;
import com.service.PawnUserService;
import com.utils.R;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class PawnUserServiceImpl implements PawnUserService {
    @Resource
    private PawnUserMapper pawnUserMapper;
    @Resource
    private PawnUserDiscountMapper pawnUserDiscountMapper;
    @Resource
    private DiscountCouponMapper discountCouponMapper;
    @Override
    public R findByUserName(String username) {
        PawnUserExample example = new PawnUserExample();
        PawnUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<PawnUser> list = pawnUserMapper.selectByExample(example);
        if(list==null||list.size()==0){
            return R.ok("用户可用");
        }
//        if(list!=null&&list.size()>0){
//            return R.error("").put("data",list.get(0));
//        }
        return R.error("用户已存在");
    }

    @Override
    public R userRegister(PawnUser pawnUser) {
        pawnUser.setCreateTime(new Date());
        pawnUser.setRoleId(1);
        pawnUser.setStatus((byte)1);
        String upass=pawnUser.getPassword();
        String uname=pawnUser.getUsername();
        Md5Hash md5Hash = new Md5Hash(upass,uname,1024);
        String pass=md5Hash.toString();
        pawnUser.setPassword(pass);
        int i = pawnUserMapper.insert(pawnUser);
        if(i>0){
            //查询出优惠券状态码为0的优惠券id赋值给用户
            PawnUserDiscount pawnUserDiscount = new PawnUserDiscount();
            pawnUserDiscount.setCreateDate(new Date());
            pawnUserDiscount.setUserId(pawnUser.getUserId());
            pawnUserDiscount.setDiscountId(discountCouponMapper.selectIdByStatus());
            pawnUserDiscountMapper.insert(pawnUserDiscount);
            return R.ok("注册成功");
        }
        return R.error("注册失败");
    }

    @Override
    public R findByMobile(String mobile) {
        PawnUserExample example = new PawnUserExample();
        PawnUserExample.Criteria criteria = example.createCriteria();
        criteria.andMobileEqualTo(mobile);
        List<PawnUser> list = pawnUserMapper.selectByExample(example);
        if(list!=null&&list.size()>0){
            return R.error("手机号存在");
        }
        return R.ok("手机号可用");
    }

    @Override
    public R forgetPassword(String username, String mobile) {
        PawnUserExample example = new PawnUserExample();
        PawnUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<PawnUser> list = pawnUserMapper.selectByExample(example);
        if(list!=null&&list.size()>0){
            if(!list.get(0).getMobile().equals(mobile)){
                return R.error("手机号输入有误");
            }else{
                return R.ok("输入正确");
            }

        }
        return R.error("用户不存在");
    }

    @Override
    public R updatePassword(String username, String password) {
        PawnUserExample example = new PawnUserExample();
        PawnUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<PawnUser> list = pawnUserMapper.selectByExample(example);
        PawnUser pawnUser = list.get(0);

        Md5Hash md5Hash = new Md5Hash(password,username,1024);
        String pass=md5Hash.toString();

        pawnUser.setPassword(pass);
        int i = pawnUserMapper.updateByPrimaryKey(pawnUser);
        if(i>0){
            return R.ok("密码重置成功");
        }
        return R.error("密码重置失败");
    }

    @Override
    public R findPasswordByUsername(String username,String password) {
        PawnUserExample example = new PawnUserExample();
        PawnUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<PawnUser> list = pawnUserMapper.selectByExample(example);

        Md5Hash md5Hash = new Md5Hash(password,username,1024);
        String pass=md5Hash.toString();

        PawnUser pawnUser = list.get(0);
        if(pawnUser.getPassword().equals(pass)){
            return R.ok("密码输入正确");
        }
        return R.error("密码输入有误，请重新输入！");
    }

}
