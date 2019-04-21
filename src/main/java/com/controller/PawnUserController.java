package com.controller;

import com.dto.PawnUserDto;
import com.entity.PawnUser;
import com.google.code.kaptcha.Producer;
import com.service.PawnUserService;
import com.utils.R;
import com.utils.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@RestController
public class PawnUserController {
    @Resource
    private PawnUserService pawnUserService;
    @Resource
    private Producer producer;

    //验证码
    @RequestMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response){
        try {
            String text = producer.createText();

            System.out.println(text);
            ShiroUtils.setAttribute("code",text);

            BufferedImage bufferedImage = producer.createImage(text);

            OutputStream os=response.getOutputStream();

            ImageIO.write(bufferedImage,"jpg",os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //查询用户名是否存在，注册时验证不存在，忘记密码时验证存在
    @RequestMapping("/pawn/demo/registerName/{username}")
    public R findByUserName(@PathVariable String username){
       return pawnUserService.findByUserName(username);
    }

    //注册查询手机号是否存在
    @RequestMapping("/pawn/demo/findmobile/{mobile}")
    public R findByMobile(@PathVariable String mobile){
        return pawnUserService.findByMobile(mobile);
    }

    //根据用户输入的信息注册
    @RequestMapping("/pawn/demo/register")
    public R userRegister(@RequestBody PawnUserDto pawnUserDto){
        //服务端生成的验证码
        String code=ShiroUtils.getCaptcha();

        //用户输入的验证码
        String c = pawnUserDto.getCaptcha();
        System.out.println("用户输入"+c+"---"+"生成"+code);
        if(code!=null&&!code.equalsIgnoreCase(c)){
            return R.error("验证码错误");
        }
        return pawnUserService.userRegister(pawnUserDto);
    }

    //忘记密码验证用户和手机号是否一致
    @RequestMapping("/pawn/demo/forgetPassword")
    public R forgetPassword(@RequestBody String username,@RequestBody String mobile){
        return pawnUserService.forgetPassword(username,mobile);
    }
    //查询用户密码,验证输入的原密码是否正确
    @RequestMapping("/pawn/demo/findPasswordByUsername")
    public R findPasswordByUsername(@RequestBody String username,@RequestBody String password){
        return pawnUserService.findPasswordByUsername(username,password);
    }


    //传入用户和密码，修改密码
    @RequestMapping("/pawn/demo/updatePassword")
    public R updatePassword(@RequestBody String username,@RequestBody String password){
        return pawnUserService.updatePassword(username,password);
    }

    //用户登录
    @RequestMapping("/pawn/demo/login")
    public R userLogin(@RequestBody PawnUserDto pawnUserDto){
        System.out.println("用户登录");
        //服务端生成的验证码
        String code=ShiroUtils.getCaptcha();

        //用户输入的验证码
        String c = pawnUserDto.getCaptcha();
        System.out.println("用户输入"+c+"---"+"生成"+code);
        if(code!=null&&!code.equalsIgnoreCase(c)){
            return R.error("验证码错误");
        }
        String s = null;

        try {
            //得到对象
            Subject subject = SecurityUtils.getSubject();
            //把用户名和密码封装到token
            UsernamePasswordToken token = new UsernamePasswordToken(pawnUserDto.getUsername(),pawnUserDto.getPassword());
            //登陆
            if(pawnUserDto.isRememberMe()){
                token.setRememberMe(true);
            }
            subject.login(token);
            return R.ok();
        } catch (Exception e) {
            s= e.getMessage();
        }
        return R.error(s);
    }
    //退出
    @RequestMapping("/logout")
    public R logout(){
        ShiroUtils.logout();
        return R.ok();
    }
}
