package com.realm;

import com.entity.PawnUser;
import com.service.PawnUserService;
import com.service.SysMenuService;
import com.service.SysRoleService;
import com.utils.R;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserRealm extends AuthorizingRealm {
    @Resource
    private PawnUserService pawnUserService;
    @Resource
    private SysRoleService sysRoleService;
    @Resource
    private SysMenuService sysMenuService;


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证");
        UsernamePasswordToken u = (UsernamePasswordToken) token;
        String uname= u.getUsername();

        String upass= new String (u.getPassword());
        //调用service层方法
        R r= pawnUserService.findByUserName(uname);
        PawnUser user =(PawnUser)r.get("data");
        if(user==null){
            throw new UnknownAccountException("账号不存在");
        }

        Md5Hash md5Hash = new Md5Hash(upass,uname,1024);
        String pass=md5Hash.toString();

        if(!user.getPassword().equals(pass)){
            throw new IncorrectCredentialsException("密码错误");
        }
        if(user.getStatus()==0){
            throw new LockedAccountException("账号被冻结");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,upass,this.getName());
        System.out.println("pawn----->认证结束");
        return info;
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("pawn授权");
        //获得当前登录的用户
        PawnUser user =(PawnUser) principals.getPrimaryPrincipal();
        //根据当前用户id查询角色名
        List<String> roles = sysRoleService.findRolesByPawnUserId(user.getUserId());
        //在查询权限
        List<String> perms = sysMenuService.findPermsByPawnUserId(user.getUserId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roles);
        info.addStringPermissions(perms);
        System.out.println("---->授权成功");
        return info;
    }
}
