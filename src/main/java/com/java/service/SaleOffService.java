/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.service;

import com.java.entity.SaleOffEntity;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author kyqua
 */
public interface SaleOffService {

    SaleOffEntity findByProID(long ProID);

    List<SaleOffEntity> findAll();

    List<SaleOffEntity> findAllByStatusSaleEqual1();

    List<SaleOffEntity> findAllByEndDate(Date endDate);

    void save(SaleOffEntity entity);

    void deleteByID(long ID);

    SaleOffEntity findById(long ID);

    void deleteByEndDate(Date date);

    void updateStatusById(long id);

    @Transactional
    void updateStatusByEnddate();

}
