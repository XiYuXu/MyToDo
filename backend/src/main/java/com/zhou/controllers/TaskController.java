package com.zhou.controllers;

import com.zhou.pojo.Task;
import com.zhou.service.TaskService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TaskController {
    TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/allTasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    //获取某个taskList或plan下所有的任务
    @GetMapping("/**/tasks")
    public List<Task> getTasksByTaskListId(@RequestBody Map<String,Object> map) {
        return taskService.getTasksByTaskListId(map);
    }

    //获取用户的今日任务
    @GetMapping("/today/tasks")
    public List<Task> getTodayTasks(){
        return taskService.getTodayTasks();
    }
    
    //添加任务到某个地方
    @PostMapping("/**/task/new")
    public boolean addTaskToTaskList(@RequestBody Map<String,Object> map){
        map.put("description",map.get("start_time"));
        return taskService.addTaskToTaskList(map);
    }

    //更新任务
    @PutMapping("/**/task/update")
    public boolean updateTask(@RequestBody Map<String,Object> map){
        return taskService.updateTask(map);
    }
    //移动任务
    @PostMapping("/**/task/move")
    public boolean moveTask(@RequestBody Map<String,Object> map){
        return taskService.moveTask(map);
    }
    //删除任务
    @DeleteMapping("/**/task/delete")
    public boolean deleteTask(@RequestBody Map<String,Object> map){
        return taskService.deleteTask(map);
    }

}
