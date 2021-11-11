package com.zhou.controllers;

import com.zhou.pojo.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TaskController {
    //获取用户所有的任务
    @GetMapping("/{userId}/tasks/all")
    public List<Task> getAllTasks(@PathVariable("userId") int userId){
        return null;
    }

    //获取用户的今日任务
    @GetMapping("/{userId}/tasks/today")
    public List<Task> getTodayTasks(@PathVariable("userId") int userId){
        return null;
    }

    //获取用户的某个任务集下的所有任务
    @GetMapping("/{userId}/{taskListId}/tasks")
    public List<Task> getTasksByTaskListId(@PathVariable("userId") int userId,@PathVariable("taskListId") int taskListId){
        return null;
    }

    //添加任务到某个地方
    @PostMapping("/{userId}/{taskListId}/task")
    public boolean addTaskToTaskList(@PathVariable("userId") int userId,@PathVariable("taskListId") int taskListId,@RequestBody Map<String,Object> map){
        return true;
    }

    //更新任务
    @PutMapping("/{userId}/task/taskId")
    public Task updateTask(@PathVariable("userId") int userId,@RequestBody Map<String,Object>map){
        return null;
    }


    //移动任务
    @PostMapping("/{userId}/task/{taskId}/{fromTaskListId}/{toTaskListId}")
    public boolean moveTask(@PathVariable("userId")int userId,@PathVariable("taskId")int taskId,@PathVariable("fromTaskListId")int fromTaskListId,@PathVariable("toTaskListId")int toTaskListId){
        return true;
    }
}
