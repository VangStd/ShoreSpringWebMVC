/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.repository;

import com.java.entity.ShopCartEntity;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kyqua
 */
public interface ShopCartRepository extends JpaRepository<ShopCartEntity, Long> {

    @Query(value = "select ID,ProID,CusID,Quantity,Dates,Status from ShopCart where Status = 'Active' and CusID = ?1", nativeQuery = true)
    List<ShopCartEntity> findAllByStatus(long CusID);

    @Query(value = "select ID,ProID,CusID,Quantity,Dates,Status from ShopCart where Status = 'Active' and ProID =?1 and CusID = ?2", nativeQuery = true)
    ShopCartEntity findByProIDandCusID(long ProID, long CusID);

    @Query(value = "select count(*) from ShopCart where ProID = ?1 and CusID = ?2 and Status = 'Active'", nativeQuery = true)
    int getCountByProidAndCusid(long ProID, long CusID);

    @Query(value = "select count(*) from ShopCart where CusID = ?1 and Status = 'Active'", nativeQuery = true)
    int getCountByCusID(long CusID);

    @Transactional
    @Modifying
    @Query(value = "update ShopCart set Quantity += 1 where ProID = ?1 and CusID = ?2", nativeQuery = true)
    void updateQuantityByProidAndCusid(long ProID, long CusID);

    @Transactional
    @Modifying
    @Query(value = "update ShopCart set Quantity =?1 where ProID = ?2 and CusID = ?3", nativeQuery = true)
    void updateQuantityByAjax(int Quantity, long ProID, long CusID);

    @Transactional
    @Modifying
    @Query(value = "update ShopCart set Status = 'Deactive'where ID = ?1", nativeQuery = true)
    void updateStatusById(long ID);

    @Transactional
    @Modifying
    @Query(value = "update ShopCart set Status = 'Deactive'where CusID = ?1", nativeQuery = true)
    void updateStatusByCusid(long CusID);

    @Transactional
    @Modifying
    @Query(value = "delete from ShopCart where ID = ?1 and Status ='Deactive'", nativeQuery = true)
    void deleteByIdAndStatus(long ID);

    @Transactional
    @Modifying
    @Query(value = "delete from ShopCart where CusID = ?1 and Status ='Deactive'", nativeQuery = true)
    void deleteByCusidAndStatus(long CusID);

    @Transactional
    @Modifying
    @Query(value = "update ShopCart set Status = 'Deactive'where CusID = ?1 and ProID =?2", nativeQuery = true)
    void updateStatusByCuidandProid(long CusID, long ProID);
}
