package com.neusoft.hotelmanagementsystem.service;

import com.neusoft.hotelmanagementsystem.entity.Dept;

import java.util.List;

public interface DeptService {

    void addDept(Dept dept);

    void updateDept(Dept dept);

    Dept queryDeptByDeptId(Integer deptId);

    List<Dept> queryAllDepts(Dept dept);

    String deleteDept(Integer deptid);
}
