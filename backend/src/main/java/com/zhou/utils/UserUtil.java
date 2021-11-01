package com.zhou.utils;

import com.zhou.pojo.User;

/**
 * @ClassName UserUtil
 * @Description
 * @Author 28310
 * @Date 2021/11/1 20:17
 * @Version 1.0.0
 **/
public class UserUtil {
    public static boolean wrongUser(User user){
        if(user.getUserName()==null || user.getPassword()==null){
            return true;
        }
        return false;
    }

}
