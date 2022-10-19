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
