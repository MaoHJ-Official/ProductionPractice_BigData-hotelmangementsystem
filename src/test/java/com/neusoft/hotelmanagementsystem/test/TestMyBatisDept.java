package com.neusoft.hotelmanagementsystem.test;

import com.neusoft.hotelmanagementsystem.HotelmanagementsystemApplication;
import com.neusoft.hotelmanagementsystem.entity.Dept;
import com.neusoft.hotelmanagementsystem.mapper.DeptMapper;
import com.neusoft.hotelmanagementsystem.service.DeptService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {HotelmanagementsystemApplication.class})
public class TestMyBatisDept {

    /**
     * 属性注入： 通过Spring容器给实例对象当中的属性进行赋值操作
     * 非对象类型的 - @Value
     * 对象类型 - @Autowired 根据数据类型进行属性的赋值操作     @Qualifier("")
     *           @Resource  根据名称 - 默认的名称（首字母小写）
     */
    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void testInsertDept(){
        Dept dept = Dept.builder().deptName("市场部").status(1).build();
        deptMapper.insertDept(dept);
    }

    @Test
    public void testSelect(){
        Dept dept = deptMapper.selectDeptByDeptId(10001);
        System.out.println(dept);
    }

    @Autowired
    @Qualifier(value = "deptServiceImpl2")
    private DeptService deptService;

    @Test
    public void testAutowired(){
        Dept dept = Dept.builder().deptName("市场部").status(1).build();
        deptService.addDept(dept);
    }
}
