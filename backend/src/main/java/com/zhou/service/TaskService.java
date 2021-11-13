package com.zhou.service;

import com.zhou.mapper.TaskMapper;
import com.zhou.pojo.Task;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    TaskMapper taskMapper;
    public TaskService(TaskMapper taskMapper){
        this.taskMapper = taskMapper;
    }

    public List<Task> getAllTasks() {
        return taskMapper.getAllTasks();
    }
}
