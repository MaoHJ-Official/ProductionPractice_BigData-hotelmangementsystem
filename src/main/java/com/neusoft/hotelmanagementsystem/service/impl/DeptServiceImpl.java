package com.neusoft.hotelmanagementsystem.service.impl;

import com.neusoft.hotelmanagementsystem.entity.Dept;
import com.neusoft.hotelmanagementsystem.entity.Emp;
import com.neusoft.hotelmanagementsystem.mapper.DeptMapper;
import com.neusoft.hotelmanagementsystem.mapper.EmpMapper;
import com.neusoft.hotelmanagementsystem.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Override
    public void addDept(Dept dept) {
        System.out.println("deptServiceImpl中的方法");
//        设置部门状态
        dept.setStatus(1);
//        调用方法，实现新设部门的功能 - 向数据库中对应的表插入数据
        this.deptMapper.insertDept(dept);
    }

    @Override
    public void updateDept(Dept dept) {
        this.deptMapper.updateDept(dept);
    }

    @Override
    public Dept queryDeptByDeptId(Integer deptId) {
        return this.deptMapper.selectDeptByDeptId(deptId);
    }

    @Override
    public List<Dept> queryAllDepts(Dept dept) {
        return this.deptMapper.selectAllDepts(dept);
    }

    @Override
    public String deleteDept(Integer deptid) {
//        先判断需要撤除的部门下是否存在员工
//        不存在直接执行撤除的方法
//        存在，不执行，返回相关信息
        String msg = "该部门下存在员工，无法撤除";
        List<Emp> emps = this.empMapper.selectEmpsByDeptId(deptid);
        if (null == emps) {
            this.deptMapper.deleteDeptByDeptId(deptid);
            msg = "success";
        }
        return msg;
    }
}
