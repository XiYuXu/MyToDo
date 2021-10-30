package com.zhou.mapper;

import com.zhou.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    List<User> getUserList();
    User getUserById(int id);
    User getUserByUserName(String userName);
    int insertUser(User user);
    int updateUserById(Map<String,Object> map);
}
