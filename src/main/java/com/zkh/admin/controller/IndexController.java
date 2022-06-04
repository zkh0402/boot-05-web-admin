package com.zkh.admin.controller;

import com.zkh.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @author zkh
 * @date 2022/6/3 -21:11
 */

@Controller
public class IndexController {

    @GetMapping(value = {"/","/login"})
    public String login(){
        return "login";
    }


    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if (StringUtils.hasLength(user.getUsername())&&"123".equals(user.getPassword())){
            session.setAttribute("loginUser",user);
            //登录成功重定向到main，重定向防止表单重复提交
            return "redirect:/main";
        }else{
            model.addAttribute("msg","账号密码错误");
            //返回到登录页面
            return "login";
        }

    }


    //去main.html页面
    @GetMapping("/main")
    public String mainPage(){
            return "main";
    }

}
