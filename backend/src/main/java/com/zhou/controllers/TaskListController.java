package com.zhou.controllers;

import com.zhou.pojo.TaskList;
import com.zhou.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName TaskListController
 * @Description
 * @Author 28310
 * @Date 2021/11/1 18:44
 * @Version 1.0.0
 **/
@RestController
public class TaskListController {
    @Autowired
    TaskListService taskListService;
    //获取用户所有的自定义任务集
    @GetMapping("/{userId}/OwnTaskList")
    public List<TaskList> getOwnTaskList(@PathVariable("userId") int userId) {
        return taskListService.getOwnTaskList();
    }

    //获取用户所有计划
    @GetMapping("/{userId}/plans")
    public List<TaskList> getPlans(@PathVariable("userId") int userId) {
        return null;
    }

    //添加一个新的空任务列表
    @PostMapping("/{userId}/TaskList")
    public boolean addTaskList(@PathVariable("userId") int userId,@RequestBody Map<String,Object> map) {
        return true;
    }

    //修改任务列表
    @PutMapping("/{userId}/taskList")
    public boolean updateTaskList(@PathVariable("userId") int userId,@RequestBody Map<String,Object> map){
        return true;
    }

    //删除任务列表(应为级联删除)
    @DeleteMapping("/{userId}/taskList/{taskListId}")
    public boolean deleteTaskList(@PathVariable("userId") int userId,@PathVariable("taskListId")int taskListId){
        return true;
    }

    //移动任务
    @PostMapping("/{userId}/task/{taskId}/{fromTaskListId}/{toTaskListId}")
    public boolean moveTask(@PathVariable("userId")int userId,@PathVariable("taskId")int taskId,@PathVariable("fromTaskListId")int fromTaskListId,@PathVariable("toTaskListId")int toTaskListId){
        return true;
    }
}

