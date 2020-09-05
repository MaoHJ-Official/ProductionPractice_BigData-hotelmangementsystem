package com.neusoft.hotelmanagementsystem.service;

import com.neusoft.hotelmanagementsystem.entity.Custom;
import com.neusoft.hotelmanagementsystem.entity.Room;

import java.util.Date;

public interface CusService {

    void addCus(Custom custom);

    Integer preRoom(Integer roomType);

    void checkoutDate(Custom custom);

    Custom selectCusByRoomId(Integer roomId);

    public void checkout1Date(Custom custom, Date leaveDate);
}
