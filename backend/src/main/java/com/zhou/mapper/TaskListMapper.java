package com.zhou.mapper;

import com.zhou.pojo.TaskList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TaskListMapper {

    List<TaskList> getAllTaskLists();

    List<TaskList> getOwnTaskList(int userId);

    boolean addTaskList(Map<String, Object> map);

    boolean updateTaskList(Map<String, Object> map);

    boolean deleteTaskList(int taskListId);
}
