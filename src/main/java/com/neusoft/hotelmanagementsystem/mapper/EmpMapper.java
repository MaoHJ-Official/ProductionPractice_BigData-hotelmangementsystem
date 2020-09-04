package com.neusoft.hotelmanagementsystem.mapper;

import com.neusoft.hotelmanagementsystem.entity.Emp;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface EmpMapper {

    @Insert("insert into emp(empid,empname,gender,birthday,hiredate,job,status,empphoto) " +
            "values(#{empId} ,#{empName} ,#{gender} ,#{birthday} ,#{hireDate} ,#{job} ,#{status} ,#{empPhoto} )")
//    获取数据库自动增加的字段的值
//    keyColumn: 数据库中自增字段的名称
//    keyProperty: 实体类中自增字段的属性名
//    before: 需要执行的SQL语句是否在主SQL（insert）之前执行
//    statement: 需要执行的SQL语句
//    resultType: 返回值的数据类型
    @SelectKey(keyColumn = "empid", keyProperty = "empId", before = false,
            statement = "SELECT LAST_INSERT_ID()", resultType = Integer.class)
    void insertEmp(Emp emp);

    @Select("SELECT empid, empname, gender, birthday, hiredate, job, status, empphoto " +
            "FROM emp WHERE empid = #{empId} ")
    Emp selectEmpByEmpId(Integer empId);

    @Delete("UPDATE emp SET status = 0 WHERE empid = #{empId} ")
    void deleteEmpByEmpId(Integer empId);

    @Select("select empid, empname, gender, birthday, hiredate, job, status, empphoto from emp")
    List<Emp> queryAllEmps();

    @Update("UPDATE emp SET empname = #{empName}, gender = #{gender}, birthday = #{birthday}," +
            "hiredate=#{hireDate},job = #{job},status = #{status} empphoto = #{empPhoto},WHERE empid = #{empId} ")
    void updateEmp(Emp emp);

}
