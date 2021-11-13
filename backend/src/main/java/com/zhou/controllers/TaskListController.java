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

    TaskListService taskListService;

    public TaskListController(TaskListService taskListService){
        this.taskListService = taskListService;
    }

    //获取所有的自定义任务集
    @GetMapping("/AllTaskLists")
    public List<TaskList> getAllTaskLists() {
        return taskListService.getAllTaskLists();
    }
    //获取用户自定义任务集
    @GetMapping("/OwnTaskList")
    public List<TaskList> getOwnTaskList() {
        return taskListService.getOwnTaskList();
    }

    //添加一个新的任务列表
    @PostMapping("/TaskList/new")
    public boolean addTaskList(@RequestBody Map<String,Object> map) {
        return taskListService.addTaskList(map);
    }

    //修改任务列表
    @PutMapping("/TaskList/update")
    public boolean updateTaskList(@RequestBody Map<String,Object> map){
        return taskListService.updateTaskList(map);
    }

    //删除任务列表(应为级联删除)
    @DeleteMapping("/TaskList/delete")
    public boolean deleteTaskList(@RequestBody Map<String,Object> map){
        return taskListService.deleteTaskList(map);
    }
}

