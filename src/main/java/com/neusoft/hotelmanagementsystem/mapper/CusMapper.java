package com.neusoft.hotelmanagementsystem.mapper;

import com.neusoft.hotelmanagementsystem.entity.Che;
import com.neusoft.hotelmanagementsystem.entity.Custom;
import com.neusoft.hotelmanagementsystem.entity.Room;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

@Mapper
public interface CusMapper {

    @Select("SELECT * FROM room WHERE status = 0 and roomtype = #{roomType}")
    List<Room> seRoom(Integer roomType);

    @Update("UPDATE room SET status = 1 WHERE roomid = #{roomId}")
    Integer preRoom(Integer roomId);

    @Insert("INSERT INTO custom(orderid, cusname, cusphone, cdate, leavedate, roomtype, roomid)" +
            "VALUES (#{orderId} ,#{cusName} ,#{cusPhone} ,#{cDate} ,#{leaveDate} ,#{roomType} ,#{roomId} )")
    void insertCus(Custom custom);

    @Update("UPDATE custom SET leavedate = #{leaveDate}  WHERE roomid = #{roomId}")
    Integer checkout(Custom custom);

    @Update("UPDATE custom SET leavedate = #{leaveDate}  WHERE orderid = #{custom.orderId} ")
    void checkout1(Custom custom, Date leaveDate);

    @Select("SELECT orderid, cusname, cusphone, cdate, leavedate, roomtype, roomid " +
            "FROM custom WHERE roomid = #{roomId}")
    List<Custom> selectCusByRoomId(Integer roomId);
}
