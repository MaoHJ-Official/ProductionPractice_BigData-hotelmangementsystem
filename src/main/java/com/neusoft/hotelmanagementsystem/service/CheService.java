package com.neusoft.hotelmanagementsystem.service;
import com.neusoft.hotelmanagementsystem.entity.Che;
import com.neusoft.hotelmanagementsystem.entity.Emp;

import java.security.NoSuchAlgorithmException;
import java.util.List;
public interface CheService {
    List<Che> queryAllChe();

    void addChe() throws NoSuchAlgorithmException; // alt + enter

    void deleteChe(Integer OrderId) throws NoSuchAlgorithmException;

    Che queryCheByOrderId(Integer OrderId);


}
