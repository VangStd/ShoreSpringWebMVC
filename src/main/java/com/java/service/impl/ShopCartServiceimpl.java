/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.service.impl;

import com.java.entity.ShopCartEntity;
import com.java.repository.ShopCartRepository;
import com.java.service.ShopCartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyqua
 */
@Service
public class ShopCartServiceimpl implements ShopCartService {

    @Autowired
    private ShopCartRepository cartRepository;

    @Override
    public ShopCartEntity findByProIDandCusID(long l, long l1) {
        return cartRepository.findByProIDandCusID(l, l1);
    }

    @Override
    public List<ShopCartEntity> findAllByStatus(long CusID) {
        return cartRepository.findAllByStatus(CusID);
    }

    @Override
    public List<ShopCartEntity> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public void save(ShopCartEntity entity) {
        int countShopCart = cartRepository.getCountByProidAndCusid(entity.getProductss().getProID(), entity.getCustomers().getCusID());
        if (countShopCart > 0) {
            cartRepository.updateQuantityByProidAndCusid(entity.getProductss().getProID(), entity.getCustomers().getCusID());
        } else {
            cartRepository.save(entity);
        }
    }

    @Override
    public void updateQuantityByAjax(int i, long l, long l1) {
        cartRepository.updateQuantityByAjax(i, l, l1);
    }

    @Override
    public void updateStatusById(long l) {
        cartRepository.updateStatusById(l);
    }

    @Override
    public void updateStatusByCusid(long l) {
        cartRepository.updateStatusByCusid(l);
    }

    @Override
    public void deleteByIdAndStatus(long ID) {
        cartRepository.deleteByIdAndStatus(ID);
    }

    @Override
    public void deleteByCusidAndStatus(long l) {
        cartRepository.deleteByCusidAndStatus(l);
    }

    @Override
    public int getCountByCusID(long l) {
        return cartRepository.getCountByCusID(l);
    }

}
