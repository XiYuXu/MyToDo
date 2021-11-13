package com.zhou.mapper;

import com.zhou.pojo.Plan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PlanMapper {

    List<Plan> getAllPlans();

    List<Plan> getOwnPlan(int userId);

    boolean addPlan(Map<String, Object> map);

    boolean updatePlan(Map<String, Object> map);

    boolean deletePlan(Map<String, Object> map);

}
