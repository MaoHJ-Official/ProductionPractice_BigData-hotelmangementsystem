package com.neusoft.hotelmanagementsystem.test;

import com.neusoft.hotelmanagementsystem.entity.Dept;
import org.junit.jupiter.api.Test;

public class TestLombok {

    @Test
    public void test(){
        Dept dept = new Dept();
        dept.setDeptId(1);
        dept.setDeptName("bumen");
        System.out.println(dept);

        Dept dept1 = Dept.builder().deptId(12).deptName("部门").status(1).build();
        System.out.println(dept1);
    }
}
