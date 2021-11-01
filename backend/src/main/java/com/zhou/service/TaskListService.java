package com.zhou.service;

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
    @Autowired
    TaskListMapper taskListMapper;

    public List<TaskList> getOwnTaskList() {
        return taskListMapper.getOwnTaskList();
    }
}
