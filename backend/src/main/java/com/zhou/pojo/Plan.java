package com.zhou.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName Plan
 * @Description
 * @Author 28310
 * @Date 2021/11/1 21:20
 * @Version 1.0.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Plan {
    private int planId;
    private String title;
    private String description;
    private boolean deleted;
    private int userId;
    private int fatherPlanId;
}
