package com.neusoft.hotelmanagementsystem.service;

import com.neusoft.hotelmanagementsystem.entity.Room;

import java.util.List;

public interface RoomService {

    void addRoom(Room room);

    void updateRoomType(Room room);
    void updateRoomStatus(Room room);

    Room queryRoomByRoomId(Integer roomid);

    String deleteRoom(Integer roomid);

    List<Room> queryALLRooms(Room room);
}
