package com.neusoft.hotelmanagementsystem.service.impl;

import com.neusoft.hotelmanagementsystem.entity.Dept;
import com.neusoft.hotelmanagementsystem.service.DeptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl2 implements DeptService {

    @Override
    public void addDept(Dept dept) {
        System.out.println("deptServiceImpl2中的方法");
    }

    @Override
    public void updateDept(Dept dept) {

    }

    @Override
    public Dept queryDeptByDeptId(Integer deptId) {
        return null;
    }

    @Override
    public List<Dept> queryAllDepts(Dept dept) {
        return null;
    }

    @Override
    public String deleteDept(Integer deptid) {
        return null;
    }
}
