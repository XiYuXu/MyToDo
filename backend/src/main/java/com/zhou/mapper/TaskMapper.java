package com.zhou.mapper;


import com.zhou.pojo.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskMapper {
    List<Task> getAllTasks();

}
