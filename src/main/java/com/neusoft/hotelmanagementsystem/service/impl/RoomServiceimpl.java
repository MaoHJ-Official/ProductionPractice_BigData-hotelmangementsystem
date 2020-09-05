package com.neusoft.hotelmanagementsystem.service.impl;

import com.neusoft.hotelmanagementsystem.entity.Room;
import com.neusoft.hotelmanagementsystem.mapper.CusMapper;
import com.neusoft.hotelmanagementsystem.mapper.RoomMapper;
import com.neusoft.hotelmanagementsystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roomService")
public class RoomServiceimpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public void addRoom(Room room) {
        System.out.println("deptServiceImpl中的方法");
//        设置部门状态
        room.setStatus(0);
//        调用方法，实现新设部门的功能 - 向数据库中对应的表插入数据
        this.roomMapper.insertRoom(room);
    }

    @Override
    public void updateRoomType(Room room) {
        this.roomMapper.updateRoomType(room);
    }

    @Override
    public void updateRoomStatus(Room room) {
        this.roomMapper.updateRoomStatus(room);
    }

    @Override
    public Room queryRoomByRoomId(Integer roomId) {
        return this.roomMapper.selectRoomByRoomId(roomId);
    }

    @Override
    public String deleteRoom(Integer roomid) {
        //需要判断撤销的房间是否是已预订和已入住状态
        String msg = "该房间已被预订或入住，无法撤销";
        Room room = this.queryRoomByRoomId(roomid);
        if(room.getStatus()==0) {
            this.roomMapper.deleteRoomByRoomId(roomid);
            msg = "成功";

        }
        return msg;
    }

    @Override
    public List<Room> queryALLRooms(Room room) {
        return this.roomMapper.selectAllRoom(room);
    }
}