package com.neusoft.hotelmanagementsystem.service;

import com.neusoft.hotelmanagementsystem.entity.Hr;

import java.security.NoSuchAlgorithmException;

public interface HrService {

    /**
     * 登录的方法
     * @param hr 前台传来的登录的信息
     * @return 登录的结果
     *          0： 表示密码错误
     *          1： 表示登录成功
     *          2： 表示不存在该用户
     */
    Integer login(Hr hr) throws NoSuchAlgorithmException;
}
