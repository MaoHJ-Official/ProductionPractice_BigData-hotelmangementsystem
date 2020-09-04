package com.neusoft.hotelmanagementsystem.mapper;

import com.neusoft.hotelmanagementsystem.entity.Hr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HrMapper {

    @Insert("insert into hr values(#{empId} ,#{empPass} )")
    void insertHr(Hr hr);

    Hr selectHrByEmpId(Integer empId);
}
