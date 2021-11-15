package com.zhou.service;

import cn.dev33.satoken.stp.StpUtil;
import com.zhou.mapper.TaskMapper;
import com.zhou.pojo.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TaskService {
    TaskMapper taskMapper;
    public TaskService(TaskMapper taskMapper){
        this.taskMapper = taskMapper;
    }

    public List<Task> getAllTasks() {
        return taskMapper.getAllTasks();
    }

    public List<Task> getTasksByTaskListId(Map<String,Object> map) {
        if(StpUtil.isLogin()){
            map.put("userId",StpUtil.getLoginId());
            return taskMapper.getTasksByTaskListId(map);
        }
        return null;
    }

    public List<Task> getTodayTasks() {
        if(StpUtil.isLogin()){
            return taskMapper.getTodayTasks(Integer.parseInt(StpUtil.getLoginId().toString()));
        }
        return null;
    }

    public boolean addTaskToTaskList(Map<String, Object> map) {
        if(StpUtil.isLogin()){
            map.put("userId",StpUtil.getLoginId());
            return taskMapper.addTaskToTaskList(map);
        }
        return false;
    }

    public boolean updateTask(Map<String, Object> map) {
        if(StpUtil.isLogin()){
            map.put("userId",StpUtil.getLoginId());
            return taskMapper.updateTask(map);
        }
        return false;
    }

    public boolean deleteTask(Map<String, Object> map) {
        if(StpUtil.isLogin()){
            map.put("userId",StpUtil.getLoginId());
            return taskMapper.deleteTask(map);
        }
        return false;
    }

    public boolean moveTask(Map<String, Object> map) {
        if(StpUtil.isLogin()){
            map.put("userId",StpUtil.getLoginId());
            return taskMapper.moveTask(map);
        }
        return false;
    }
}
