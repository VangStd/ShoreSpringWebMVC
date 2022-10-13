/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.service;

import com.java.entity.AdminEntity;

/**
 *
 * @author kyqua
 */
public interface AdminService {

    int getCountAdminByUserName(String UserName);
    
    String getAvatarByUsername(String username);

    AdminEntity findByUserName(String UserName);
    
    void save(AdminEntity adminEntity);
}
