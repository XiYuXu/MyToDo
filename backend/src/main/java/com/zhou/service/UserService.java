package com.zhou.service;

import com.zhou.mapper.UserMapper;
import com.zhou.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> getUser(){
        List<User> users = userMapper.getUserList();
        return users;
    }

    public User getUserById(int id){
        User user = userMapper.getUserById(id);
        return user;
    }

    public int insertUser(User user) {
        userMapper.insertUser(user);
        return 1;
    }
    public int updateUserById(Map<String,Object> map){
        userMapper.updateUserById(map);
        return 1;
    }

    public boolean verifyUser(Map<String,Object> map){
        User resultUser = userMapper.getUserByUserName((String)map.get("userName"));
        if(map.get("userName").equals(resultUser.getUserName())){
            if(map.get("password").equals(resultUser.getPassword())){
                return true;
            }
        }
        return false;
    }

}
