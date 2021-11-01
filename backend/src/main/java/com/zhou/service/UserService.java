package com.zhou.service;

import com.zhou.mapper.UserMapper;
import com.zhou.pojo.User;
import com.zhou.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.rmi.CORBA.Util;
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

    public boolean insertUser(User user) {
        //用户信息不全
        if(UserUtil.wrongUser(user)){
            return false;
        }
        if(userMapper.insertUser(user)>0){
            return true;
        }
        return false;
    }

    public boolean updateUser(Map<String,Object> map){
        if(userMapper.updateUser(map)>0){
            return true;
        }
        return false;
    }

    public User verifyUser(Map<String,Object> map){
        User resultUser = userMapper.getUserByUserName((String)map.get("userName"));
        if(map.get("userName").equals(resultUser.getUserName())){
            if(map.get("password").equals(resultUser.getPassword())){
                return resultUser;
            }
        }
        return null;
    }
}
