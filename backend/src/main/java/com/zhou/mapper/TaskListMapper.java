package com.zhou.mapper;

import com.zhou.pojo.TaskList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskListMapper {

    List<TaskList> getAllTaskLists();

    List<TaskList> getOwnTaskList(int userId);
}
