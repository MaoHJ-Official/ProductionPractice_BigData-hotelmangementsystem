package com.neusoft.hotelmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping(path = "/")
    public String welcome(){
        return "login";
    }

    @GetMapping(path = "/login")
    public String toLogin(){
        return "login";
    }
}
