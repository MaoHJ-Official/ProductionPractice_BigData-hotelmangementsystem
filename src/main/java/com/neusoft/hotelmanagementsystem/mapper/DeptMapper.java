package com.neusoft.hotelmanagementsystem.mapper;

import com.neusoft.hotelmanagementsystem.entity.Dept;
import com.neusoft.hotelmanagementsystem.provider.DeptSQLProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Insert("INSERT INTO dept(deptname, status) VALUES(#{deptName}, #{status})")
    void insertDept(Dept dept);

    @Select("SELECT deptid, deptname, status FROM dept WHERE deptid = #{deptId} ")
    @Results(id = "withEmps", value = {
            @Result(id = true, column = "deptid", property = "deptId"),
            @Result(column = "deptname", property = "deptName"),
            @Result(column = "status", property = "status"),
            @Result(column = "deptid", property = "empList",
            many = @Many(select = "EmpMapper.selectEmpsByDeptId",
                        fetchType = FetchType.LAZY))
    })
    Dept selectDeptByDeptId(Integer deptId);

//    @Select("SELECT deptid, deptname, status FROM dept")
    @SelectProvider(type = DeptSQLProvider.class,  method = "createSelectAllSQL")
    List<Dept> selectAllDepts(Dept dept);

//    type属性指向提供者类的字节码对象，method属性确定类中具体的方法
//    @Update("UPDATE dept SET deptname = #{deptName}, status = #{status} WHERE deptid = #{deptId} ")
    @UpdateProvider(type = DeptSQLProvider.class, method = "createUpdateSQL")
    void updateDept(Dept dept);

    @Delete("UPDATE dept SET status = 0 WHERE deptid = #{deptId} ")
    void deleteDeptByDeptId(Integer deptId);
}
