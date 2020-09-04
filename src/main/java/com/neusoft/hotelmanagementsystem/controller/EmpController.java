package com.neusoft.hotelmanagementsystem.controller;

import com.neusoft.hotelmanagementsystem.entity.Dept;
import com.neusoft.hotelmanagementsystem.entity.Emp;
import com.neusoft.hotelmanagementsystem.service.DeptService;
import com.neusoft.hotelmanagementsystem.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private DeptService deptService;

//    将String类型的时间内容转换成为Date类型的数据  -- 哪里需要使用该转换，就在哪里去写这个方法
//    写在一个controller当中，然后需要的controller去继承这个controller
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(true);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

    @GetMapping(path = "/preAdd")
    public String preAdd(Model model){
        Dept dept = Dept.builder().status(1).build(); // 创建出查询的条件 -- 查询所有正在使用中的部门信息
        List<Dept> depts = this.deptService.queryAllDepts(dept);
        model.addAttribute("depts", depts);
        return "addEmp";
    }

    @PostMapping(path = "/add")
    public String addEmp(Emp emp){
        System.out.println("新入职的员工信息是：" + emp);
        try {
            this.empService.addEmp(emp);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
