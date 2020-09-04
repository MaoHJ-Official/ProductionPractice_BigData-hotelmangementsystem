package com.neusoft.hotelmanagementsystem.service;

import com.neusoft.hotelmanagementsystem.entity.Emp;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface EmpService {
    List<Emp> queryAllEmps();

    void addEmp(Emp emp) throws NoSuchAlgorithmException; // alt + enter

    void deleteEmp(Integer empId) throws NoSuchAlgorithmException;

    Emp queryEmpByEmptId(Integer empId);

    public void updateEmp(Emp emp);
}
