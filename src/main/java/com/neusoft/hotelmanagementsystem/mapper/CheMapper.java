package com.neusoft.hotelmanagementsystem.mapper;

import com.neusoft.hotelmanagementsystem.entity.Che;
import com.neusoft.hotelmanagementsystem.entity.Custom;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface CheMapper {
    @Insert(
            "INSERT into che SELECT orderid,r.roomid,cusname,cdate,leavedate,status FROM custom as c, room as r WHERE c.roomid=r.roomid "
    )
//    获取数据库自动增加的字段的值
//    keyColumn: 数据库中自增字段的名称
//    keyProperty: 实体类中自增字段的属性名
//    before: 需要执行的SQL语句是否在主SQL（insert）之前执行
//    statement: 需要执行的SQL语句
//    resultType: 返回值的数据类型
    @SelectKey(keyColumn = "orderid", keyProperty = "OrderId", before = false,
            statement = "SELECT LAST_INSERT_ID()", resultType = Integer.class)
    void insertChe();

    @Select("SELECT OrderId,RoomId,CusName,CheckinDate,LeaveDate,Status " +
            "FROM che WHERE OrderId = #{OrderId} ")
    Che selectCheByOrderId(Integer OrderId);

    @Delete("UPDATE che SET Status = 0 WHERE OrderId = #{OrderId} ")
    void deleteCheByOrderId(Integer OrderId);

    @Select("SELECT OrderId,RoomId,CusName,CheckinDate,LeaveDate,Status FROM che")
    List<Che> queryAllChe();

    @Update("UPDATE che SET RoomId = #{RoomId}, CusName = #{CusName}, CheckinDate = #{CheckinDate}," +
            "LeaveDate = #{LeaveDate}, Status = #{Status} WHERE OrderId = #{OrderId} ")
    void updateChe(Che che);

    @Delete("DELETE FROM che")
    void deleteAllChe();
}
