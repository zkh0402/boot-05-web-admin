package com.zkh.admin.controller;

import com.zkh.admin.bean.User1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @author zkh
 * @date 2022/6/4 -11:20
 */
@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table(){
        int i =10/0;
        return "/table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        List<User1> users = Arrays.asList(new User1("zs", "123123"),
                new User1("asds", "123"),
                new User1("ggg", "123123123123"),
                new User1("qwe", "123123123123"));
        model.addAttribute("users",users);
        return "/table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "/table/editable_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "/table/responsive_table";
    }
}
