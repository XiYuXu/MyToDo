package com.zhou.mapper;


import com.zhou.pojo.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TaskMapper {
    List<Task> getAllTasks();

    List<Task> getTasksByTaskListId(Map<String,Object> map);

    List<Task> getTodayTasks(int userId);

    boolean addTaskToTaskList(Map<String, Object> map);

    boolean updateTask(Map<String, Object> map);

    boolean deleteTask(Map<String, Object> map);

    boolean moveTask(Map<String, Object> map);

    boolean deleteTaskByTaskListId(Map<String, Object> map);

    boolean deleteTaskByPlanId(Map<String, Object> map);
}
