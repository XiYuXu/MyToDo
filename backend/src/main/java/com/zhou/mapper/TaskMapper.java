package com.zhou.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskMapper {
    private int taskId;
    private String title;
    private String description;
    private boolean finished;
    private boolean important;
    private LocalDate endTime;
    private String icon;
    private int taskListId;
    private String planId;
}
