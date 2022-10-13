/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.repository;

import com.java.entity.ViewWebsiteEntity;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kyqua
 */
public interface ViewWebsiteRepository extends JpaRepository<ViewWebsiteEntity, Integer> {

    @Query(value = "select Quantity from ViewWebsite", nativeQuery = true)
    int getQuantityViewWebsite();

    @Transactional
    @Modifying
    @Query(value = "update ViewWebsite set Quantity +=1", nativeQuery = true)
    void updateQuantity();
}
