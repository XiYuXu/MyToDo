package com.zhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class TaskList {
    private int taskListId;     //任务集ID
    private String title;       //任务集标题
    private String description; //任务集描述
    private boolean deleted;    //是否被删除
    private int fatherListId;   //父级任务ID
    private int userId;         //所属用户ID
}
