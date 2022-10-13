/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.service;

import com.java.entity.OrderDetailEntity;
import com.java.entity.OrderEntity;
import javax.transaction.Transactional;

/**
 *
 * @author kyqua
 */
public interface OrderService {

    void save(OrderEntity entity);

    @Transactional
    void save(OrderEntity orderEntity, OrderDetailEntity detailEntity);
}
