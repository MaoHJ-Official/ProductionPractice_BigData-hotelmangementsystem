package com.neusoft.hotelmanagementsystem.mapper;

import com.neusoft.hotelmanagementsystem.entity.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

@Mapper
public interface EmpMapper {

    @Insert("insert into emp(empname,gender,birthday,hiredate,deptid,job,status,empphoto) " +
            "values(#{empName} ,#{gender} ,#{birthday} ,#{hireDate} ,#{deptId} ,#{job} ,#{status} ,#{empPhoto} )")
//    获取数据库自动增加的字段的值
//    keyColumn: 数据库中自增字段的名称
//    keyProperty: 实体类中自增字段的属性名
//    before: 需要执行的SQL语句是否在主SQL（insert）之前执行
//    statement: 需要执行的SQL语句
//    resultType: 返回值的数据类型
    @SelectKey(keyColumn = "empid", keyProperty = "empId", before = false,
        statement = "SELECT LAST_INSERT_ID()", resultType = Integer.class)
    void insertEmp(Emp emp);

    @Select("SELECT empid, empname, gender, birthday, hiredate, deptid, job, status, empphoto " +
            "FROM emp WHERE deptid = #{deptId} ")
    List<Emp> selectEmpsByDeptId(Integer deptId);
}
