/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.service;

import com.java.entity.ShopCartEntity;
import java.util.List;

/**
 *
 * @author kyqua
 */
public interface ShopCartService {

    ShopCartEntity findByProIDandCusID(long ProID, long CusID);

    List<ShopCartEntity> findAll();

    List<ShopCartEntity> findAllByStatus(long CusID);
    
    int getCountByCusID(long CusID);

    void save(ShopCartEntity entity);

    void updateQuantityByAjax(int Quantity, long ProID, long CusID);

    void updateStatusById(long ID);

    void updateStatusByCusid(long CusID);

    void deleteByIdAndStatus(long ID);

    void deleteByCusidAndStatus(long CusID);
}
