package com.zhou.controllers;

import com.zhou.pojo.Plan;
import com.zhou.service.PlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName PlanController
 * @Description
 * @Author 28310
 * @Date 2021/11/12 12:11
 * @Version 1.0.0
 **/
@RestController
public class PlanController {
    PlanService planService;
    public PlanController(PlanService planService){
        this.planService = planService;
    }

    //获取所有的计划
    @GetMapping("/AllPlans")
    public List<Plan> getAllPlans() {
        return planService.getAllPlans();
    }

    //获取用户自定义计划
    @GetMapping("/OwnPlan")
    public List<Plan> getOwnPlan() {
        return planService.getOwnPlan();
    }

    //添加新计划
    @PostMapping("/Plan/new")
    public boolean addPlan(@RequestBody Map<String,Object> map) {
        return planService.addPlan(map);
    }

    //修改计划
    @PutMapping("/Plan/update")
    public boolean updatePlan(@PathVariable("userId") int userId,@RequestBody Map<String,Object> map){
        return true;
    }

    //删除计划(应为级联删除)
    @DeleteMapping("/plan/{Plan_id}/delete")
    public boolean deletePlan(@PathVariable("userId") int userId,@PathVariable("planId")int PlanId){
        return true;
    }
}
