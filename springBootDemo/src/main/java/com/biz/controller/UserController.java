package com.biz.controller;

import com.biz.pojo.JSONResult;
import com.biz.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

//@RestController = @Controller + @ResponseBody
//@Controller
@RequestMapping("/user")
@RestController
public class UserController {

    @RequestMapping("/getUser")
    //@ResponseBody
    public User getUser() {
        User user = new User();
        user.setName("lx");
        user.setPassword("ll");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setDesc("description");

        return user;
    }
    @RequestMapping("/getUserJson")
    @ResponseBody
    public JSONResult getUserJson() {
        User user = new User();
        user.setName("lkjlkj");
        user.setPassword("lljx");
        user.setAge(16);
        user.setBirthday(new Date());
        user.setDesc("description");

        return  JSONResult.ok(user);
    }

}
