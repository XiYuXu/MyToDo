package com.zhou.service;

import cn.dev33.satoken.stp.StpUtil;
import com.zhou.mapper.TaskListMapper;
import com.zhou.pojo.TaskList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TaskListService
 * @Description
 * @Author 28310
 * @Date 2021/11/1 21:20
 * @Version 1.0.0
 **/
@Service
public class TaskListService {

    TaskListMapper taskListMapper;
    public TaskListService(TaskListMapper taskListMapper){
        this.taskListMapper = taskListMapper;
    }

    public List<TaskList> getOwnTaskList() {
        if(StpUtil.isLogin()) {
            int userId = Integer.parseInt(StpUtil.getLoginId().toString());
            return taskListMapper.getOwnTaskList(userId);
        }
        return null;
    }

    public List<TaskList> getAllTaskLists() {
        return taskListMapper.getAllTaskLists();
    }
}
