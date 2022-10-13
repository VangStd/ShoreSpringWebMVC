/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.repository;

import com.java.entity.ImageProductEntity;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kyqua
 */
public interface ImgProductRepository extends JpaRepository<ImageProductEntity, Long> {

    @Query(value = "select ID,ProID,Image1,Image2,Image3,Image4,Image5 from ImageProduct where ProID =?1 ", nativeQuery = true)
    ImageProductEntity findByProId(long ProID);

    @Transactional
    @Modifying
    @Query(value = "delete from ImageProduct where ProID = ?1", nativeQuery = true)
    void deleteByProID(Long ProID);
}
