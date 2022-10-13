/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.repository;

import com.java.entity.WhisListEntity;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kyqua
 */
public interface WhisListRepository extends JpaRepository<WhisListEntity, Long> {

    @Query(value = "select count(*) from WhisList where ProID = ?1 and CusID =?2", nativeQuery = true)
    int getCountByProidAndCusid(long ProID, long CusID);

    @Query(value = "select ID,ProID,CusID,Status from WhisList where CusID = ?1", nativeQuery = true)
    List<WhisListEntity> findByCusID(long CusID);

    @Transactional
    @Modifying
    @Query(value = "delete from WhisList where ProID = ?1 and CusID =?2", nativeQuery = true)
    void deleteByProIDandCusID(long ProID, long CusID);
}
