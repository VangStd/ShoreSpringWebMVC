/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.repository;

import com.java.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kyqua
 */
public interface AdminRepository extends JpaRepository<AdminEntity, Long> {

    @Query(value = "select ad.PassWord from Admin ad where ad.UserName= ?1", nativeQuery = true)
    String getPassByUserName(String UserName);

    @Query(value = "select ID,FullName,Address,Phone,Email,UserName,PassWord,Avatar from Admin where UserName = ?1", nativeQuery = true)
    AdminEntity findByUsername(String Username);

    @Query(value = "select count(UserName) from Admin where UserName = ?1", nativeQuery = true)
    int getCountAdminByUserName(String UserName);

    @Query(value = "select Avatar from Admin where UserName = ?1", nativeQuery = true)
    String getAvatarByUsername(String username);

    @Query(value = "select ID,FullName,Address,Phone,Email,UserName,PassWord,Avatar from Admin where UserName = ?1", nativeQuery = true)
    AdminEntity findByUserName(String UserName);

    @Query(value = "select count(Email) from Admin where Email = ?1", nativeQuery = true)
    int getCountByEmail(String Email);
}
