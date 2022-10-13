/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.service.impl;

import com.java.entity.ImageProductEntity;
import com.java.repository.ImgProductRepository;
import com.java.service.ImgProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyqua
 */
@Service
public class ImgProductServiceimpl implements ImgProductService {

    @Autowired
    private ImgProductRepository imgProductRepository;

    @Override
    public List<ImageProductEntity> findAll() {
        return imgProductRepository.findAll();
    }

    @Override
    public void save(ImageProductEntity entity) {
        imgProductRepository.save(entity);
    }

    @Override
    public ImageProductEntity findByProId(long l) {
        return imgProductRepository.findByProId(l);
    }

    @Override
    public void deleteByProId(long l) {
        imgProductRepository.deleteByProID(l);
    }

}
