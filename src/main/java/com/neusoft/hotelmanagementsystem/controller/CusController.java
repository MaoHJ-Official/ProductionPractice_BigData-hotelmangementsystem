package com.neusoft.hotelmanagementsystem.controller;

import com.neusoft.hotelmanagementsystem.entity.Custom;
import com.neusoft.hotelmanagementsystem.service.CusService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping(path = "/cus")
public class CusController {

    @Resource CusService cusService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(true);
        dataBinder.registerCustomEditor(Data.class,new CustomDateEditor(format,true));
    }

    @GetMapping(path = "/preAdd")
    public String toPre(){

        System.out.println("preRoom");
        return "preRoom";
    }

    @PostMapping(path = "/add")
    public String preRoom(Custom custom){
        System.out.println(custom);
        System.out.println("addCus");

        Integer roomid;
        roomid = this.cusService.preRoom(custom.getRoomType());
        if (roomid != -1) {
            custom.setRoomId(roomid);
            this.cusService.addCus(custom);
            return "index";
        }else {
            return "hotelFailed";
        }
    }

}