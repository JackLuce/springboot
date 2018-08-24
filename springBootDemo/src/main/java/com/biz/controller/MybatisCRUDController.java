package com.biz.controller;

import com.biz.pojo.JSONResult;
import com.biz.pojo.SysUser;
import com.biz.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("mybatis")
public class MybatisCRUDController {

    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @RequestMapping("/saveUser")
    public JSONResult saveUser() throws Exception{
        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("biz-"+new Date());
        user.setNickname("biz-"+new Date());
        user.setPassword("asdfghjkl");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUser(user);
        return JSONResult.ok("保存成功！");
    }
    @RequestMapping("/updateUser")
    public JSONResult updateUser(){

        SysUser user = new SysUser();
        user.setId("171020FWN55RS5AW");
        user.setUsername("LUCEY");
        user.setNickname("露丝");
        user.setPassword("asdfghjkl");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.updateUser(user);
        return JSONResult.ok("修改成功！");
    }
    @RequestMapping("/deleteUser")
    public JSONResult deleteUser(){
        userService.deleteUser("1808229XDAZ2X39P");
        return JSONResult.ok("删除成功！");
    }
    @RequestMapping("/findUserById")
    public JSONResult findUserById(){
        SysUser sysUser = userService.findUserById("1001");
        return JSONResult.ok(sysUser);
    }
    @RequestMapping("/findUserList")
    public JSONResult findUserList(){
        List<SysUser> sysUserList = userService.findUserList();

        return JSONResult.ok(sysUserList);
    }
    @RequestMapping("/findUserListPaged")
    public JSONResult findUserListPaged(Integer page){

        if( page == null){
            page =1;
        }

        Integer pageSize = 2;

        SysUser sysUser = new SysUser();
        sysUser.setNickname("露");

        List<SysUser> sysUserList = userService.findUserListPaged(sysUser,page,pageSize);

        return JSONResult.ok(sysUserList);
    }

    @RequestMapping("/findUserByIdCustom")
    public JSONResult findUserByIdCustom(String id){
        SysUser sysUser = userService.findUserByIdCustom(id);
        return JSONResult.ok(sysUser);
    }
    @RequestMapping("/saveUserTranscational")
    public JSONResult saveUserTranscational(String id){
        SysUser sysUser = userService.findUserById("1001");
        Sid sid = new Sid();
        sysUser.setId(sid.nextShort());
        sysUser.setUsername("999"+new Date());
        userService.saveUserTranscational(sysUser);
        return JSONResult.ok("success!");
    }

}
