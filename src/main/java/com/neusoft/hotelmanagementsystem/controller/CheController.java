package com.neusoft.hotelmanagementsystem.controller;
import com.neusoft.hotelmanagementsystem.entity.Che;
import com.neusoft.hotelmanagementsystem.entity.Emp;
import com.neusoft.hotelmanagementsystem.service.CheService;
import com.neusoft.hotelmanagementsystem.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Controller
@RequestMapping(path = "/che")
public class CheController {
    @Autowired
    private CheService cheService;

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

        List<Che> ches = this.cheService.queryAllChe();
        model.addAttribute("ches", ches);
        return "cheList";
    }

    @GetMapping(path = "/preAdd")
    public String toAdd(){
        return "addChe";
    }

    @RequestMapping(path = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public String addCheInfo(){
        System.out.println("入住登记");
        try {
            this.cheService.addChe();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "redirect:/che/showList";
    }


    // 修改的前置方法是- 目的是为了查询出需要修改的部门信息，显示在页面上。
//    @GetMapping(path = "/preUpdate/{OrderId}")
//    public String preUpdate(@PathVariable("OrderId") Integer empId, Model model){
//        System.out.println("当前需要修改信息的部门是：" + empId);
//
//        Emp emp = this.empService.queryEmpByEmptId(empId);
//
//        model.addAttribute("emp", emp);
//
//        return "updateEmp";
//    }

//    @PostMapping(path = "/update")
//    public String updateEmp(Emp emp){
//        System.out.println("更改后的信息是：" + emp);
//        this.empService.updateEmp(emp);
//        return "redirect:/emp/showList";
//    }
}
