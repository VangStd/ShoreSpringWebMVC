/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.service;

import com.java.entity.CategorieEntity;
import java.util.List;

/**
 *
 * @author kyqua
 */
public interface CategorieService {

    /**
     *
     * @param ID
     * @return object categorie
     */
    CategorieEntity findByID(long ID);

    /**
     *
     * @return list Categorie
     */
    List<CategorieEntity> findAll();

    /**
     * 
     * @param categorie 
     */
    void save(CategorieEntity categorie);

    /**
     *
     * @param ID delete categorie
     */
    void deleteById(long ID);

    int checkName(String CateName);
}
