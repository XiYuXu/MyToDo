package com.zhou.service;

import cn.dev33.satoken.stp.StpUtil;
import com.zhou.mapper.TaskListMapper;
import com.zhou.pojo.TaskList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    //获取所有的任务集合
    public List<TaskList> getAllTaskLists() {
        return taskListMapper.getAllTaskLists();
    }
    public List<TaskList> getOwnTaskList() {
        if(StpUtil.isLogin()) {
            int userId = Integer.parseInt(StpUtil.getLoginId().toString());
            return taskListMapper.getOwnTaskList(userId);
        }
        return null;
    }



    //添加新任务集
    public boolean addTaskList(Map<String, Object> map) {
        if(StpUtil.isLogin()) {
            int userId = Integer.parseInt(StpUtil.getLoginId().toString());
            map.put("userId",userId);
            return  taskListMapper.addTaskList(map);
        }
        return false;
    }

    public boolean updateTaskList(Map<String, Object> map) {
        if(StpUtil.isLogin()) {
            int userId = Integer.parseInt(StpUtil.getLoginId().toString());
            map.put("userId",userId);
            return  taskListMapper.updateTaskList(map);
        }
        return false;
    }

    public boolean deleteTaskList(Map<String, Object> map) {
        //先删除计划表中的任务集合



        if(StpUtil.isLogin()) {
            int userId = Integer.parseInt(StpUtil.getLoginId().toString());
            map.put("userId",userId);
            return  taskListMapper.deleteTaskList(map);
        }
        return false;
    }
}
