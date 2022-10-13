/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.repository;

import com.java.entity.CustomerEntity;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kyqua
 */
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query(value = "select PassWord from Customer where UserName = ?1", nativeQuery = true)
    String getPassByUserName(String UserName);

    @Query(value = "select UserName from Customer where UserName =?1", nativeQuery = true)
    String getUserNameByUserName(String UserName);

    @Query(value = "select COUNT(CusID) from Customer", nativeQuery = true)
    int getCountCustomer();

    @Query(value = "select Email from Customer where Email =?1", nativeQuery = true)
    String getEmailByEmail(String Email);

    @Query(value = "select CusID from Customer where UserName = ?1", nativeQuery = true)
    long getIdByUserName(String UserName);

    @Query(value = "select UserName from Customer where CusID = ?1", nativeQuery = true)
    String getUsernameById(long id);

    @Query(value = "select Count(CodeForgot) from Customer where CodeForgot =?1", nativeQuery = true)
    int getCountByCodeForgot(String CodeForgot);

    @Query(value = "select Avatar from Customer where UserName = ?1", nativeQuery = true)
    String getAvatarByUserName(String username);

    @Query(value = "select top 5 CusID,FullName,Phone,Address,Email,Gender,UserName,PassWord,CodeForgot,Avatar from Customer order by CusID desc", nativeQuery = true)
    List<CustomerEntity> getTopNewCustomer();

    @Transactional
    @Modifying
    @Query(value = "update Customer set PassWord = ?1 where CusID = ?2", nativeQuery = true)
    void updatePasswordById(String Password, Long CusID);

    @Transactional
    @Modifying
    @Query(value = "update Customer set CodeForgot = ?1 where Email = ?2", nativeQuery = true)
    void updateCodeByEmail(String Code, String Email);

    @Transactional
    @Modifying
    @Query(value = "update Customer set CodeForgot = 'null',PassWord = ?1 where Email = ?2", nativeQuery = true)
    void updatePasswordForgot(String pass, String Email);

}
