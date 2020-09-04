package com.neusoft.hotelmanagementsystem.controller;

import com.neusoft.hotelmanagementsystem.entity.Emp;
import com.neusoft.hotelmanagementsystem.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

//    将String类型的时间内容转换成为Date类型的数据  -- 哪里需要使用该转换，就在哪里去写这个方法
//    写在一个controller当中，然后需要的controller去继承这个controller
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(true);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

    @RequestMapping(path = "/showList", method = {RequestMethod.GET, RequestMethod.POST})
    public String showEmpList(Model model){
        List<Emp> emps = this.empService.queryAllEmps();
        model.addAttribute("emps", emps);
        return "empList";
    }

    @GetMapping(path = "/preAdd")
    public String toAdd(){
        return "addEmp";
    }

    @RequestMapping(path = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public String addEmployee(Emp emp){
        System.out.println("新入职的员工信息是：" + emp);
        try {
            this.empService.addEmp(emp);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "redirect:/emp/showList";
    }

    // 修改的前置方法是- 目的是为了查询出需要修改的部门信息，显示在页面上。
    @GetMapping(path = "/preUpdate/{empId}")
    public String preUpdate(@PathVariable("empId") Integer empId, Model model){
        System.out.println("当前需要修改信息的部门是：" + empId);

        Emp emp = this.empService.queryEmpByEmptId(empId);

        model.addAttribute("emp", emp);

        return "updateEmp";
    }

    @PostMapping(path = "/update")
    public String updateDept(Emp emp){
        System.out.println("更改后的信息是：" + emp);
        this.empService.updateEmp(emp);
        return "redirect:/emp/showList";
    }
}
