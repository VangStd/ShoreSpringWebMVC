/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.repository;

import com.java.entity.CategorieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kyqua
 */
public interface CategorieRepository extends JpaRepository<CategorieEntity, Long> {
    
    @Query(value = "select c.ID from Categorie c where c.CateName= ?1",nativeQuery = true)
    String getCateNameByName(String CateName);
}
