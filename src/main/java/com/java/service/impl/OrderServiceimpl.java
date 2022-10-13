/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.service.impl;

import com.java.entity.OrderDetailEntity;
import com.java.entity.OrderEntity;
import com.java.repository.OrderDetailRepository;
import com.java.repository.OrderRepository;
import com.java.repository.ProductRepository;
import com.java.repository.ShopCartRepository;
import com.java.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyqua
 */
@Service
public class OrderServiceimpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShopCartRepository cartRepository;

    @Override
    public void save(OrderEntity entity) {
        orderRepository.save(entity);
    }

    @Override
    public void save(OrderEntity entity, OrderDetailEntity orderDetailEntity) {
        orderRepository.save(entity);
        orderDetailEntity.setOrders(entity);
        orderDetailRepository.save(orderDetailEntity);
        productRepository.updateQuantityByProID(orderDetailEntity.getQuantity(), orderDetailEntity.getQuantity(), orderDetailEntity.getProductod().getProID());
        cartRepository.updateStatusByCuidandProid(entity.getCutomers().getCusID(), orderDetailEntity.getProductod().getProID());
    }

}
