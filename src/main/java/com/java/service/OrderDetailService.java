/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.service;

import com.java.entity.OrderDetailEntity;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author kyqua
 */
public interface OrderDetailService {

    void save(OrderDetailEntity orderDetailEntity);

    List<OrderDetailEntity> getAllOrderdetailsByCusID(long cusId);

    double getSaleOfMonth(String month);

    int getCountTotalOrder();

    List<OrderDetailEntity> findAll();
    
    double getSumTotalPrice();

    @Transactional
    void deleteByOrderId(long orderid);

    List<OrderDetailEntity> getTop3ProductMonth(String month);

    List<OrderDetailEntity> getTopProductOnOrder();
}
