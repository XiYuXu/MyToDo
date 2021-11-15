package com.zhou.controllers;

import cn.dev33.satoken.stp.StpUtil;
import com.zhou.pojo.User;
import com.zhou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    //获取所有用户
    @GetMapping("/users")
    public List<User> showUser(){
        return userService.getAllUsers();
    }

    //用户登录
    @PostMapping("/user/login")
    public boolean verifyUser(@RequestBody Map<String,Object> map){
        return userService.verifyUser(map);
    }

    //用户信息获取
    @GetMapping("/user/profile")
    public User getUserProfile(){
        if(StpUtil.isLogin()){
            //将该token中取出对应的userId
            int userId = Integer.parseInt(StpUtil.getLoginId().toString());
            return userService.getUserByUserId(userId);
        }
        return null;
    }

    //判断是否用户名和密码重了，注册时候提出警告
    @GetMapping("/user/existUserName")
    public boolean isExistUserName(@RequestBody String userName){
        List<User> users = userService.getAllUsers();
        for(User user:users){
            if(user.getUserName().equals(userName)){
                return false;
            }
        }
        return false;
    }

    //修改密码
    @PostMapping("/setPassword")
    public boolean setPassword(@RequestBody String newPassword){
        if(userService.setPassword(newPassword)){
            return true;
        }
        return false;
    }

    //用户注册
    @PostMapping("/new")
    public boolean addUser(@RequestBody User newUser){
        return userService.insertUser(newUser);
    }

    //修改用户信息
    @PutMapping("/settings/profile")
    public boolean  updateUserProfile(@RequestBody Map<String,Object> map){
        return userService.updateUser(map);
    }


}
