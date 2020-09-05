package com.neusoft.hotelmanagementsystem.provider;

import com.neusoft.hotelmanagementsystem.entity.Room;
import org.apache.ibatis.jdbc.SQL;

public class RoomSQLProvider {
        public String createSelectAllSQL(Room room){
            return new SQL(){{
                SELECT("roomid,status,roomtype");
                FROM("room");
                if(null!=room.getRoomId()){
                    WHERE("roomid= #{roomId}");
                }
                if(null!=room.getStatus()){
                    WHERE("status=#{status}");
                }
                if(null!=room.getRoomType()){
                    WHERE("roomtype=#{roomType}");
                }
            }}.toString();
        }
}
