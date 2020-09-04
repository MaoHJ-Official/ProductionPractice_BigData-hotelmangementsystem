package com.neusoft.hotelmanagementsystem.service.impl;

import com.neusoft.hotelmanagementsystem.entity.Emp;
import com.neusoft.hotelmanagementsystem.entity.Hr;
import com.neusoft.hotelmanagementsystem.mapper.EmpMapper;
import com.neusoft.hotelmanagementsystem.mapper.HrMapper;
import com.neusoft.hotelmanagementsystem.service.EmpService;
import com.neusoft.hotelmanagementsystem.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Service("empService")
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private HrMapper hrMapper;

    @Override
    public void addEmp(Emp emp) throws NoSuchAlgorithmException {
//        设置属性
        emp.setStatus(1);
        emp.setHireDate(new Date());

        this.empMapper.insertEmp(emp);
//        hr - 都是员工 - 部门是人事部门的
//        如果是人事部门的员工需要增加到hr表中 -- hr属性 deptid- 数据库自动生成的
        if (10001 == emp.getDeptId()) {
            String password = MD5Util.getMD5String(MD5Util.getMD5String("123456"));
//            构建HR对象
            Hr hr = Hr.builder().empId(emp.getEmpId()).empPass(password).build();
            hrMapper.insertHr(hr);
        }
    }
}
