package com.zkh.admin.controller;

import com.zkh.admin.bean.City;
import com.zkh.admin.bean.User1;
import com.zkh.admin.service.CityService;
import com.zkh.admin.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author zkh
 * @date 2022/6/3 -21:11
 */

@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    User1Service user1Service;

    @Autowired
    CityService cityService;

    //去插入页面
    @GetMapping("toInsert")
    public String toInsertCity(){
        return "postTest";
    }

    //测试mybatis插入数据库。
    @ResponseBody
    @PostMapping("/saveCity")
    public City insertCity(City city){
        cityService.insertCity(city);
        return city;
    }
")
    //测试mybatis注解版，没有xml文件
    @ResponseBody
    @GetMapping("/city
    public City selectCityById(@RequestParam("id") Long id){
        return cityService.selectCityById(id);
    }

    //测试mybatis
    @ResponseBody
    @GetMapping("/user1")
    public User1 selectUserByUserName(@RequestParam("username") String username){
        User1 user = user1Service.selectUser1ByUserName(username);
        return user;
    }

    //测试sql
    @ResponseBody
    @GetMapping("/sql")
    public String sql(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        return aLong.toString();
    }


    @GetMapping(value = {"/","/login"})
    public String login(){
        return "login";
    }


    @PostMapping("/login")
    public String main(User1 user, HttpSession session, Model model){
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
