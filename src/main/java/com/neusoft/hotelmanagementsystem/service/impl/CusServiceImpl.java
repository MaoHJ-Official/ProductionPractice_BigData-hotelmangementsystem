package com.neusoft.hotelmanagementsystem.service.impl;

import com.neusoft.hotelmanagementsystem.entity.Custom;
import com.neusoft.hotelmanagementsystem.entity.Room;
import com.neusoft.hotelmanagementsystem.mapper.CusMapper;
import com.neusoft.hotelmanagementsystem.service.CusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service("cusService")
public class CusServiceImpl implements CusService {

    @Autowired
    private CusMapper cusMapper;


    @Override
    public Integer preRoom(Integer roomType){
        System.out.println("客户预定");
        Integer roomId = -1;
        List<Room> rooms = this.cusMapper.seRoom(roomType);
        System.out.println(rooms);
        System.out.println(rooms.size());
        if (rooms != null && rooms.size()>=1) {
            Room room = rooms.get(0);
            System.out.println(room);
            roomId = room.getRoomId();
            this.cusMapper.preRoom(roomId);
        }
        System.out.println("On");
        return  roomId;
    }

    @Override
    public void checkoutDate(Custom custom) {
        this.cusMapper.checkout(custom);
    }

    @Override
    public void checkout1Date(Custom custom,Date leaveDate) {
        //System.out.println("11");
        //custom.setLeaveDate(leaveDate);
        //System.out.println("22");
        //this.cusMapper.checkout(custom);
        this.cusMapper.checkout1(custom,leaveDate);
    }

    @Override
    public void addCus(Custom custom){

        System.out.println("增加记录");

        this.cusMapper.insertCus(custom);
    }

    @Override
    public Custom selectCusByRoomId(Integer roomId){

        List<Custom> customs = this.cusMapper.selectCusByRoomId(roomId);
        for(int i=0 ;i<customs.size();i++){
            if(customs.get(i).getLeaveDate()==null){
                //System.out.println();
                return customs.get(i);
            }
        }
        return null;
    }

}