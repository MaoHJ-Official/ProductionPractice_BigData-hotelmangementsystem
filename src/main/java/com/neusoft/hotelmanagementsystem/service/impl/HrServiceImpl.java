package com.neusoft.hotelmanagementsystem.service.impl;

import com.neusoft.hotelmanagementsystem.entity.Hr;
import com.neusoft.hotelmanagementsystem.mapper.HrMapper;
import com.neusoft.hotelmanagementsystem.service.HrService;
import com.neusoft.hotelmanagementsystem.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service("hrService")
public class HrServiceImpl implements HrService {

    @Autowired
    private HrMapper hrMapper;

    @Override
    public Integer login(Hr hr) throws NoSuchAlgorithmException {
        Hr hrDB = this.hrMapper.selectHrByEmpId(hr.getEmpId());
//        根据用户编号查询用户，返回值是null 表示不存在该用户，向上返回对应的代码2
        if (null == hrDB) {
            return 2;
        }
//        数据库中的密码和前台传来的密码一致 - 登录成功的
//        加密前台传来的密码字符串
        String password = MD5Util.getMD5String(MD5Util.getMD5String(hr.getEmpPass()));
        if (hrDB.getEmpPass().equals(password)) {
            return 1;
        }
        return 0;
    }
}
