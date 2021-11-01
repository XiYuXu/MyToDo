package com.zhou.controllers;

import com.zhou.pojo.User;
import com.zhou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    //获取所有用户
    @GetMapping("/users")
    public List<User> showUser(){
        return userService.getUser();
    }

    //根据用户id获取用户
    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable("userId") int userId){
        return userService.getUserById(userId);
    }

    //新增一个用户
    @PostMapping("/user")
    public boolean addUser(@RequestBody User newUser){
        return userService.insertUser(newUser);
    }

    //修改用户信息
    @PutMapping("/user")
    public boolean  updateUser(@RequestBody Map<String,Object> map){
        return userService.updateUser(map);
    }

    @PostMapping("/user/login")
    public User verifyUser(@RequestBody Map<String,Object> map){
        return userService.verifyUser(map);
    }
}
