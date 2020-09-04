package com.neusoft.hotelmanagementsystem.controller;

import com.neusoft.hotelmanagementsystem.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping(path = "/thy")
public class ThymeleafController {

    @Autowired
    private DeptService deptService;

    @GetMapping(path = "/first")
    public String firstPage(Model model){
        model.addAttribute("info", "page info");

        model.addAttribute("current", new Date());

//        List<Dept> depts = this.deptService.queryAllDepts(dept);

//        model.addAttribute("depts", depts);

        return "firstThymeleaf";
    }

    @GetMapping(path = "/getInfo")
    public String getInfo(Integer uid){
        System.out.println("uid = " + uid);
        return "firstThymeleaf";
    }

    @GetMapping(path = "/getREST/{uid}")
    public String getRESTInfo(@PathVariable("uid") Integer uid){
        System.out.println("uid = " + uid);
        return "firstThymeleaf";
    }
}
