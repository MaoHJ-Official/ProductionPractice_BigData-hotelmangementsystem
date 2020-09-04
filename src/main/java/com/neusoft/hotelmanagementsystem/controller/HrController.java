package com.neusoft.hotelmanagementsystem.controller;

import com.neusoft.hotelmanagementsystem.entity.Hr;
import com.neusoft.hotelmanagementsystem.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/hr")
public class HrController {

    @Autowired
    private HrService hrService;

    @PostMapping(path = "/login")
    public String login(Hr hr, Model model, HttpSession session) throws NoSuchAlgorithmException {
        System.out.println("" + hr);
        Integer login = this.hrService.login(hr);
        if (login==1) {
            session.setAttribute("hr", hr.getEmpId());
            return "index";
        }
        String msg = "不存在该用户";
        if (login == 0) {
            msg = "密码或者编号错误";
        }
        model.addAttribute("msg", msg);
        return "login";
    }
}
