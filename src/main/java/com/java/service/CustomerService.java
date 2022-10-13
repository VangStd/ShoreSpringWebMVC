/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.service;

import com.java.entity.CustomerEntity;
import java.util.List;

/**
 *
 * @author kyqua
 */
public interface CustomerService {

    /**
     *
     * @param CusID
     * @return new object Customer
     */
    CustomerEntity findById(long CusID);

    /**
     *
     * @return list Customer
     */
    List<CustomerEntity> findAll();

    void save(CustomerEntity customer);

    void deleteById(long CusID);

    int checkEmail(String Email);

    long getIdByUserName(String UserName);
    
    String getUsernameById(long id);

    int getCountByCodeForgot(String CodeForgot);
    
    int getCountCustomer();
    
    String getAvatarByUserName(String username);
    
    List<CustomerEntity> getTopNewCustomer();

    void updatePasswordById(CustomerEntity customer);

    int checkByUserName(String UserName);

    void updateCodeByEmail(String Code, String Email);

    void updatePasswordForgot(String pass, String Email);
}
