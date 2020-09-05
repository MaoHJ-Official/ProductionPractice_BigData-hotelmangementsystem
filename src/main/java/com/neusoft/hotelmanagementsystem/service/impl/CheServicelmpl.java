package com.neusoft.hotelmanagementsystem.service.impl;
import com.neusoft.hotelmanagementsystem.entity.Che;
import com.neusoft.hotelmanagementsystem.entity.Emp;
import com.neusoft.hotelmanagementsystem.mapper.CheMapper;
import com.neusoft.hotelmanagementsystem.mapper.EmpMapper;
import com.neusoft.hotelmanagementsystem.service.CheService;
import com.neusoft.hotelmanagementsystem.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
@Service("cheService")
public class CheServicelmpl implements CheService{
    @Autowired
    private CheMapper cheMapper;

    @Override
    public List<Che> queryAllChe() {
        this.cheMapper.deleteAllChe();
        this.cheMapper.insertChe();
        return this.cheMapper.queryAllChe();
    }

    @Override
    public void deleteChe(Integer OrderId) throws NoSuchAlgorithmException {
        this.cheMapper.deleteCheByOrderId(OrderId);
    }

    @Override
    public Che queryCheByOrderId(Integer OrderId) { return this.cheMapper.selectCheByOrderId(OrderId);
    }



    @Override
    public void addChe() throws NoSuchAlgorithmException {
//        设置属性
        //che.setStatus(1);
        //che.setCheckInDate(new Date());

        this.cheMapper.insertChe();
//        hr - 都是员工 - 部门是人事部门的
//        如果是人事部门的员工需要增加到hr表中 -- hr属性 deptid- 数据库自动生成的
//        if (10001 == emp.getDeptId()) {
//            String password = MD5Util.getMD5String(MD5Util.getMD5String("123456"));
////            构建HR对象
//            Hr hr = Hr.builder().empId(emp.getEmpId()).empPass(password).build();
//            hrMapper.insertHr(hr);
//        }
    }
}
