package com.zhou.service;

import cn.dev33.satoken.stp.StpUtil;
import com.zhou.mapper.UserMapper;
import com.zhou.pojo.User;
import com.zhou.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.rmi.CORBA.Util;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    UserMapper userMapper;

    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public List<User> getAllUsers(){
        List<User> users = userMapper.getAllUsers();
        return users;
    }

    public User getUserByUserId(int id){
        User user = userMapper.getUserByUserId(id);
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
        if(StpUtil.isLogin()){
            //将该token中取出对应的loginId
            int userId = Integer.parseInt(StpUtil.getLoginId().toString());
            map.put("userId",userId);
        }
        if(userMapper.updateUser(map)>0){
            return true;
        }
        return false;
    }
    //验证登录
    public boolean verifyUser(Map<String,Object> map){
        User resultUser = userMapper.getUserByUserName((String)map.get("userName"));
        if(map.get("userName").equals(resultUser.getUserName())){
            if(map.get("password").equals(resultUser.getPassword())){
                StpUtil.login(resultUser.getUserId());
                return true;
            }
        }
        return false;
    }


    //修改密码
    public boolean setPassword(String newPassword){
        if(StpUtil.isLogin()){
            //将该token中取出对应的loginId
            int userId = Integer.parseInt(StpUtil.getLoginId().toString());
            Map<String,Object> map = new HashMap<>();
            map.put("userId",userId);
            map.put("newPassword",newPassword);
            if(userMapper.updatePassword(map)){
                return true;
            }
        }
        return false;
    }
}
