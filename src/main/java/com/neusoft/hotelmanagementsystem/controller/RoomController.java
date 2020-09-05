package com.neusoft.hotelmanagementsystem.controller;

import com.neusoft.hotelmanagementsystem.entity.Custom;
import com.neusoft.hotelmanagementsystem.entity.Room;
import com.neusoft.hotelmanagementsystem.service.CusService;
import com.neusoft.hotelmanagementsystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path="/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private CusService cusService;

    //    跳转到addDept页面上
    @GetMapping(path = "/preAdd")
    public String toAdd() {
        return "addRoom";
    }

    @PostMapping(path = "/add")
    public String addRoom(Room room) {
        this.roomService.addRoom(room);
        //     确定返回的视图 - 页面
        return "redirect:/room/showList"; // 使用重定向的方式重新发起请求，请求另一个方法的执行
    }

    //  Spring MVC中，如果传来的数据的名称和参数中的实体类中的属性名称完全一致，可以自动映射成为一个实例对象
    @RequestMapping(path = "/showList", method = {RequestMethod.GET, RequestMethod.POST})
    public String showList(Model model, Room room) {
        if (room == null) {
            room = new Room();
        }
        List<Room> rooms = this.roomService.queryALLRooms(room);
        model.addAttribute("rooms", rooms);
        return "roomList";
    }

    // 修改的前置方法是- 目的是为了查询出需要修改的部门信息，显示在页面上。
    @GetMapping(path = "/preUpdate/{roomId}")
    public String preUpdate(@PathVariable("roomId") Integer roomId, Model model){
        System.out.println("当前需要修改信息的房间是：" + roomId);

        Room room =this.roomService.queryRoomByRoomId(roomId);

        model.addAttribute("room", room);

        return "updateRoom";
    }

    @PostMapping(path = "/update")
    public String updateRoomType(Room room){
        System.out.println("更改后的信息是：" + room);
        this.roomService.updateRoomType(room);

        return "redirect:/room/showList";
    }

    //撤除房间需要判断房间是否在使用中
    @GetMapping(path = "/disabled/{roomId}")
    public @ResponseBody String disableRoom(@PathVariable("roomId") Integer roomId, Model model){
        System.out.println("需要撤除的部门是:" +roomId );
        String result = this.roomService.deleteRoom(roomId);
        return result;

    }

    @GetMapping(path="/checkout/{roomId}")
    public @ResponseBody void checkoutRoom(@PathVariable("roomId") Integer roomId) throws ParseException {
        Room room = this.roomService.queryRoomByRoomId(roomId);
        Custom cus = this.cusService.selectCusByRoomId(roomId);
        System.out.println(cus);
        SimpleDateFormat sfm = new SimpleDateFormat("yyyy-MM-dd");
        Date da= new Date();
        System.out.println(da);
        room.setStatus(0);



        System.out.println("off");

        this.cusService.checkout1Date(cus ,new Date());
       // this.cusService.checkout1Date(orderId);
        this.roomService.updateRoomStatus(room);

    }

    @GetMapping(path="/checkin/{roomId}")
    public @ResponseBody void checkinRoom(@PathVariable("roomId") Integer roomId){
        Room room = this.roomService.queryRoomByRoomId(roomId);
        room.setStatus(2);
        this.roomService.updateRoomStatus(room);
    }

}
