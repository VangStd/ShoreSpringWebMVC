/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.service.impl;

import com.java.entity.AdminEntity;
import com.java.repository.AdminRepository;
import com.java.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyqua
 */
@Service
public class AdminServiceimpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public int getCountAdminByUserName(String UserName) {
        return adminRepository.getCountAdminByUserName(UserName);
    }

    @Override
    public AdminEntity findByUserName(String UserName) {
        return adminRepository.findByUserName(UserName);
    }

    @Override
    public String getAvatarByUsername(String username) {
        return adminRepository.getAvatarByUsername(username);
    }

    @Override
    public void save(AdminEntity ae) {
        adminRepository.save(ae);
    }

}
