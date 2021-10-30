package com.zhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Task {
    private int taskId;     //任务id
    private String title;   //任务标题
    private String description; //任务描述
    private String icon;        //头像链接地址
    private boolean finished;  //是否完成
    private boolean important; //是否重要
    private LocalDateTime end_time; //结束时间
    private LocalDateTime start_time; //开始时间
}
