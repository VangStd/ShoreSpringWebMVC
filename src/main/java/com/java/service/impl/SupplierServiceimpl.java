/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.service.impl;

import com.java.entity.SupplierEntity;
import com.java.repository.SupplierRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyqua
 */
@Service
public class SupplierServiceimpl implements com.java.service.SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<SupplierEntity> findAll() {
        return (List<SupplierEntity>) supplierRepository.findAll();
    }

    @Override
    public SupplierEntity findById(long ID) {
        return supplierRepository.findById(ID).get();
    }

    @Override
    public void save(SupplierEntity supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void Delete(long ID) {
        supplierRepository.deleteById(ID);
    }

    @Override
    public int checkName(String CompanyName) {
        String Name = supplierRepository.getCateNameByName(CompanyName);
        return Name!=null ? 2 : 1;
    }

}
