/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.service.impl;

import com.java.entity.OrderDetailEntity;
import com.java.repository.OrderDetailRepository;
import com.java.repository.OrderRepository;
import com.java.service.OrderDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyqua
 */
@Service
public class OrderDetailServiceimpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void save(OrderDetailEntity orderDetailEntity) {
        orderDetailRepository.save(orderDetailEntity);
    }

    @Override
    public List<OrderDetailEntity> getAllOrderdetailsByCusID(long cusId) {
        return orderDetailRepository.getAllOrderdetailsByCusID(cusId);
    }

    @Override
    public double getSaleOfMonth(String month) {
        int count = orderDetailRepository.getCountSaleByMonth(month);
        if (count > 0) {
            return orderDetailRepository.getSaleOfMonth(month);
        } else {
            return 0;
        }
    }

    @Override
    public double getSumTotalPrice() {
        return orderDetailRepository.getSumTotalPrice();
    }

    @Override
    public List<OrderDetailEntity> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public void deleteByOrderId(long l) {
        orderDetailRepository.deleteByOrderId(l);
        orderRepository.deleteById(l);
    }

    @Override
    public List<OrderDetailEntity> getTop3ProductMonth(String string) {
        return orderDetailRepository.getTop3ProductMonth(string);
    }

    @Override
    public int getCountTotalOrder() {
        return orderDetailRepository.getCountTotalOrder();
    }

    @Override
    public List<OrderDetailEntity> getTopProductOnOrder() {
        return orderDetailRepository.getTopProductOnOrder();
    }

}
