/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.repository;

import com.java.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kyqua
 */

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {

    @Query(value ="select s.CompanyName from Supplier s where s.CompanyName= ?1",nativeQuery = true)
    String getCateNameByName(String CompanyName);
}
