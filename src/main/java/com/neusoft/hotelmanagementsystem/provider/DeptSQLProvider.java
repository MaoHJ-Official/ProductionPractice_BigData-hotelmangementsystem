package com.neusoft.hotelmanagementsystem.provider;

import com.neusoft.hotelmanagementsystem.entity.Dept;
import org.apache.ibatis.jdbc.SQL;

public class DeptSQLProvider {

    public String createUpdateSQL(Dept dept){
//        return new SQL()
//                .UPDATE("dept")
//                .SET("deptname = #{deptName}")
//                .SET("status = #{status}")
//                .WHERE("deptid = #{deptId}")
//                .toString();
        return new SQL(){{
            UPDATE("dept");
            if (null != dept.getDeptName() && !"".equals(dept.getDeptName())){
                SET("deptname = #{deptName}");
            }
            if (null != dept.getStatus()) {
                SET("status = #{status}");
            }
            WHERE("deptid = #{deptId}");
        }}
        .toString();
    }

    public String createSelectAllSQL(Dept dept){
        return new SQL(){{
            SELECT("deptid, deptname, status");
            FROM("dept");
            if (null != dept.getDeptId()){
                WHERE("deptid = #{deptId}");
            }
            if (null != dept.getDeptName() && !"".equals(dept.getDeptName())){
                WHERE("deptname = #{deptName}");
            }
            if (null != dept.getStatus()) {
                WHERE("status = #{status}");
            }
        }}
        .toString();
    }
}
