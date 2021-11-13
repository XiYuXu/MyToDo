package com.zhou.service;

/**
 * @ClassName PlanService
 * @Description
 * @Author 28310
 * @Date 2021/11/12 16:02
 * @Version 1.0.0
 **/

import cn.dev33.satoken.stp.StpUtil;
import com.zhou.mapper.PlanMapper;
import com.zhou.pojo.Plan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class PlanService {

    PlanMapper PlanMapper;
    public PlanService(PlanMapper planMapper){
        this.PlanMapper = planMapper;
    }

    //获取所有的计划
    public List<Plan> getAllPlans() {
        return PlanMapper.getAllPlans();
    }
    //获取个人计划
    public List<Plan> getOwnPlan() {
        if(StpUtil.isLogin()) {
            int userId = Integer.parseInt(StpUtil.getLoginId().toString());
            return PlanMapper.getOwnPlan(userId);
        }
        return null;
    }

    //添加新计划
    public boolean addPlan(Map<String, Object> map) {
        if(StpUtil.isLogin()) {
            int userId = Integer.parseInt(StpUtil.getLoginId().toString());
            map.put("userId",userId);
            return  PlanMapper.addPlan(map);
        }
        return false;
    }
    //修改计划
    public boolean updatePlan(Map<String, Object> map) {
        if(StpUtil.isLogin()) {
            int userId = Integer.parseInt(StpUtil.getLoginId().toString());
            map.put("userId",userId);
            return  PlanMapper.updatePlan(map);
        }
        return false;
    }
    //删除计划（级联删除）
    public boolean deletePlan(Map<String,Object> map) {
        //先删除计划表中的任务集合





        if(StpUtil.isLogin()) {
            int userId = Integer.parseInt(StpUtil.getLoginId().toString());
            map.put("userId",userId);
            return PlanMapper.deletePlan(map);
        }
       return false;
    }
}
