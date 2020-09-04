package com.neusoft.hotelmanagementsystem.controller;

import com.neusoft.hotelmanagementsystem.entity.Dept;
import com.neusoft.hotelmanagementsystem.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(path = "/dept")
public class DeptController {

    @Resource
    private DeptService deptService;

//    跳转到addDept页面上
    @GetMapping(path = "/preAdd")
    public String toAdd(){
        return "addDept";
    }
//    PostMapping(path = "") = RequestMapping(path = "", method = RequestMethod.POST)
    @PostMapping(path = "/add")
    public String addDept(Dept dept) {
        this.deptService.addDept(dept);
//        确定返回的视图 - 页面
        return "redirect:/dept/showList"; // 使用重定向的方式重新发起请求，请求另一个方法的执行
//        return "forward:/dept/showList"; // 使用请求转发的方式，将当前的请求转发给另一个方法，使得另一个方法执行。
    }

//    Spring MVC中，如果传来的数据的名称和参数中的实体类中的属性名称完全一致，可以自动映射成为一个实例对象
    @RequestMapping(path = "/showList", method = {RequestMethod.GET, RequestMethod.POST})
    public String showList(Model model, Dept dept) {
        if (dept == null) {
            dept = new Dept();
        }
        List<Dept> depts = this.deptService.queryAllDepts(dept);
        model.addAttribute("depts", depts);
        return "deptList";
    }

    @GetMapping(path = "/showInfo")
    public String showInfo(Integer deptId, Model model){
        System.out.println("需要查询的部门编号是：" + deptId);
        Dept dept = this.deptService.queryDeptByDeptId(deptId);
        model.addAttribute("dept", dept);
        System.out.println(dept);
        return "deptInfo";
    }

    // 修改的前置方法是- 目的是为了查询出需要修改的部门信息，显示在页面上。
    @GetMapping(path = "/preUpdate/{deptId}")
    public String preUpdate(@PathVariable("deptId") Integer deptId, Model model){
        System.out.println("当前需要修改信息的部门是：" + deptId);

        Dept dept = this.deptService.queryDeptByDeptId(deptId);

        model.addAttribute("dept", dept);

        return "updateDept";
    }

    @PostMapping(path = "/update")
    public String updateDept(Dept dept){
        System.out.println("更改后的信息是：" + dept);
        this.deptService.updateDept(dept);
        return "redirect:/dept/showList";
    }

    // 撤除部门需要条件 - 当前部门下没有员工
    @GetMapping(path = "/disabled/{deptId}")
    public @ResponseBody String disableDept(@PathVariable("deptId") Integer deptId, Model model){
        System.out.println("需要撤除的部门是:" + deptId);
        String result = this.deptService.deleteDept(deptId);
        return result;
    }
}
