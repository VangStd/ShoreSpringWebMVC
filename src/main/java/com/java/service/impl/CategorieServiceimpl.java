/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.service.impl;

import com.java.entity.CategorieEntity;
import com.java.repository.CategorieRepository;
import com.java.service.CategorieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyqua
 */
@Service
public class CategorieServiceimpl implements CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public CategorieEntity findByID(long ID) {
        return categorieRepository.findById(ID).get();
    }

    @Override
    public List<CategorieEntity> findAll() {
        return categorieRepository.findAll();
    }

    @Override
    public void save(CategorieEntity categorie) {
        categorieRepository.save(categorie);
    }

    @Override
    public void deleteById(long ID) {
        categorieRepository.deleteById(ID);
    }

    @Override
    public int checkName(String CateName) {
        String Name = categorieRepository.getCateNameByName(CateName);
        return Name != null ? 2 : 1;
    }

}
