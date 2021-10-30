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

    @GetMapping("/users")
    public List<User> showUser(){
        return userService.getUser();
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public int addUser(User newUser){
        int status_code = userService.insertUser(newUser);
        return status_code;
    }
    @PutMapping("/user/{id}")
    public void  updateUser(@PathVariable("id") int id, @RequestBody Map<String,Object> map){
        userService.updateUserById(map);
    }

    @PostMapping("/user/login")
    public void verifyUser(@RequestBody Map<String,Object> map){
        if(userService.verifyUser(map)){
            System.out.println("login success");
        }else{
            System.out.println("login failure");
        }
    }
}
