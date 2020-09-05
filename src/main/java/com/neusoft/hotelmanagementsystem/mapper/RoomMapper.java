package com.neusoft.hotelmanagementsystem.mapper;


import com.neusoft.hotelmanagementsystem.entity.Room;
import com.neusoft.hotelmanagementsystem.provider.DeptSQLProvider;
import com.neusoft.hotelmanagementsystem.provider.RoomSQLProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface RoomMapper {
    @Insert("INSERT INTO room(roomid,status,roomtype) VALUES(#{roomId} ,#{status} ,#{roomType}  )")
    void insertRoom(Room room);

    @SelectProvider(type = RoomSQLProvider.class,method = "createSelectAllSQL")
    List<Room>selectAllRoom(Room room);

    @Delete("DELETE FROM room WHERE roomid = #{roomId}")
    void deleteRoomByRoomId(Integer roomId);

    @Select(("SELECT roomid,status,roomtype From room WHERE roomid=#{roomId} "))
    Room selectRoomByRoomId(Integer roomId);

    @Update("UPDATE room SET roomtype = #{roomType}  WHERE roomid =#{roomId} ")
    void updateRoomType(Room room);

    @Update("UPDATE room SET status= #{status}   WHERE roomid =#{roomId} ")
    void updateRoomStatus(Room room);
}
