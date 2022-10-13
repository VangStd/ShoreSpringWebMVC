/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.service.impl;

import com.java.entity.SaleOffEntity;
import com.java.repository.ProductRepository;
import com.java.repository.SaleOffRepository;
import com.java.service.SaleOffService;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyqua
 */
@Service
public class SaleOffServiceimpl implements SaleOffService {

    @Autowired
    private SaleOffRepository saleOffRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public SaleOffEntity findById(long l) {
        return saleOffRepository.findById(l).get();
    }

    @Override
    public List<SaleOffEntity> findAll() {
        return saleOffRepository.findAll();
    }

    @Override
    public List<SaleOffEntity> findAllByStatusSaleEqual1() {
        return saleOffRepository.findAllByStatusSaleEqual1();
    }

    @Override
    public List<SaleOffEntity> findAllByEndDate(Date date) {
        return saleOffRepository.findAllByEndDate(date);
    }

    @Override
    public SaleOffEntity findByProID(long ProID) {
        return saleOffRepository.findByProID(ProID);
    }

    @Override
    public void save(SaleOffEntity soe) {
        saleOffRepository.save(soe);
    }

    @Override
    public void deleteByID(long ID) {
        saleOffRepository.deleteById(ID);
    }

    @Override
    public void deleteByEndDate(Date date) {
        saleOffRepository.deleteByEndDate(date);
    }

    @Override
    public void updateStatusById(long id) {
        saleOffRepository.updateStatusById(id);
    }

    @Override
    public void updateStatusByEnddate() {
        LocalDate localDate = LocalDate.now();
        Date dateNow = java.sql.Date.valueOf(localDate);
        List<SaleOffEntity> list = saleOffRepository.findAllByEndDate(dateNow);
        for (SaleOffEntity saleOffEntity : list) {
            if (saleOffEntity != null) {
                productRepository.updateStatusSaleById(saleOffEntity.getProducts().getProID());
                saleOffRepository.updateStatusByEnddate(dateNow, saleOffEntity.getEndDate());
            }
        }

    }

}
