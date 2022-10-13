/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.service;

import com.java.entity.ImageProductEntity;
import java.util.List;

/**
 *
 * @author kyqua
 */
public interface ImgProductService {

    List<ImageProductEntity> findAll();

    void save(ImageProductEntity entity);

    ImageProductEntity findByProId(long ProID);
    
    void deleteByProId(long ProID);
}
